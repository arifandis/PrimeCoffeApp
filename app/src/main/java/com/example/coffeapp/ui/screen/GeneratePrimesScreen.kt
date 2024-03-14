package com.example.coffeapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeapp.R

@Composable
fun GeneratePrimesScreen() {
    var numberValue by remember { mutableStateOf("") }
    val primesNumber = remember { mutableStateListOf<Int>() }

    fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    fun generatePrimesNumber() {
        primesNumber.clear()
        var limit = 2
        if (numberValue.isNotEmpty() && numberValue.toInt() > 0) {
            limit = numberValue.toInt()
        }
        val primes = mutableListOf<Int>()
        for (i in 2..limit) {
            if (isPrime(i)) {
                primes.add(i)
            }
        }
        primesNumber.addAll(primes)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_coffee_shop),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Test Apps",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Bilangan Prima",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Masukkan angka untuk menghasilkan bilangan prima",
            fontSize = 12.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Input Angka",
            fontSize = 12.sp,
            color = Color.Gray
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedTextColor = Color.Black
            ),
            value = numberValue,
            onValueChange = { numberValue = it },
            placeholder = {
                Text(
                    text = "0", color = Color.Gray
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { generatePrimesNumber() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "GENERATE BILANGAN PRIMA", fontSize = 18.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(30.dp))
        if (primesNumber.isNotEmpty()) {
            Text(
                text = "Bilangan prima sampai dengan $numberValue adalah: ${primesNumber.joinToString()}",
                color = Color.Black
            )
        }
    }
}