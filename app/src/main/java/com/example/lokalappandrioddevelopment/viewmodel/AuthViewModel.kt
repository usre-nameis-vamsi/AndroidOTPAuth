package com.example.lokalappandrioddevelopment.viewmodel

import androidx.compose.runtime.*

import androidx.lifecycle.ViewModel
import com.example.lokalappandrioddevelopment.data.OtpManager

class AuthViewModel : ViewModel() {

    private val otpManager = OtpManager()

    var uiState by mutableStateOf(AuthState())
        private set

    fun sendOtp(email: String) {
        val otp = otpManager.generateOtp(email)

        uiState = uiState.copy(
            email = email,
            otpSent = true,
            generatedOtp = otp,
            error = null
        )
    }

    fun verifyOtp(input: String) {

        val result = otpManager.validateOtp(uiState.email, input)

        if (result.success) {
            uiState = uiState.copy(
                isLoggedIn = true,
                sessionStart = System.currentTimeMillis(),
                error = null
            )
        } else {
            uiState = uiState.copy(
                error = "Wrong OTP",
                attemptsLeft = result.attemptsLeft,
                showReset = result.attemptsLeft == 0
            )
        }
    }

    fun resetOtp() {
        val newOtp = otpManager.generateOtp(uiState.email)

        uiState = uiState.copy(
            generatedOtp = newOtp,
            attemptsLeft = 3,
            showReset = false,
            error = null
        )
    }

    fun logout() {
        uiState = AuthState()
    }
}
