package com.example.lokalappandrioddevelopment.data

data class ValidationResult(
    val success: Boolean,
    val attemptsLeft: Int,
    val expired: Boolean = false
)

class OtpManager {

    private val store = mutableMapOf<String, OtpData>()
    private val expiryMillis = 60_000L

    fun generateOtp(email: String): String {
        val otp = (100000..999999).random().toString()
        store[email] = OtpData(otp, System.currentTimeMillis(), 3)
        return otp
    }

    fun validateOtp(email: String, input: String): ValidationResult {

        val data = store[email] ?: return ValidationResult(false, 0, true)

        if (System.currentTimeMillis() - data.generatedAt > expiryMillis) {
            store.remove(email)
            return ValidationResult(false, 0, true)
        }

        if (data.otp == input) {
            store.remove(email)
            return ValidationResult(true, 3)
        }

        data.attemptsLeft--

        if (data.attemptsLeft <= 0) {
            store.remove(email)
            return ValidationResult(false, 0)
        }

        return ValidationResult(false, data.attemptsLeft)
    }
}
