package com.example.lokalappandrioddevelopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import com.example.lokalappandrioddevelopment.viewmodel.AuthViewModel
import com.example.lokalappandrioddevelopment.ui.LoginScreen
import com.example.lokalappandrioddevelopment.ui.OtpScreen
import com.example.lokalappandrioddevelopment.ui.SessionScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppRoot()
        }
    }
}

@Composable
fun AppRoot(vm: AuthViewModel = viewModel()) {
    when {
        vm.uiState.isLoggedIn -> SessionScreen(vm)
        vm.uiState.otpSent -> OtpScreen(vm)
        else -> LoginScreen(vm)
    }

}
