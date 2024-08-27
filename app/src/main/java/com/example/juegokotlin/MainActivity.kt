package com.example.juegokotlin

//importaciones
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.juegokotlin.databinding.MainActivityBinding

//clase principal de la actividad
class MainActivity : AppCompatActivity() {

    //variable para almacenar la binding de la vista
    private lateinit var binding: MainActivityBinding

    //variable para almacenar el viewModel del juego
    private val viewModel: CounterViewModel by viewModels()

    //llamado al crear la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //infla la vista y la establece como la vista de la actividad
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configura los fragmentos que se mostrarán en la actividad
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer1, Player1Fragment())
            .replace(R.id.fragmentContainer2, Player2Fragment())
            .commit()

        //observa el estado del juego y muestra la animación si hay un ganador
        viewModel.winner.observe(this) { winner ->
            winner?.let {
                showWinnerAnimation(it)
            }
        }

        //establece el listener del botón de reinicio
        binding.restartButton.setOnClickListener {
            restartGame()
        }
    }

    //muestra la animación de ganador y desactiva los botones
    private fun showWinnerAnimation(winner: String) {
        //binding.winnerTextView.text = "El ganador es: $winner"
        binding.animationContainer.visibility = View.VISIBLE
        binding.winnerAnimation.playAnimation()
        disableButtons()
    }

    //desactiva los botones de los fragmentos
    private fun disableButtons() {
        val fragment1 = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer1) as? Player1Fragment
        val fragment2 = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer2) as? Player2Fragment
        fragment1?.disableButton()
        fragment2?.disableButton()
    }

    //reinicia el juego
    private fun restartGame() {
        binding.animationContainer.visibility = View.GONE
        binding.winnerAnimation.cancelAnimation()
        viewModel.resetCounters()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer1, Player1Fragment())
            .replace(R.id.fragmentContainer2, Player2Fragment())
            .commit()

        //vuelve a observar el estado del juego
        viewModel.winner.observe(this) { winner ->
            winner?.let {
                println("value winner $it")
                showWinnerAnimation(it)
            }
        }

        //establece el listener del botón de reinicio
        binding.restartButton.setOnClickListener {
            restartGame()
        }
    }

    //llamado al destruir la actividad
    override fun onDestroy() {
        super.onDestroy()
    }
}