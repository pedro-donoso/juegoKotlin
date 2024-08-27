package com.example.juegokotlin

//importaciones
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.juegokotlin.databinding.FragmentPlayer1Binding

//clase Player1Fragment que hereda de Fragment
class Player1Fragment : Fragment() {

    //variables para almacenar la binding de la vista y el viewModel
    private var _binding: FragmentPlayer1Binding? = null

    //propiedad para observar los cambios en la binding
    private val binding get() = _binding!!

    //propiedad para observar los cambios en el viewModel
    private val viewModel: CounterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayer1Binding.inflate(inflater, container, false)
        return binding.root
    }

    //llamado al crear la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //configura la binding y el viewModel
        binding.apply {

            //establece el texto del contador y el listener del botón
            counterText.text = viewModel.counter1.value.toString()

            //establece el listener del botón
            clickButton.setOnClickListener {

                //incrementa el contador 1 y decrementa el contador 2
                viewModel.incrementCounter1()
                viewModel.decrementCounter2()
            }
        }

        //observa los cambios en el contador 1 y actualiza la binding
        viewModel.counter1.observe(viewLifecycleOwner) {
            binding.counterText.text = it.toString()
        }
    }

    //desactiva el botón
    fun disableButton() {
        binding.clickButton.isEnabled = false
    }

    //llamado al destruir la vista
    override fun onDestroy() {
        super.onDestroy()

        //limpiamos la binding
        _binding = null
    }
}