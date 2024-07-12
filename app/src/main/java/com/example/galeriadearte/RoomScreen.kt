package com.example.galeriadearte

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.io.File

@Composable
fun RoomScreen(navController: NavController) {
    // Estado para almacenar la posición del círculo
    var circlePosition by remember { mutableStateOf(Offset(0f, 0f)) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0099FF))
            .padding(0.dp) // Ajusta el padding según sea necesario
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF0099FF))
                    .padding(16.dp) // Ajusta el padding según sea necesario
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    // Canvas para dibujar el rectángulo negro y el círculo
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(0.dp)
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            val padding = 0.dp.toPx() // Ajusta el padding según sea necesario

                            // Rectángulo 1 (Salón 1)
                            drawRect(
                                color = Color.Blue,
                                topLeft = Offset(padding, padding),
                                size = Size(
                                    size.width / 3 - padding * 1.5f,
                                    size.height / 2 - padding * 1.5f
                                )
                            )

                            // Cuadrado 2 (Salón 2)
                            drawRect(
                                color = Color.Black,
                                topLeft = Offset(padding, size.height / 2 + padding / 2),
                                size = Size(
                                    size.width / 3 - padding * 1.5f,
                                    size.width / 2 - padding * 1.5f
                                )
                            )


                            // Rectángulo 3 (Salón 3)
                            drawRect(
                                color = Color.Red,
                                topLeft = Offset(padding + size.width / 3, size.height / 2 + padding / 2), // Comienza al lado del Salón 2
                                size = Size((size.width * 2 / 3) - padding * 1.5f, size.width / 2 - padding * 1.5f)

                            )

                            // Círculo 1 en Salón 1
                            drawCircle(
                                color = Color.Green,
                                radius = 25f,
                                center = Offset(size.width / 4, size.height / 4)
                            )

                            // Círculo 2 en Salón 2
                            drawCircle(
                                color = Color.Green,
                                radius = 25f,
                                center = Offset(size.width / 4, size.height * 3 / 4)
                            )
                            // Círculo 2 en Salón 2
                            drawCircle(
                                color = Color.Green,
                                radius = 25f,
                                center = Offset(size.width / 2, size.height * 2 / 4)
                            )
                        }
                        // Contenido del perfil (icono de usuario)
                        Icon(
                            painter = painterResource(id = R.drawable.ic_painting),
                            contentDescription = "User Icon",
                            tint = Color.White,
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color(0xFFCC3366))
                                .clickable {
                                    navController.navigate("painting")
                                }
                        )


                    }

                    // Espacio para separar elementos
                    Spacer(modifier = Modifier.height(16.dp))


                }
            }
        }

        fun createRectanglePath(width: Float, height: Float, padding: Float): Path {
            return Path().apply {
                reset()
                moveTo(padding, padding)
                lineTo(width - padding, padding)
                lineTo(width - padding, height - padding)
                lineTo(padding, height - padding)
                close()
            }
        }
    }
}