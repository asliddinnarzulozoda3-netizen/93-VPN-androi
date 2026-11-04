package com.ninetythree.vpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VPNApp()
        }
    }
}

@Composable
fun VPNApp() {
    var connected by remember { mutableStateOf(false) }
    var server by remember { mutableStateOf("Автоматик танлаш") }
    var expanded by remember { mutableStateOf(false) }

    val navy = Color(0xFF071426)
    val blue = Color(0xFF287BFF)

    MaterialTheme(colorScheme = darkColorScheme(primary = blue)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(navy, Color(0xFF102B50))
                    )
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(30.dp))

            Text(
                "93 VPN",
                color = Color.White,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Text("FAST • SAFE • GLOBAL", color = Color.LightGray)

            Spacer(Modifier.height(65.dp))

            Box(
                Modifier
                    .size(190.dp)
                    .background(Color(0xFF15345A), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    if (connected) "УЛАНГАН" else "УЛАНМАГАН",
                    color = Color.White,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(35.dp))

            Text("СЕРВЕР", color = Color.LightGray)

            Box {
                OutlinedButton(
                    onClick = { expanded = true }
                ) {
                    Text(server, color = Color.White)
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listOf(
                        "Автоматик танлаш",
                        "Германия",
                        "Нидерландия"
                    ).forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                server = it
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = { connected = !connected },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    if (connected) "УЗИШ" else "УЛАНИШ"
                )
            }

            Spacer(Modifier.weight(1f))

            Text(
                "93 VPN • Version 1.0",
                color = Color.LightGray
            )
        }
    }
}
