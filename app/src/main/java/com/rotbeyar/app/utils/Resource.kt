package com.rotbeyar.app.utils

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    /**
     * Represents a successful operation.
     * @param data The actual data returned by the operation.
     */
    class Success<T>(data: T) : Resource<T>(data)

    /**
     * Represents a failed operation.
     * @param message The error message explaining why the operation failed.
     * @param data Optional data that might still be available (e.g., cached data).
     */
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    /**
     * Represents an ongoing operation (loading state).
     * @param data Optional data that might be displayed while loading (e.g., previously loaded content).
     */
    class Loading<T>(data: T? = null) : Resource<T>(data)

    // Optionally, you can add an Idle state if you need to represent
    // that no operation is currently in progress and no previous result exists.
    // class Idle<T> : Resource<T>()
}