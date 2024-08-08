package com.jbotgil.tarjetapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbotgil.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaPresentacionTheme {
                vista()
            }
        }
    }
}

@Composable
fun vista() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(210, 232, 212))
    ) {
        Cabecera(nombreCompleto = stringResource(R.string.Nombre), titulo = stringResource(R.string.titulo), modifier = Modifier.weight(1.5f))
        Contacto(telefono = stringResource(R.string.telefono), github = stringResource(R.string.github), mail = stringResource(
            R.string.mail
        ), modifier = Modifier.weight(0.3f))
    }
}

@Composable
fun Cabecera(nombreCompleto: String, titulo: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val imagen = painterResource(R.drawable.profile)

        Image(
            painter = imagen,
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.padding(top = 12.dp))

        Text(
            text = nombreCompleto,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color(8, 26, 14)
        )

        Text(
            text = titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color(0, 105, 53)
        )
    }
}

@Composable
fun Contacto(telefono: String, github: String, mail: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            val githubIcon = painterResource(id = R.drawable.github)
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = telefono)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(painter = githubIcon, contentDescription = null, Modifier.size(25.dp))
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = github)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Email, contentDescription = null)
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = mail)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    vista()
}
