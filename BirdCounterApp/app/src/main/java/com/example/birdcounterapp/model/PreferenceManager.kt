package com.example.birdcounterapp.model

import android.content.Context
import com.example.birdcounterapp.BirdCounterApp

class PreferenceManager {

    companion object {
        const val PREFS_FILE = "MyPreferences"
        const val PREFS_KEY_COUNT = "BirdValue"
        const val PREFS_KEY_COLOR = "ColorValue"
        const val PREFS_KEY_TEXT = "TextColorValue"
    }

    fun saveCount(currentCounterValue: Int) {

        val sharedPreferences = BirdCounterApp.context.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )

        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COUNT, currentCounterValue)
        editor.apply()
    }
    fun retrieveCount(): Int {

        val sharedPreferences = BirdCounterApp.context.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )

        return sharedPreferences.getInt(PREFS_KEY_COUNT, 0)
    }

    fun saveColor(currentColor: Int) {

        val sharedPreferences = BirdCounterApp.context.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )

        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_COLOR, currentColor)
        editor.apply()
    }

    fun retrieveColor(): Int {

        val sharedPreferences = BirdCounterApp.context.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )

        return sharedPreferences.getInt(PREFS_KEY_COLOR, -1)
    }

    fun retrieveTextColor(): Int {

        val sharedPreferences = BirdCounterApp.context.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )

        return sharedPreferences.getInt(PREFS_KEY_TEXT, -1)
    }

    fun saveTextColor(currentColor: Int) {

        val sharedPreferences = BirdCounterApp.context.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )

        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_TEXT, currentColor)
        editor.apply()
    }
}