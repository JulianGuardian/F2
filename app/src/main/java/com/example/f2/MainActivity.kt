package com.example.f2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.f2.ui.theme.F2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F2Theme {

            }
        }
    }
}

@Composable
fun Input( label: String, modifier: Modifier = Modifier) {
    var text by remember {
        mutableStateOf(label)
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = label,
            modifier = Modifier.padding(8.dp)
        )
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = modifier
        )
    }
}

@Composable
fun CreatePilot(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_alt_f1),
            contentDescription = null,
            modifier = modifier
        )

        Image(
            painter = painterResource(id = R.drawable.default_profile_picture),
            contentDescription = null,
            modifier = modifier
        )

        Input(
            label = stringResource(R.string.Text_1),
            modifier = modifier
        )

        Input(
            label = stringResource(R.string.Text_2),
            modifier = modifier
        )

        Button(
            onClick = {
                // Handle button click
            }
        ) {
            Text(
                text = stringResource(R.string.Button_1),
                modifier = modifier
            )
        }

        Button(
            onClick = {
                // Handle button click
            }
        ) {
            Text(
                text = stringResource(R.string.Button_2),
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    F2Theme {
        CreatePilot(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}