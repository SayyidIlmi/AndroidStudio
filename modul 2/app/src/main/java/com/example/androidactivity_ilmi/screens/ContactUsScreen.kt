package com.example.androidactivity_ilmi.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactUsScreen() {
    val context = LocalContext.current
    Column(
        modifier =
            Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {
        Text(
            text = "Halaman Bantuan", fontSize =
                24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val url = "https://wa.me/628980235951"
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )
            context.startActivity(intent)
        }) {
            Text("Hubungi via WhatsApp")
        }
    }
}