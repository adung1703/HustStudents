package com.huudung.huststudents

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import java.text.SimpleDateFormat
import java.util.Locale

class ListStudentFragment : Fragment() {

    private lateinit var db : StudentDatabase
    private lateinit var studentDao : StudentDao

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(
            requireContext(),
            StudentDatabase::class.java, "student-database"
        ).build()
        studentDao = db.studentDao()
        studentDao.insertStudent(StudentDB(
            mssv = "20215545",
            name = "Nguyễn Hữu Dũng",
            dateOfBirth = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("17/03/2003"),
            hometown = "Thanh Hóa"
        ))
        studentDao.insertStudent(StudentDB(
            mssv = "20215545",
            name = "Nguyễn Hữu Dũng",
            dateOfBirth = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("17/03/2003"),
            hometown = "Thanh Hóa"
        ))
        studentDao.insertStudent(StudentDB(
            mssv = "20215545",
            name = "Nguyễn Hữu Dũng",
            dateOfBirth = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("17/03/2003"),
            hometown = "Thanh Hóa"
        ))
        studentDao.insertStudent(StudentDB(
            mssv = "20215545",
            name = "Nguyễn Hữu Dũng",
            dateOfBirth = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("17/03/2003"),
            hometown = "Thanh Hóa"
        ))
        studentDao.insertStudent(StudentDB(
            mssv = "20215545",
            name = "Nguyễn Hữu Dũng",
            dateOfBirth = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("17/03/2003"),
            hometown = "Thanh Hóa"
        ))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_student, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateContent()
    }

    override fun onResume() {
        super.onResume()
        updateContent()
    }
    fun updateContent() {
        val listStudentDB : ArrayList<StudentDB> = studentDao.getAllStudents()
        val listItem = ArrayList<StudentModel>()
        for (student in listStudentDB) {
            listItem.add(StudentModel(student.mssv, student.name, student.dateOfBirth, student.hometown))
        }
        val listView = view?.findViewById<RecyclerView>(R.id.ListStudents)
        LinearLayoutManager(requireContext()).also { listView?.layoutManager = it }
        listView?.adapter = MyAdapter(listItem)
    }
}