package com.example.lokalappandrioddevelopment.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.lokalappandrioddevelopment.viewmodel.AuthViewModel

@Composable
fun SessionScreen(vm: AuthViewModel) {

    val start = vm.uiState.sessionStart ?: return
    var seconds by remember { mutableStateOf(0L) }

    LaunchedEffect(start) {
        while (vm.uiState.isLoggedIn) {
            delay(1000)
            seconds++
        }
    }

    Column(Modifier.padding(16.dp)) {

        Text("Duration: ${seconds / 60}:${seconds % 60}")

        Spacer(Modifier.height(16.dp))

        Button(onClick = { vm.logout() }) {
            Text("Logout")
        }
    }
}
