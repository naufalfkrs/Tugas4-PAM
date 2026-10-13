package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(vm: CalViewModel = viewModel(), name: String, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val input by vm.input.collectAsState()

    Column(modifier = modifier) {
        Text(
            text = "KALKULATOR", textAlign = TextAlign.Center,
            fontSize = 50.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )
        Row(modifier = Modifier.padding(10.dp)) {
            Text(
                text = input,
                textAlign = TextAlign.Right,
                lineHeight = 75.sp,
                fontSize = 60.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .border(
                        BorderStroke(2.dp, Color.Blue),
                        RoundedCornerShape(8.dp)
                    )
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(
                onClick = {vm.onClick("0")}
            ) { Text("0", fontSize = 50.sp) }
            Button(
                onClick = {vm.onClick("1")}
            ) { Text("1", fontSize = 50.sp) }
            Button(
                onClick = {vm.onClick("2")}
            ) { Text("2", fontSize = 50.sp) }
            Button(
                onClick = {vm.onClick("3")}
            ) { Text("3", fontSize = 50.sp) }
        }
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp), horizontalArrangement = Arrangement.SpaceAround) {
            Button(
                onClick = {vm.onClick("4")}
            ) { Text("4", fontSize = 50.sp) }
            Button(
                onClick = {vm.onClick("5")}
            ) { Text("5", fontSize = 50.sp) }
            Button(
                onClick = {vm.onClick("6")}
            ) { Text("6", fontSize = 50.sp) }
            Button(
                onClick = {vm.onClick("7")}
            ) { Text("7", fontSize = 50.sp) }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp),
                onClick = {vm.onClick("8")}
            ) { Text("8", fontSize = 50.sp) }
            Button(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 5.dp),
                onClick = { vm.onClick("9")}
            ) { Text("9", fontSize = 50.sp) }
            Button(
                modifier = Modifier
                    .weight(2f)
                    .padding(horizontal = 5.dp),
                onClick = { vm.onClick("c")}
            ) { Text("C", fontSize = 50.sp, color=Color.Red) }

        }

        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp), horizontalArrangement = Arrangement.SpaceAround) {
            ColoredButton("+", onClick = {vm.onClick("+")})
            ColoredButton("-", onClick = {vm.onClick("-")})
            ColoredButton("*", onClick = {vm.onClick("*")})
            ColoredButton("/", onClick = {vm.onClick("/")})
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {vm.onClick("=")}
            ) { Text("=", fontSize = 70.sp) }
        }
    }
}

@Composable
fun ColoredButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.DarkGray, // Background color
            contentColor = Color.White, // Text/icon color
            disabledContainerColor = Color.Gray, // Disabled background
            disabledContentColor = Color.LightGray // Disabled text/icon color
        )
    ) {
        Text(text, fontSize = 50.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        Greeting(name="Android")
    }
}