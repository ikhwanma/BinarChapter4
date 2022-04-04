package ikhwan.binar.chapterempat.orm.kelas.room

import androidx.room.*
import ikhwan.binar.chapterempat.orm.kelas.Student

@Dao
interface StudentDao {
    @Insert
    fun insertStudent(student: Student):Long
}