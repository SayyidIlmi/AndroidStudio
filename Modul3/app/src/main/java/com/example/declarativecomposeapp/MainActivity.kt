package com.example.declarativecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.declarativecomposeapp.screen.ChangeTextScreen
import com.example.declarativecomposeapp.screen.EventState1
import com.example.declarativecomposeapp.screen.EventStateTest
import com.example.declarativecomposeapp.screen.ImplicitIntentTest
import com.example.declarativecomposeapp.screen.ShopCheck
import com.example.declarativecomposeapp.ui.theme.DeclarativeComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//2            EventStateTest()
//1            ChangeTextScreen()
//3            EventState1()
            ShopCheck()
            //4
//            val context = LocalContext.current
//            ImplicitIntentTest(context)
        }
    }
}
