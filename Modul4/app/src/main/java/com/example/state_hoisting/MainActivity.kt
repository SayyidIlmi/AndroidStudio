package com.example.state_hoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.example.state_hoisting.Screen.TicketOrderScreen
import com.example.state_hoisting.Screen.CounterScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MaterialTheme {
//                val snackbarHostState = remember { SnackbarHostState() }
//                var number by rememberSaveable { mutableStateOf(1) }
//
//                LaunchedEffect(number) {
//                    snackbarHostState.showSnackbar("Number $number is shown!")
//                }
//
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
//                ) { innerPadding ->
//                    Surface(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(innerPadding)
//                    ) {
//                        CounterScreen(
//                            modifier = Modifier.padding(32.dp),
//                            number = number,
//                            label = "Double",
//                            onButtonClick = { number *= 2 }
//                        )
//                    }
//                }
//            }
            TicketOrderScreen()
        }
    }
}
