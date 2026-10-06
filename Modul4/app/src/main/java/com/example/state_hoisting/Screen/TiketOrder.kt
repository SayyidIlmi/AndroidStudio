package com.example.state_hoisting.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay



@Composable
fun TicketOrderScreen() {
    var hargaTiket by remember { mutableStateOf(75000) }
    var jumlahTiket by remember { mutableStateOf(1) }
    var namaPembeli by remember { mutableStateOf("") }
    var triggerPesan by remember { mutableStateOf(0) }
    var isProcessing by remember { mutableStateOf(false) }
    var statusMessage by remember { mutableStateOf("Silakan pesan tiket") }

    LaunchedEffect(triggerPesan) {
        if (triggerPesan > 0) {
            if (namaPembeli.isBlank()) {
                statusMessage = "Nama masih kosong"
            } else {
                isProcessing = true
                statusMessage = "Memproses pesanan....."
                delay(5000)
                isProcessing = false
                statusMessage = "Tiket telah dipesan"
            }
        }
    }
    TicketOrderContent(
        harga = hargaTiket,
        jumlah = jumlahTiket,
        nama = namaPembeli,
        status = statusMessage,
        isProcessing = isProcessing,
        onJumlahKurang = { if (jumlahTiket > 1) jumlahTiket-- },
        onJumlahTambah = { jumlahTiket++ },
        onNamaChange = { input ->
            namaPembeli = input
            if (statusMessage == "Nama masih kosong") {
                statusMessage = "Silakan pesan tiket"
            }
        },
        onPesanClick = { triggerPesan++ }
    )
}
@Composable
fun TicketOrderContent(
    harga: Int,
    jumlah: Int,
    nama: String,
    status: String,
    isProcessing: Boolean,
    onJumlahKurang: () -> Unit,
    onJumlahTambah: () -> Unit,
    onNamaChange: (String) -> Unit,
    onPesanClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "Pemesanan Tiket",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Nama", fontWeight = FontWeight.Medium)
        OutlinedTextField(
            value = nama,
            onValueChange = onNamaChange,
            placeholder = { Text("Masukkan nama Anda") },
            singleLine = true,
            enabled = !isProcessing,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Harga Tiket", fontWeight = FontWeight.Medium)
        Text(text = "Rp$harga / tiket", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Jumlah Tiket", fontWeight = FontWeight.Medium)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Button(onClick = onJumlahKurang, enabled = !isProcessing) {
                Text("-")
            }
            Text(
                text = "$jumlah",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Button(onClick = onJumlahTambah, enabled = !isProcessing) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Total: Rp${harga * jumlah}",
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onPesanClick,
            enabled = !isProcessing,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (isProcessing) "Memproses..." else "Pesan Tiket")
        }

        Spacer(modifier = Modifier.height(16.dp))

        val statusColor = when {
            status == "Nama masih kosong" -> Color(0xFFC62828)
            status == "Tiket telah dipesan" -> Color(0xFF2E7D32)
            isProcessing -> Color(0xFF1565C0)
            else -> Color.DarkGray
        }
        Text(
            text = "Status: $status",
            color = statusColor,
            fontWeight = FontWeight.Medium
        )
    }
}