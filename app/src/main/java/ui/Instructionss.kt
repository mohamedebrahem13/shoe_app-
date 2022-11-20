package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionssBinding


class Instructionss : Fragment() {
lateinit var binding:FragmentInstructionssBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding  = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instructionss, container, false)
        binding.next2.setOnClickListener { view: View ->
            view.findNavController().navigate(InstructionssDirections.actionInstructionssToShoeListing())
        }
        return binding.root
    }



}