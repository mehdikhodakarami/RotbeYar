package com.rotbeyar.app.data.repository.expetion

open class AppBaseException(message: String) : Exception(message)

class NetworkException(message: String) : AppBaseException(message)
class InvalidCredentialsException(message: String) : AppBaseException(message)
class UserNotFoundException(message: String) : AppBaseException(message)
class GenericErrorException(message: String) : AppBaseException(message)