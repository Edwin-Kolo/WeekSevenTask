package com.creativeeddy.weekseventask.student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.creativeeddy.weekseventask.MainViewModel
import com.creativeeddy.weekseventask.databinding.ActivityStudentBinding

class StudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding
    private lateinit var viewModei: MainViewModel
    private lateinit var studentAdapter: StudentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentAdapter = StudentAdapter(listOf())
        binding.recyclerView2.adapter = studentAdapter

        viewModei = ViewModelProvider(this)[MainViewModel::class.java]

        viewModei.apply {
            getAllStudents()
            students.observe(this@StudentActivity, {student ->
                studentAdapter.students = student
                studentAdapter.notifyDataSetChanged()
            })
        }
        binding.submit.setOnClickListener {
            var name: String = binding.addedName.text.toString()
            var seat: Int = binding.addedSeat.text.toString().toInt()
            var classs: String = binding.addedClass.text.toString()

            var changes = StudentModel (classs, name, seat)
            viewModei.apply {
                viewModei.pushPost(changes)
                addstudent.observe(this@StudentActivity, {response ->
                    studentAdapter.students = response
                    studentAdapter.notifyDataSetChanged()
                })
            }
        }
    }
}