package com.example.f2.data

import androidx.annotation.DrawableRes
import com.example.f2.R

data class Pilot (
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val teams: String
)

var pilots = mutableListOf(
    Pilot(R.drawable.carlos_sainz, "Carlos Sainz", "Ferrari"),
    Pilot(R.drawable.fernando_alonso, "Fernando Alonso", "Aston Martin"),
    Pilot(R.drawable.lando_norris, "Lando Norris", "McLaren"),
    Pilot(R.drawable.sergio_perez, "Sergio Pérez", "Red Bull Racing"),
    Pilot(R.drawable.george_russell, "George Russell", "Mercedes"),
    Pilot(R.drawable.charles_leclerc, "Charles Leclerc", "Ferrari"),
    Pilot(R.drawable.lewis_hamilton, "Lewis Hamilton", "Mercedes"),
    Pilot(R.drawable.max_verstappen, "Max Verstappen", "Red Bull Racing"),
    Pilot(R.drawable.valtteri_bottas, "Valtteri Bottas", "Kick Sauber"),
    Pilot(R.drawable.alexandre_albon, "Alexander Albon", "WILLIAMS"),
    Pilot(R.drawable.daniel_ricciardo, "Daniel Ricciardo", "Racing Bulls"),
    Pilot(R.drawable.alexandre_albon, "Esteban Ocon", "Alpine"),
    Pilot(R.drawable.guanyu_zhou, "Guanyu Zhou", "Kick Sauber"),
    Pilot(R.drawable.kevin_magnussen, "Kevin Magnussen", "Haas"),
    Pilot(R.drawable.lance_stroll, "Lance Stroll", "Aston Martin"),
    Pilot(R.drawable.logan_sargeant, "Logan Sargeant", "WILLIAMS"),
    Pilot(R.drawable.nico_hulkenberg, "Nico Hulkenberg", "Haas"),
    Pilot(R.drawable.oscar_piastri, "Oscar Piastri", "McLaren"),
    Pilot(R.drawable.pierre_gasly, "Pierre Gasly", "Alpine"),
    Pilot(R.drawable.yuki_tsunoda, "Yuki Tsunoda", "Racing Bulls"),


    )