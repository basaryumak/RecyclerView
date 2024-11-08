package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.recyclerview.databinding.ActivityUserDetailBinding
import com.example.recyclerview.model.Worker

class DetailActivity : AppCompatActivity() {
    companion object{
        const val WORKER_NAME = "worker_name"
        const val WORKER_COMP = "worker_comp"
        const val WORKER_SSN = "worker_ssn"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        val userName = intent.getStringExtra(WORKER_NAME) ?: "Unknown"
        val userComp = intent.getStringExtra(WORKER_COMP) ?: "Unknown"
        val userSsn = intent.getStringExtra(WORKER_SSN) ?: "Unknown"

        val worker = Worker(userName, userComp, userSsn)

        binding.worker = worker

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}