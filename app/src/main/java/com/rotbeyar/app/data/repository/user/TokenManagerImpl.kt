package com.rotbeyar.app.data.repository.user

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.auth0.jwt.JWT
import com.auth0.jwt.exceptions.JWTDecodeException
import com.auth0.jwt.interfaces.DecodedJWT
import com.rotbeyar.app.domain.model.Tokens
import com.rotbeyar.app.domain.model.user.UserPayload
import com.rotbeyar.app.domain.repository.TokenManagerRepository
import com.rotbeyar.app.utils.ErrorHandler
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.util.Date
import java.util.concurrent.atomic.AtomicReference
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_prefs")

class TokenManagerImpl @Inject constructor(
    handler: ErrorHandler,
    @ApplicationContext private val context: Context
): TokenManagerRepository {

    companion object {
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
        private const val TAG = "TokenManager"
    }

    private val dataStore = context.dataStore
    private val lock = Mutex()
    private val latestAccessToken = AtomicReference<String?>(null)
    private val latestRefreshToken = AtomicReference<String?>(null)

    override suspend fun saveTokens(tokens: Tokens) {



        lock.withLock {
            latestAccessToken.set(tokens.accessToken)
            latestRefreshToken.set(tokens.refreshToken)
            dataStore.edit { preferences ->
                preferences[ACCESS_TOKEN_KEY] = tokens.accessToken
                preferences[REFRESH_TOKEN_KEY] = tokens.refreshToken
            }
        }
    }

    override suspend fun getAccessToken(): String? {
        return lock.withLock {
            latestAccessToken.get() ?: run {
                val token = dataStore.data.first()[ACCESS_TOKEN_KEY]
                latestAccessToken.set(token)
                token
            }
        }
    }

    override suspend fun getRefreshToken(): String? {
        return lock.withLock {
            latestRefreshToken.get() ?: run {
                val token = dataStore.data.first()[REFRESH_TOKEN_KEY]
                latestRefreshToken.set(token)
                token
            }
        }
    }

   override suspend fun updateAccessToken(newAccessToken: String) {
        lock.withLock {
            latestAccessToken.set(newAccessToken)
            dataStore.edit { preferences ->
                preferences[ACCESS_TOKEN_KEY] = newAccessToken
            }
        }
    }

    override suspend fun updateRefreshToken(newRefreshToken: String) {
        lock.withLock {
            latestRefreshToken.set(newRefreshToken)
            dataStore.edit { preferences ->
                preferences[REFRESH_TOKEN_KEY] = newRefreshToken
            }
        }
    }

    override fun isTokenExpired(token: String?): Boolean {
        if (token.isNullOrBlank()) return true

        return try {
            val decoded: DecodedJWT = JWT.decode(token)
            decoded.expiresAt?.before(Date()) ?: true
        } catch (e: JWTDecodeException) {
            Log.e(TAG, "Failed to decode token for expiry check", e)
            true
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error checking token expiry", e)
            true
        }
    }



    override suspend fun decodeAccessToken(): UserPayload? {


        val token = latestAccessToken.get() ?: return null
        if (token.isBlank()) {
            Log.w(TAG, "Attempted to decode blank token")
            return null
        }

        return try {
            val decoded: DecodedJWT = JWT.decode(token)

            if (decoded.expiresAt?.before(Date()) == true) {
                Log.w(TAG, "Token is expired")
                return null
            }

            val id = decoded.getClaim("id").asLong()
            val firstName = decoded.getClaim("first_name").asString()
            val lastName = decoded.getClaim("last_name").asString()
            val email = decoded.getClaim("email").asString()
            val phone = decoded.getClaim("phone").asString()

            if (id == null) {
                Log.e(TAG, "Token missing required field: id")
                return null
            }

            if (phone.isNullOrBlank()) {
                Log.e(TAG, "Token missing required field: phone")
                return null
            }

            UserPayload(
                userId = id,
                firstName = firstName ?: "",
                lastName = lastName ?: "",
                phone = phone,
                email = email ?: ""
            )
        } catch (e: JWTDecodeException) {
            Log.e(TAG, "JWT decode failed", e)
            null
        } catch (e: Exception) {
            Log.e(TAG, "Unexpected error decoding token", e)
            null
        }
    }

    override suspend fun clearTokens() {
        lock.withLock {
            latestAccessToken.set(null)
            latestRefreshToken.set(null)
            dataStore.edit { it.clear() }
        }
    }

    override suspend fun hasValidToken(): Boolean {
        val token = getAccessToken()
        return token != null && !isTokenExpired(token)
    }
}