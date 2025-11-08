package com.rotbeyar.app.di

import com.rotbeyar.app.data.repository.auth.AuthRepoImpl
import com.rotbeyar.app.data.repository.user.TokenManagerImpl
import com.rotbeyar.app.data.repository.user.UserRepoImpl
import com.rotbeyar.app.domain.repository.AuthRepository
import com.rotbeyar.app.domain.repository.TokenManagerRepository
import com.rotbeyar.app.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

   @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepoImpl): AuthRepository
    @Binds
    abstract fun bindTokenManagerRepository(tokenManager : TokenManagerImpl): TokenManagerRepository
    @Binds
   abstract fun bindUserRepository(userRepositoryImpl: UserRepoImpl): UserRepository


}