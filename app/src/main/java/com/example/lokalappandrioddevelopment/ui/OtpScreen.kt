package com.example.lokalappandrioddevelopment.ui

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.lokalappandrioddevelopment.viewmodel.AuthViewModel

@Composable
fun OtpScreen(vm: AuthViewModel) {

    var otp by rememberSaveable { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {

        // Show OTP for testing
        Text("Test OTP: ${vm.uiState.generatedOtp}")

        Spacer(Modifier.height(8.dp))

        TextField(
            value = otp,
            onValueChange = { otp = it },
            label = { Text("Enter OTP") }
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = { vm.verifyOtp(otp) }) {
            Text("Login")
        }

        Spacer(Modifier.height(8.dp))

        // Show remaining attempts
        Text("Attempts left: ${vm.uiState.attemptsLeft}")

        Spacer(Modifier.height(8.dp))

        // Error message
        vm.uiState.error?.let {
            Text(it, color = Color.Red)
        }

        // Reset OTP button after attempts end
        if (vm.uiState.showReset) {
            Spacer(Modifier.height(12.dp))

            Button(onClick = { vm.resetOtp() }) {
                Text("Reset OTP")
            }
        }
    }
}
