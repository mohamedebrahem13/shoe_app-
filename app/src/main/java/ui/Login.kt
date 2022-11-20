package ui
import android.util.Patterns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentLoginBinding


class Login : Fragment() {

lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment




        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false)

        //The complete onClickListener with Navigation using createNavigateOnClickListener
        binding.loginbtn.setOnClickListener{
            checking()

                }

        binding.createBtn.setOnClickListener {
            checking()

        }
        return binding.root
    }



    private fun checking(){
        //check for email and password if null make toast and tell user else navigate to welcome fragment
//        if (binding.editTextTextEmailAddress.text.isNullOrEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(binding.editTextTextEmailAddress.text).matches()||
//            binding.editTextTextPassword.text.isNullOrEmpty()|| binding.editTextTextPassword.text.length <= 6
//        ){
//            Toast.makeText(context, "Please enter valid email with @  and password more than 6 digit ",
//                Toast.LENGTH_LONG).show()
//        } else {
        findNavController().navigate(LoginDirections.actionLoginToWelcomeFragment())




//        }
    }


}