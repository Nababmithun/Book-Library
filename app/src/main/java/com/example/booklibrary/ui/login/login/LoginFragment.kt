package com.example.booklibrary.ui.login.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.booklibrary.R
import com.example.booklibrary.databinding.FragmentLoginBinding
import com.example.booklibrary.domain.UserData


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding?=null
    private val binding get()= _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)

        val user= UserData( "Admin", "Admin@123")
        binding.buttonLogin1.setOnClickListener {
            if (user.email==binding.etEmail.text.toString() && user.pass==binding.etpassword.text.toString()){

                findNavController().navigate(R.id.action_loginFragment_to_booksFragment)
            }else{
                Toast.makeText(requireContext(),"Something Wrong",Toast.LENGTH_LONG).show()

            }

        }

        return binding.root
    }


}