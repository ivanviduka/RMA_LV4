package com.example.birdcounterapp.model

class BirdCounter {
    var birdsSeen: Int = PreferenceManager().retrieveCount()
        private set

    fun seeBird() = birdsSeen++
    fun resetCount() {
        birdsSeen = 0
    }
}