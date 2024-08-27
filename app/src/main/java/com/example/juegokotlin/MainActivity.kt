package com.example.juegokotlin

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.juegokotlin.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer1, Player1Fragment())
            .replace(R.id.fragmentContainer2, Player2Fragment())
            .commit()

        viewModel.winner.observe(this) { winner ->
            winner?.let {
                showWinnerAnimation(it)
            }
        }

        binding.restartButton.setOnClickListener {
            restartGame()
        }
    }

    private fun showWinnerAnimation(winner: String) {
        //binding.winnerTextView.text = "El ganador es: $winner"
        binding.animationContainer.visibility = View.VISIBLE
        binding.winnerAnimation.playAnimation()
        disableButtons()
    }

    private fun disableButtons() {
        val fragment1 = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer1) as? Player1Fragment
        val fragment2 = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer2) as? Player2Fragment
        fragment1?.disableButton()
        fragment2?.disableButton()
    }

    private fun restartGame() {
        binding.animationContainer.visibility = View.GONE
        binding.winnerAnimation.cancelAnimation()
        viewModel.resetCounters()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer1, Player1Fragment())
            .replace(R.id.fragmentContainer2, Player2Fragment())
            .commit()
        viewModel.winner.observe(this) { winner ->
            winner?.let {
                println("value winner "+it)
                showWinnerAnimation(it)
            }
        }
        binding.restartButton.setOnClickListener {
            restartGame()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}