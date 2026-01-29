package com.example.lokalappandrioddevelopment.viewmodel

data class AuthState(
    val email: String = "",
    val otpSent: Boolean = false,
    val isLoggedIn: Boolean = false,
    val error: String? = null,
    val sessionStart: Long? = null,
    val generatedOtp: String? = null,
    val attemptsLeft: Int = 3,
    val showReset: Boolean = false
)
