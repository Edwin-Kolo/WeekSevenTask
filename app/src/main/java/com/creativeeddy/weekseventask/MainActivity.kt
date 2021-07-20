package com.creativeeddy.weekseventask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.creativeeddy.weekseventask.databinding.ActivityMainBinding
import com.creativeeddy.weekseventask.item.ItemAdapter
import com.creativeeddy.weekseventask.student.StudentActivity


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemAdapter = ItemAdapter(listOf())
        binding.recyclerView.adapter = itemAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllItems()
            items.observe(this@MainActivity, {item ->
                itemAdapter.items = item
                itemAdapter.notifyDataSetChanged()
            })
        }
        binding.button.setOnClickListener {
            val intent: Intent = Intent(this,StudentActivity::class.java)
            startActivity(intent)
        }

    }
}