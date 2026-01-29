
package com.example.lokalappandrioddevelopment.ui
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lokalappandrioddevelopment.viewmodel.AuthViewModel

@Composable
fun LoginScreen(vm: AuthViewModel) {

    var email by rememberSaveable { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(Modifier.height(16.dp))

        Button(onClick = { vm.sendOtp(email) }) {
            Text("Send OTP")
        }
    }
}
