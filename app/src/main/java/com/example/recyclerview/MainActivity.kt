package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.adapter.ItemAdapter
import com.example.recyclerview.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //supportActionBar?.setDisplayShowTitleEnabled(false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val users = DataSource(this).loadUsers()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val divider = DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL)
        val drawable = ContextCompat.getDrawable(this, R.drawable.divider)
        divider.setDrawable(drawable!!)
        recyclerView.addItemDecoration(divider)
        recyclerView.adapter = ItemAdapter(users)
        recyclerView.setHasFixedSize(true)

    }
}