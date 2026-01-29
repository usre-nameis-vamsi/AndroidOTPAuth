package com.example.lokalappandrioddevelopment.data

data class OtpData(
    val otp: String,
    val generatedAt: Long,
    var attemptsLeft: Int = 3
)
