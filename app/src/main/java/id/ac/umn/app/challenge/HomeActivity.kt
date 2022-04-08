package id.ac.umn.app.challenge

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.umn.app.challenge.adapter.StudentAdapter
import id.ac.umn.app.challenge.adapter.data.Student
import id.ac.umn.app.challenge.adapter.data.StudentDatabase
import id.ac.umn.app.challenge.databinding.ActivityHomeBinding
import id.ac.umn.app.challenge.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private var mDB : StudentDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mDB = StudentDatabase.getInstance(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        fetchData()

        binding.fabAdd.setOnClickListener {
            val keActivityAdd = Intent(this, AddActivity::class.java)
            startActivity(keActivityAdd)


//            val mDb = StudentDatabase.getInstance(this)
//            AlertDialog.Builder(it.context)
//            val objectStudent = Student(
//                null,
//                binding.etNamaStudent.text.toString(),
//                binding.etEmailStudent.text.toString()
//            )
//            GlobalScope.async {
//                val result = mDb?.studentDao()?.insertStudent(objectStudent)
//                runOnUiThread {
//                    if(result != 0.toLong() ){
//                        //sukses
//                        Toast.makeText(this@HomeActivity,"Sukses menambahkan ${objectStudent.nama}",
//                            Toast.LENGTH_LONG).show()
//                    }else{
//                        //gagal
//                        Toast.makeText(this@HomeActivity,"Gagal menambahkan ${objectStudent.nama}",
//                            Toast.LENGTH_LONG).show()
//                    }
//                    finish()
//                }
//            }
        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData(){
        GlobalScope.launch {
            val listStudent = mDB?.studentDao()?.getAllStudent()

            runOnUiThread{
                listStudent?.let {
                    val adapter = StudentAdapter(it)
                    binding.recyclerView.adapter = adapter
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        StudentDatabase.destroyInstance()
    }
}