package com.example.safetravel.presentation.viewmodel.model

data class AuthenticationUiState(
    val hasAuthenticationMethod: Boolean = true,
    val hasPIN: Boolean = false,
    val enteredPIN: String = "",
    val isError: Boolean = false,
    val isAuthenticated: Boolean = false,
)
