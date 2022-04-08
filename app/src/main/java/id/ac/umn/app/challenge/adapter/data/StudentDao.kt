package id.ac.umn.app.challenge.adapter.data

import androidx.room.*


@Dao
interface StudentDao {
    @Query("SELECT * FROM Student")
    fun getAllStudent(): List<Student>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student):Long

    @Update
    fun updateStudent(student: Student):Int

    @Delete
    fun deleteStudent(student: Student):Int
}