package com.example.birdcounterapp.ui.animalcounting.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.observe
import com.example.birdcounterapp.databinding.ActivityBirdCounterBinding
import com.example.birdcounterapp.model.PreferenceManager
import com.example.birdcounterapp.ui.animalcounting.viewmodels.BirdCounterViewModel
import com.example.birdcounterapp.utils.ButtonOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class BirdCounterActivity : AppCompatActivity() {

    private val viewModel by viewModel<BirdCounterViewModel>()
    private lateinit var binding: ActivityBirdCounterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityBirdCounterBinding.inflate(layoutInflater).also {
           it.btnBlackBird.setOnClickListener{viewModel.seeBird(ButtonOptions.Black)}
           it.btnBrownBird.setOnClickListener{viewModel.seeBird(ButtonOptions.Brown)}
           it.btnRedBird.setOnClickListener{viewModel.seeBird(ButtonOptions.Red)}
           it.btnYellowBird.setOnClickListener{viewModel.seeBird(ButtonOptions.Yellow)}
           it.btnReset.setOnClickListener{viewModel.seeBird(ButtonOptions.Reset)}
       }

        setContentView(binding.root)

        viewModel.birdsSeen.observe(this, { binding.tvCurrentBirdCount.text = it.toString()} )
        viewModel.backgroundColor.observe(this, { binding.tvCurrentBirdCount.setBackgroundColor(it)} )
        viewModel.textColor.observe(this, {binding.tvCurrentBirdCount.setTextColor(it)} )



    }



    override fun onResume() {
        super.onResume()
        loadCounter()
        loadColor()
        loadTextColor()
    }

    private fun loadTextColor() {
        val currentTextColor = PreferenceManager().retrieveTextColor()

        binding.tvCurrentBirdCount.setTextColor(currentTextColor)
    }

    private fun loadColor() {
        val currentColor = PreferenceManager().retrieveColor()

        binding.tvCurrentBirdCount.setBackgroundColor(currentColor)
    }

    private fun loadCounter() {
        val currentCounter = PreferenceManager().retrieveCount()

        binding.tvCurrentBirdCount.text = currentCounter.toString()


    }
}