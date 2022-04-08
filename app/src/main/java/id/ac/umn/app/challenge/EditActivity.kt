package id.ac.umn.app.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.ac.umn.app.challenge.adapter.data.Student
import id.ac.umn.app.challenge.adapter.data.StudentDatabase
import id.ac.umn.app.challenge.databinding.ActivityEditBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding
    var mDb: StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDb = StudentDatabase.getInstance(this)

        val objectStudent = intent.getParcelableExtra<Student>("student")

        binding.etJudul.setText(objectStudent?.judul)
        binding.etCatatan.setText(objectStudent?.catatan)



        binding.btnSave.setOnClickListener {
            objectStudent?.let {
                objectStudent.judul = binding.etJudul.text.toString()
                objectStudent.catatan = binding.etCatatan.text.toString()
            }
            GlobalScope.async {
                val result = objectStudent?.let { it1-> mDb?.studentDao()?.updateStudent(it1) }

                runOnUiThread {
                    if(result!=0){
                        Toast.makeText(this@EditActivity,"Sukses mengubah ${objectStudent?.judul}",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this@EditActivity,"Gagal mengubah ${objectStudent.judul}",
                            Toast.LENGTH_LONG).show()
                    }

                    finish()
                }
            }
        }
    }
}