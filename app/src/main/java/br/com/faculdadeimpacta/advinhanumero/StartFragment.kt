package br.com.faculdadeimpacta.advinhanumero

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.faculdadeimpacta.advinhanumero.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.buttonComecar.setOnClickListener {
            val direction = StartFragmentDirections.actionStartFragmentToTentativaFragment()
            findNavController().navigate(direction)
        }
    }
}