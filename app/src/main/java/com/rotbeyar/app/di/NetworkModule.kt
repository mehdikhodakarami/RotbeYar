package com.rotbeyar.app.di

import com.rotbeyar.app.data.remote.TokenAuthenticator
import com.rotbeyar.app.data.remote.api.AuthApiService
import com.rotbeyar.app.data.remote.api.UserApiService
import com.rotbeyar.app.data.remote.interceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    private const val BASE_URL = "https://roteyar.liara.run/"



    @Provides
    @Singleton
    @Named("MainOkHttp")
    fun provideMainOkHttpClient(
        authInterceptor: AuthInterceptor,
        tokenAuthenticator: TokenAuthenticator
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(authInterceptor)
            .authenticator(tokenAuthenticator)
            .build()
    }

    @Provides
    @Singleton
    fun provideMainRetrofit(
        @Named("MainOkHttp") okHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()




    @Provides
    @Singleton
    @Named("RefreshOkHttp")
    fun provideRefreshOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    @Named("RefreshRetrofit")
    fun provideRefreshRetrofit(
        @Named("RefreshOkHttp") okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRefreshAuthApi(
        @Named("RefreshRetrofit") retrofit: Retrofit
    ): AuthApiService = retrofit.create(AuthApiService::class.java)


    @Provides
    @Singleton
    fun provideMainAuthApi(
retrofit: Retrofit
    ): UserApiService = retrofit.create(UserApiService::class.java)
}





