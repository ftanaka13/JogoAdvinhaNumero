package br.com.faculdadeimpacta.advinhanumero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.advinhanumero.databinding.FragmentTentativaBinding

class TentativaFragment : Fragment() {

    private var _binding: FragmentTentativaBinding? = null
    private val binding get() = _binding!!
    private val args: TentativaFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTentativaBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.buttonChutar.setOnClickListener {
            val valorDigitado = binding.editTextChute.toString().toIntOrNull()
            if (valorDigitado == null || valorDigitado < 0 || valorDigitado > 10) {
                binding.editTextChute.error = "Por favor digite um número inteiro entre 0 e 10"
                return@setOnClickListener
            }
            val directions = when {
                valorDigitado < args.numeroSorteado -> TentativaFragmentDirections.actionTentativaFragmentToChuteMenorFragment()
                valorDigitado > args.numeroSorteado -> TentativaFragmentDirections.actionTentativaFragmentToChuteMaiorFragment()
                else -> TentativaFragmentDirections.actionTentativaFragmentToParabensFragment()
            }
            findNavController().navigate(directions)
        }
    }
}