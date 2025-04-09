package com.example.f2.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.f2.R

data class Pilot (
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val teams: Int
)

val pilot = listOf(
    Pilot(R.drawable.carlos_sainz, R.string.pilot_name_1, R.string.F1_teams_1),
    Pilot(R.drawable.fernando_alonso, R.string.pilot_name_2, R.string.F1_teams_2),
    Pilot(R.drawable.lando_norris, R.string.pilot_name_3, R.string.F1_teams_4),
    Pilot(R.drawable.sergio_perez, R.string.pilot_name_4, R.string.F1_teams_1),
    Pilot(R.drawable.george_russell, R.string.pilot_name_5, R.string.F1_teams_5),
    Pilot(R.drawable.charles_leclerc, R.string.pilot_name_6, R.string.F1_teams_3),
    Pilot(R.drawable.lewis_hamilton, R.string.pilot_name_7, R.string.F1_teams_3),
    Pilot(R.drawable.max_verstappen, R.string.pilot_name_8, R.string.F1_teams_1),
    Pilot(R.drawable.valtteri_bottas, R.string.pilot_name_9, R.string.F1_teams_6),
)