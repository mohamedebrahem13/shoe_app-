package ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.DetailsBinding
import viewmodel.ListViewModel


class ShoeDetail : Fragment() {
    lateinit var binding: DetailsBinding
    private  val viewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding  = DataBindingUtil.inflate(
            inflater, R.layout.details, container, false)
        binding.listViewModel=viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.add.setOnClickListener{
            if (binding.shoeCompanyEdit.text.isNullOrEmpty() ||
                binding.shoeDescription.text.isNullOrEmpty()
                ||binding.shoeSizeEdit.text.isNullOrEmpty()||
                binding.shoeNameEdit.text.isNullOrEmpty()){
                Toast.makeText(context, "Please Fill All Fields",
                    Toast.LENGTH_LONG).show()
            } else {
                viewModel.createshoe()
                viewModel.resetEditText()

                Toast.makeText(context, " Great your shoe was saved ",
                    Toast.LENGTH_LONG).show()
                // navigate back to shoe list screen

               findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeListing())

            }
        }
        binding.cancelButton.setOnClickListener{
            // navigate back to shoe list screen
            findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeListing())

        }

        return binding.root

    }



}