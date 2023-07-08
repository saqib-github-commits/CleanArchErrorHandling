package com.cleanarch.errorhandling.ui.common

sealed class UiDataState<T> {
    class Loading<T>: UiDataState<T>()
    data class Error<T>(val error: ErrorText) : UiDataState<T>()
    data class Loaded<T>(val data: T): UiDataState<T>()
}