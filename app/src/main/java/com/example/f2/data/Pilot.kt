package com.example.f2.data

import android.net.Uri
import com.example.f2.R

data class Pilot (
    val imageUri: Uri?,
    val name: String,
    val teams: String
)
/*
var pilots = mutableListOf(
    Pilot(R.drawable.test, "Carlos Sainz", "Ferrari"),
    Pilot(R.drawable.fernando_alonso, "Fernando Alonso", "Aston Martin"),
    Pilot(R.drawable.lando_norris, "Lando Norris", "McLaren"),
    Pilot(R.drawable.sergio_perez, "Sergio Pérez", "Red Bull Racing"),
    Pilot(R.drawable.george_russell, "George Russell", "Mercedes"),
    Pilot(R.drawable.charles_leclerc, "Charles Leclerc", "Ferrari"),
    Pilot(R.drawable.lewis_hamilton, "Lewis Hamilton", "Mercedes"),
    Pilot(R.drawable.max_verstappen, "Max Verstappen", "Red Bull Racing"),
    Pilot(R.drawable.valtteri_bottas, "Valtteri Bottas", "Kick Sauber"),
)
 */