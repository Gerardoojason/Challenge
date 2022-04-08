package id.ac.umn.app.challenge.adapter

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import id.ac.umn.app.challenge.EditActivity
import id.ac.umn.app.challenge.HomeActivity
import id.ac.umn.app.challenge.MainActivity
import id.ac.umn.app.challenge.R
import id.ac.umn.app.challenge.adapter.data.Student
import id.ac.umn.app.challenge.adapter.data.StudentDatabase
import kotlinx.android.synthetic.main.student_item.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class StudentAdapter(val listStudent : List<Student>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvID.text = listStudent[position].id.toString()
        holder.itemView.tvNama.text = listStudent[position].judul
        holder.itemView.tvEmail.text = listStudent[position].catatan

        holder.itemView.ivEdit.setOnClickListener {
            val intentKeEditActivity = Intent(it.context,
                EditActivity::class.java)

            intentKeEditActivity.putExtra("student",listStudent[position])
            it.context.startActivity(intentKeEditActivity)
        }

        holder.itemView.ivDelete.setOnClickListener {
            AlertDialog.Builder(it.context).setPositiveButton("Ya") { p0, p1 ->
                val mDb = StudentDatabase.getInstance(holder.itemView.context)

                GlobalScope.async {
                    val result = mDb?.studentDao()?.deleteStudent(listStudent[position])

                    (holder.itemView.context as HomeActivity).runOnUiThread {
                        if (result!=0){
                            Toast.makeText(it.context,"Data ${listStudent[position].judul} berhasil dihapus",
                                Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(it.context,"Data ${listStudent[position].judul} Gagal dihapus",
                                Toast.LENGTH_LONG).show()
                        }
                    }

                    (holder.itemView.context as HomeActivity).fetchData()
                }
            }.setNegativeButton("Tidak"
            ) { p0, p1 ->
                p0.dismiss()
            }
                .setMessage("Apakah Anda Yakin ingin menghapus data ${listStudent[position].judul}").setTitle("Konfirmasi Hapus").create().show()
        }

        holder.itemView.ivDelete.setOnClickListener {
            AlertDialog.Builder(it.context).setPositiveButton("Ya") { p0, p1 ->
                val mDb = StudentDatabase.getInstance(holder.itemView.context)

                GlobalScope.async {
                    val result = mDb?.studentDao()?.deleteStudent(listStudent[position])

                    (holder.itemView.context as HomeActivity).runOnUiThread {
                        if (result!=0){
                            Toast.makeText(it.context,"Data ${listStudent[position].judul} berhasil dihapus",
                                Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(it.context,"Data ${listStudent[position].judul} Gagal dihapus",
                                Toast.LENGTH_LONG).show()
                        }
                    }

                    (holder.itemView.context as HomeActivity).fetchData()
                }
            }.setNegativeButton("Tidak"
            ) { p0, p1 ->
                p0.dismiss()
            }
                .setMessage("Apakah Anda Yakin ingin menghapus data ${listStudent[position].judul}").setTitle("Konfirmasi Hapus").create().show()
        }
    }
}