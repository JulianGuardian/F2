package com.example.f2

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.f2.data.Pilot
import com.example.f2.data.pilots
import com.example.f2.ui.theme.F2Theme
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.example.f2.ui.theme.Roboto
import com.example.f2.ui.theme.SegoeUI
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import coil.compose.AsyncImage
import coil.request.ImageRequest


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ){
                    AltF1App()
                }

            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AltF1App() {
    var showCreatePilot by remember {
        mutableStateOf(false)
    }

    AnimatedContent(
        targetState = showCreatePilot,
        transitionSpec = {
            fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300))
        },
        label = "AnimatedContent"
    ) { targetState ->
        if(targetState){
            CreatePilot(
                onCancel = { showCreatePilot = false },
                onSave = { name, team, selectedImageUri ->
                    pilots.add(
                        Pilot(selectedImageUri, name, team)
                    )
                    showCreatePilot = false
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        else {
            Scaffold(
                topBar = { F2TopBar() },
                floatingActionButton = {
                    FloatingButton {
                        showCreatePilot = true
                    }
                }
            ) { innerPadding ->
                LazyColumn(contentPadding = innerPadding) {
                    items(pilots) {
                        PilotItem(
                            pilot = it,
                            modifier = Modifier
                                .padding(dimensionResource(R.dimen.padding_small))
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun PilotItem(
    pilot: Pilot,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .border(
                width = 1.dp,
                color=MaterialTheme.colorScheme.inverseSurface,
                shape = RoundedCornerShape(16.dp),

        )

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))

        ) {
            PilotIcon(pilot.imageUri)
            PilotInformation(pilot.name, pilot.teams)
        }
    }


}

@Composable
fun PilotIcon(
    imageUri: Uri?,
    modifier: Modifier = Modifier
){
    AsyncImage(
        model = imageUri,
        contentScale = ContentScale.FillBounds,
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)
    )

}

@Composable
fun PilotInformation(
    pilotName: String,
    pilotTeam: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = pilotName,
            fontFamily = Roboto,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small))

        )
        Text(
            text = pilotTeam,
            fontFamily = SegoeUI,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp
        )
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
        modifier = modifier.padding(
            bottom = 10.dp
        )
    )
}

@Composable
fun FloatingButton(modifier: Modifier=Modifier, onClick: () -> Unit){

    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp),
        containerColor = MaterialTheme.colorScheme.inversePrimary,
        modifier=modifier
            .size(56.dp)
    ) {
        Image(
            modifier = modifier
                .size(42.dp)
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(MaterialTheme.shapes.small),

            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.add),

            contentDescription = null
        )

    }
}


@Composable
fun Input( label: String, value: String, modifier: Modifier = Modifier, onValueChange: (String) -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = label,
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            modifier = modifier
                .align(Alignment.Start)
                .padding(start = 42.dp, bottom = 6.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            placeholder = {
                Text(
                    text = label,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 25.dp)
                .padding(bottom = 25.dp)
        )
    }
}

@Composable
fun CustomButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        modifier = modifier
            .width(220.dp)
            .height(80.dp)
            .padding(10.dp)
    ) {
        Text(
            text = text,
            fontFamily = Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = (20.sp),
        )
    }
}

@Composable
fun CreatePilot(modifier: Modifier = Modifier,
                onCancel: () -> Unit,
                onSave: (String, String, Uri?) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }
    var team by remember {
        mutableStateOf("")
    }
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val imageSelectorLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            selectedImageUri = it
        }
    )
    val context = LocalContext.current

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(id = R.drawable.logo_alt_f1),
            contentDescription = null,
            modifier = modifier
                .size(120.dp)
                .padding(bottom = 16.dp)
        )

        AsyncImage(
            model = selectedImageUri?: R.drawable.default_profile_picture,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .clickable { imageSelectorLauncher.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                ) }
        )

        Spacer(
            modifier = modifier
        )

        Input(
            label = stringResource(R.string.Text_1),
            value = name,
            onValueChange = { name = it }
            )

        Input(
            label = stringResource(R.string.Text_2),
            value = team,
            onValueChange = { team = it }
        )

        CustomButton(
            text = stringResource(R.string.Button_1),
            onClick = {
                if(name.isNotEmpty() && team.isNotEmpty()) {
                    onSave(name, team, selectedImageUri)
                }
                else {
                    showToast(context, context.getString(R.string.Error_1))
                }
            }
        )

        CustomButton(
            text = stringResource(R.string.Button_2),
            onClick = onCancel
        )
    }
}

fun showToast(context:Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}