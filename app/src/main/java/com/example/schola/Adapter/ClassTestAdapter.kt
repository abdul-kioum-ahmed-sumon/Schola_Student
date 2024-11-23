package com.example.schola.Adapter



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schola.databinding.ItemClassTestBinding
import com.example.schola.Model.ClassTest

class ClassTestAdapter(private val classTests: List<ClassTest>) :
    RecyclerView.Adapter<ClassTestAdapter.ClassTestViewHolder>() {

    inner class ClassTestViewHolder(private val binding: ItemClassTestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(classTest: ClassTest) {
            binding.tvClassTestNumber.text = classTest.ctNo
            binding.tvCourseCode.text = "Course Code: ${classTest.assignCourseId}"
            binding.tvTime.text = "Time: ${classTest.time}"
            binding.tvTopic.text = "Topic: ${classTest.topic}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassTestViewHolder {
        val binding =
            ItemClassTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassTestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClassTestViewHolder, position: Int) {
        holder.bind(classTests[position])
    }

    override fun getItemCount() = classTests.size
}
