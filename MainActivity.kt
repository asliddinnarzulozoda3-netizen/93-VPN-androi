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

private val Navy = Color(0xFF071426)
private val Blue = Color(0xFF287BFF)
private val Pale = Color(0xFFEAF2FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NinetyThreeScreen() }
    }
}

@Composable
fun NinetyThreeScreen() {
    var language by remember { mutableStateOf("ЎЗ") }
    var selectedServer by remember { mutableStateOf("Автоматик танлаш") }

    MaterialTheme(colorScheme = darkColorScheme(
        primary = Blue,
        background = Navy,
        surface = Color(0xFF10233D)
    )) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Navy, Color(0xFF102B50))))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                TextButton(onClick = {
                    language = when (language) {
                        "ЎЗ" -> "RU"
                        "RU" -> "EN"
                        else -> "ЎЗ"
                    }
                }) { Text(language, color = Pale) }
            }
            Spacer(Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .size(112.dp)
                    .background(Brush.linearGradient(listOf(Blue, Color(0xFF74C7FF))), RoundedCornerShape(30.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("93", color = Color.White, fontSize = 48.sp, fontWeight = FontWeight.Black)
            }
            Spacer(Modifier.height(14.dp))
            Text("93 VPN", color = Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Text("FAST • SAFE • GLOBAL", color = Color(0xFF9DBCE8), fontSize = 11.sp)
            Spacer(Modifier.height(42.dp))

            Box(
                Modifier.size(190.dp).background(Color(0xFF15345A), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("ҲОЗИРЧА", color = Color(0xFF9DBCE8), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Text("УЛАНМАГАН", color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                }
            }
            Spacer(Modifier.height(18.dp))
            Text(
                "Синов интерфейси. VPN серверлари ҳали уланмаган.",
                color = Color(0xFFB8CBE4),
                fontSize = 12.sp
            )
            Spacer(Modifier.height(30.dp))

            Text("СЕРВЕР", color = Color(0xFF9DBCE8), fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            var expanded by remember { mutableStateOf(false) }
            Box {
                OutlinedButton(
                    onClick = { expanded = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) { Text(selectedServer + "  ▾") }
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    listOf("Автоматик танлаш", "Германия", "Нидерландия").forEach { item ->
                        DropdownMenuItem(text = { Text(item) }, onClick = {
                            selectedServer = item
                            expanded = false
                        })
                    }
                }
            }
            Spacer(Modifier.height(20.dp))
            Button(
                onClick = { },
                enabled = false,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(16.dp)
            ) { Text("СЕРВЕР ТАЙЁР БЎЛГАНДА УЛАНИШ") }

            Spacer(Modifier.weight(1f))
            Text("Android прототип • 0.1.0", color = Color(0xFF7794BA), fontSize = 11.sp)
        }
    }
}
