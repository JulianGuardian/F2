package com.example.f2.data

import android.content.Context
import android.net.Uri
import androidx.annotation.DrawableRes
import com.example.f2.R
import androidx.core.net.toUri

data class Pilot (
    val imageUri: Uri? = null,
    val name: String,
    val teams: String
)

fun getInitialPilots(context: Context): MutableList<Pilot> {
    return mutableListOf(
        Pilot(drawableResToUri(context, R.drawable.carlos_sainz), "Carlos Sainz", "Ferrari"),
        Pilot(drawableResToUri(context, R.drawable.fernando_alonso), "Fernando Alonso", "Aston Martin"),
        Pilot(drawableResToUri(context, R.drawable.lando_norris), "Lando Norris", "McLaren"),
        Pilot(drawableResToUri(context, R.drawable.sergio_perez), "Sergio Pérez", "Red Bull Racing"),
        Pilot(drawableResToUri(context, R.drawable.george_russell), "George Russell", "Mercedes"),
        Pilot(drawableResToUri(context, R.drawable.charles_leclerc), "Charles Leclerc", "Ferrari"),
        Pilot(drawableResToUri(context, R.drawable.lewis_hamilton), "Lewis Hamilton", "Mercedes"),
        Pilot(drawableResToUri(context, R.drawable.max_verstappen), "Max Verstappen", "Red Bull Racing"),
        Pilot(drawableResToUri(context, R.drawable.valtteri_bottas), "Valtteri Bottas", "Kick Sauber"),
        Pilot(drawableResToUri(context, R.drawable.alexandre_albon), "Alexander Albon", "WILLIAMS"),
        Pilot(drawableResToUri(context, R.drawable.daniel_ricciardo), "Daniel Ricciardo", "Racing Bulls"),
        Pilot(drawableResToUri(context, R.drawable.alexandre_albon), "Esteban Ocon", "Alpine"),
        Pilot(drawableResToUri(context, R.drawable.guanyu_zhou), "Guanyu Zhou", "Kick Sauber"),
        Pilot(drawableResToUri(context, R.drawable.kevin_magnussen), "Kevin Magnussen", "Haas"),
        Pilot(drawableResToUri(context, R.drawable.lance_stroll), "Lance Stroll", "Aston Martin"),
        Pilot(drawableResToUri(context, R.drawable.logan_sargeant), "Logan Sargeant", "WILLIAMS"),
        Pilot(drawableResToUri(context, R.drawable.nico_hulkenberg), "Nico Hulkenberg", "Haas"),
        Pilot(drawableResToUri(context, R.drawable.oscar_piastri), "Oscar Piastri", "McLaren"),
        Pilot(drawableResToUri(context, R.drawable.pierre_gasly), "Pierre Gasly", "Alpine"),
        Pilot(drawableResToUri(context, R.drawable.yuki_tsunoda), "Yuki Tsunoda", "Racing Bulls")
    )
}

fun drawableResToUri(context: Context, @DrawableRes resId: Int): Uri {
    return "android.resource://${context.packageName}/drawable/${
        context.resources.getResourceEntryName(
            resId
        )
    }".toUri()
}