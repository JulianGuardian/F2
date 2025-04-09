package com.example.f2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.f2.data.Pilot
import com.example.f2.data.pilot
import com.example.f2.ui.theme.F2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ){
                    F2App()
                }

            }
        }
    }
}

@Composable
fun F2App(){
    Scaffold(
        topBar= {F2TopBar()}
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(pilot) {
                PilotItem(
                    pilot = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun PilotItem(
    pilot: Pilot,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            PilotIcon(pilot.imageResourceId)
            PilotInformation(pilot.name, pilot.teams)
        }
    }


}

@Composable
fun PilotIcon(
    @DrawableRes pilotIcon: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(pilotIcon),

        contentDescription = null
    )

}

@Composable
fun PilotInformation(
    @StringRes pilotName: Int,
    @StringRes pilotTeam: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(pilotName),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(pilotTeam),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun F2Preview() {
    F2Theme(darkTheme = true) {
        F2App()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun F2TopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(200.dp),
                    painter = painterResource(R.drawable.logo_alt_f1),

                    contentDescription = null
                )
            }
        },
        modifier = modifier
    )


    @Composable
    fun CustomFAB(onClick: () -> Unit) {
        FloatingActionButton(
            onClick = onClick,
            containerColor = Color(0xFFD3F1DF), // Verde muy claro (puedes ajustarlo)
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp),
            modifier = Modifier
                .size(56.dp) // Tamaño del botón
                .border(
                    width = 1.dp,
                    color = Color.Black, // Borde negro
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = Icons.Default.Add, // Ícono "+"
                contentDescription = "Agregar",
                tint = Color.Black // Color del ícono
            )
        }
    }


}