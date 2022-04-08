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
import id.ac.umn.app.challenge.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private  var _binding : FragmentRegisterBinding? = null
    private  val binding get() =  _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE)

        binding.btnregister.setOnClickListener {
            val name : String = binding.etUsername.text.toString()
            val email : String = binding.etEmailregister.text.toString()
            val password : String = binding.etPasswordregister.text.toString()
            val konfirmasipassword : String = binding.etKonfirmasipassword.text.toString()

            if (name.isNullOrEmpty()||email.isNullOrEmpty()||password.isNullOrEmpty()||konfirmasipassword.isNullOrEmpty()){
                Toast.makeText(activity, "Isi Secara Lengkap", Toast.LENGTH_SHORT).show()
            }else{
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                if (password == konfirmasipassword){
                    editor.putString("name",name)
                    editor.putString("email",email)
                    editor.putString("password",password)
                    editor.putString("konfirmasipassword",konfirmasipassword)
                    editor.apply()
                    Toast.makeText(activity, "Berhasil Register", Toast.LENGTH_SHORT).show()
                    it.findNavController().navigateUp()
                }else{
                    Toast.makeText(activity, "Password Tidak Sama", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

