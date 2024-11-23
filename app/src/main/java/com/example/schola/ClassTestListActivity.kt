package com.example.schola

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schola.Adapter.ClassTestAdapter
import com.example.schola.Model.ClassTest
import com.example.schola.databinding.ActivityClassTestListBinding
import com.google.firebase.database.*

class ClassTestListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassTestListBinding
    private lateinit var classTestAdapter: ClassTestAdapter
    private val classTests = mutableListOf<ClassTest>()
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassTestListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().getReference("ClassTest")

        setupRecyclerView()
        fetchClassTests()
    }

    private fun setupRecyclerView() {
        binding.rvClassTests.layoutManager = LinearLayoutManager(this)
        classTestAdapter = ClassTestAdapter(classTests)
        binding.rvClassTests.adapter = classTestAdapter
    }

    private fun fetchClassTests() {
        database.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                classTests.clear()
                for (classTestSnapshot in snapshot.children) {
                    val classTest = classTestSnapshot.getValue(ClassTest::class.java)
                    if (classTest != null) {
                        classTests.add(classTest)
                    }
                }
                classTestAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}
