package id.ac.umn.app.challenge

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import id.ac.umn.app.challenge.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private  var _binding : FragmentLoginBinding? = null
    private  val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)

        binding.btnlogin.setOnClickListener {
            val email = binding.etEmaillogin.text.toString()
            val password = binding.etPasswordlogin.text.toString()

            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                Toast.makeText(activity, "Silahkan Diisi", Toast.LENGTH_SHORT).show()
            } else {
                val email_id = sharedPreferences.getString("email", "default")
                val password_id = sharedPreferences.getString("password", "default")




                if (email_id.equals(email) && password_id.equals(password)) {

                    it.findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                } else {
                    Toast.makeText(activity, "Username atau Password Salah", Toast.LENGTH_SHORT)
                        .show()
                }


            }

        }

        binding.buttontv2.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}

