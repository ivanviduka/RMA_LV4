package com.example.birdcounterapp.ui.animalcounting.viewmodels

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.birdcounterapp.model.BirdCounter
import com.example.birdcounterapp.model.PreferenceManager
import com.example.birdcounterapp.utils.ButtonOptions

class BirdCounterViewModel(private val birdCounter: BirdCounter): ViewModel() {



    private val _birdsSeen = MutableLiveData(birdCounter.birdsSeen)
    val birdsSeen: LiveData<Int> = _birdsSeen

    private val _textColor =  MutableLiveData(PreferenceManager().retrieveColor())
    val textColor: LiveData<Int> = _textColor

    private val _backgroundColor =  MutableLiveData(PreferenceManager().retrieveTextColor())
    val backgroundColor: LiveData<Int> = _backgroundColor


    fun seeBird(buttonColor: ButtonOptions) {



        val preferenceManager = PreferenceManager()

        when(buttonColor){

            ButtonOptions.Black -> {
                birdCounter.seeBird()
                _birdsSeen.value = birdCounter.birdsSeen

                _backgroundColor.value = Color.BLACK
                _textColor.value = Color.WHITE

                preferenceManager.saveCount(birdCounter.birdsSeen)
                preferenceManager.saveColor(Color.BLACK)
                preferenceManager.saveTextColor(Color.WHITE)
            }

            ButtonOptions.Brown -> {
                birdCounter.seeBird()
                _birdsSeen.value = birdCounter.birdsSeen

                _backgroundColor.value = Color.parseColor("#684439")
                _textColor.value = Color.BLACK

                preferenceManager.saveCount(birdCounter.birdsSeen)
                preferenceManager.saveColor(Color.parseColor("#684439"))
                preferenceManager.saveTextColor(Color.BLACK)
            }

            ButtonOptions.Yellow -> {
                birdCounter.seeBird()
                _birdsSeen.value = birdCounter.birdsSeen

                _backgroundColor.value = Color.YELLOW
                _textColor.value = Color.BLACK

                preferenceManager.saveCount(birdCounter.birdsSeen)
                preferenceManager.saveColor(Color.YELLOW)
                preferenceManager.saveTextColor(Color.BLACK)
            }

            ButtonOptions.Red-> {
                birdCounter.seeBird()
                _birdsSeen.value = birdCounter.birdsSeen

                _backgroundColor.value = Color.RED
                _textColor.value = Color.BLACK

                preferenceManager.saveCount(birdCounter.birdsSeen)
                preferenceManager.saveColor(Color.RED)
                preferenceManager.saveTextColor(Color.BLACK)
            }

            ButtonOptions.Reset -> {
                birdCounter.resetCount()
                _birdsSeen.value = birdCounter.birdsSeen

                _backgroundColor.value = Color.WHITE
                _textColor.value = Color.BLACK

                preferenceManager.saveCount(birdCounter.birdsSeen)
                preferenceManager.saveColor(Color.WHITE)
                preferenceManager.saveTextColor(Color.BLACK)
            }


        }
    }
}