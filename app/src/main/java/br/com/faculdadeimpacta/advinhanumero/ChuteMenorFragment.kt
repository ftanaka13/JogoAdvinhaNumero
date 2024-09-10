package br.com.faculdadeimpacta.advinhanumero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.faculdadeimpacta.advinhanumero.databinding.FragmentChuteMenorBinding

class ChuteMenorFragment : Fragment() {

    private var _binding: FragmentChuteMenorBinding? = null
    private val binding get() = _binding!!
    private val args: ChuteMenorFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentChuteMenorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonTenteNovamente.setOnClickListener {
            val directions =
                ChuteMenorFragmentDirections.actionChuteMenorFragmentToTentativaFragment(args.numeroSorteado)
            findNavController().navigate(directions)
        }
    }
}