package id.ac.umn.app.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.ac.umn.app.challenge.adapter.data.Student
import id.ac.umn.app.challenge.adapter.data.StudentDatabase
import id.ac.umn.app.challenge.databinding.ActivityAddBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    var mDb: StudentDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDb = StudentDatabase.getInstance(this)

        binding.btnSave.setOnClickListener {
            val objectStudent = Student(
                null,
                binding.etJudul.text.toString(),
                binding.etCatatan.text.toString()
            )

            GlobalScope.async {
                val result = mDb?.studentDao()?.insertStudent(objectStudent)
                runOnUiThread {
                    if(result != 0.toLong() ){
                        //sukses
                        Toast.makeText(this@AddActivity,"Sukses menambahkan ${objectStudent.judul}",
                            Toast.LENGTH_LONG).show()
                    }else{
                        //gagal
                        Toast.makeText(this@AddActivity,"Gagal menambahkan ${objectStudent.judul}",
                            Toast.LENGTH_LONG).show()
                    }
                    finish()
                }
            }
        }
    }
}