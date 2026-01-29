package com.example.lokalappandrioddevelopment.data

class OtpManager {

    private val store = mutableMapOf<String, OtpData>()
    private val expiryMillis = 60_000L

    fun generateOtp(email: String): String {
        val otp = (100000..999999).random().toString()
        store[email] = OtpData(otp, System.currentTimeMillis())
        return otp
    }

    fun validateOtp(email: String, input: String): Boolean {

        val data = store[email] ?: return false

        if (System.currentTimeMillis() - data.generatedAt > expiryMillis) {
            store.remove(email)
            return false
        }

        if (data.attemptsLeft <= 0) {
            store.remove(email)
            return false
        }

        if (data.otp == input) {
            store.remove(email)
            return true
        }

        data.attemptsLeft--
        return false
    }
}
