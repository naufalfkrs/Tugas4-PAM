package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterScreen(
    viewModel: CounterViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val count by viewModel.count.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 1. Tampilkan Nama dan NIM
        Text(
            text = "Nama: Naufal Fakhri Risnawa",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "NIM: 245150401111040",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Angka Counter
        Text(
            text = "$count",
            fontSize = 80.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(48.dp))

        // 2. Tombol Up & Down
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { viewModel.decrement() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Down", fontSize = 18.sp)
            }

            Button(
                onClick = { viewModel.increment() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Up", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Tombol Reset
        OutlinedButton(
            onClick = { viewModel.reset() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reset", fontSize = 18.sp)
        }
    }
}