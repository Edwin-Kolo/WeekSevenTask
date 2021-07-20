package com.creativeeddy.weekseventask.student

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.creativeeddy.weekseventask.databinding.StudentItemBinding

class StudentAdapter (var students: List<StudentModel>): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    inner class StudentViewHolder (val binding: StudentItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (student: StudentModel) {
            binding.studentClass.text = student.classs.toString()
            binding.studentName.text = student.name
            binding.studentSeat.text = student.seat.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding: StudentItemBinding = StudentItemBinding.inflate(LayoutInflater.from(parent.context))
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students.get(position)
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return students.size
    }

}