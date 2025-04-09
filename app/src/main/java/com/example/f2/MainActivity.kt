package com.example.f2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.f2.data.Pilot
import com.example.f2.ui.theme.F2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F2Theme {
                Surface(
                    modifier = Modifire.fillMaxSize()
                ){

                }

            }
        }
    }
}

@Composable
fun F2App(){

    LazyColumn{
        items(pilots){
            PilotItem(pilot=it)
        }
    }

}

@Composable
fun PilotItem(
    pilot: Pilot,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_small))
    ) {
        PilotIcon(pilot.imageResourceId)
        PilotInformation(pilot.name, pilot.teams)
    }
}

fun PilotIcon(
    @DrawableRes pilotIcon: Int,
    modifier: Modifier = Modifier
){


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    F2Theme {
        Greeting("Android")
    }
}