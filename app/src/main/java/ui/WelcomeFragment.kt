package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentWelcomBinding


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding:FragmentWelcomBinding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcom, container, false)
        binding.next1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcomeFragment_to_instructionss)
        }
        return binding.root


        // Inflate the layout for this fragment
    }

}