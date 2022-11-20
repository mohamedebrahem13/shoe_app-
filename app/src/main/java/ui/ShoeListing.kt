package ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListingBinding
import com.example.shoestore.databinding.LayoutBinding
import com.example.shoestore.models.Shoe
import viewmodel.ListViewModel


class ShoeListing : Fragment(),MenuProvider {
    lateinit var binding: FragmentShoeListingBinding
    private  val viewModel: ListViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment




        requireActivity().addMenuProvider(this,viewLifecycleOwner)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_listing, container, false)

        binding.listViewModel=viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.shoeList.observe(this.viewLifecycleOwner, Observer { Listofshoe->
            //here we iterate to get the shoe object from the list after data changed
            Listofshoe.forEach{
                addView(it, binding.linearLayout)
                Log.i(TAG, "shoe ${it.name}: ")

            }

        })



        binding.NewShoe.setOnClickListener{
            findNavController().navigate(ShoeListingDirections.actionShoeListingToShoeDetail())
        }

        return binding.root

    }

    private fun addView(shoe: Shoe, parent: ViewGroup?){
        //here we add layout in the run time
        val shoeBinding: LayoutBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.layout, parent, false)
        shoeBinding.shoeitem = shoe
        binding.linearLayout.addView(shoeBinding.root)

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater .inflate(R.menu.logout, menu)

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        findNavController().navigate(ShoeListingDirections.actionShoeListingToLogin())
        return true
    }



}