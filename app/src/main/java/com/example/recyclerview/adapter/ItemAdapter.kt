package com.example.recyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.DetailActivity
import com.example.recyclerview.model.Worker

class ItemAdapter(private val data: List<Worker>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var worker: Worker

        val nameView: TextView = view.findViewById(R.id.nameTV)
        val companyView: TextView = view.findViewById(R.id.companyTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, DetailActivity::class.java)
                showUserIntent.putExtra(DetailActivity.WORKER_NAME, worker.name)
                showUserIntent.putExtra(DetailActivity.WORKER_COMP, worker.company)
                showUserIntent.putExtra(DetailActivity.WORKER_SSN, worker.ssn)
                context.startActivity(showUserIntent)
            }
        }
        fun bind(worker:Worker){
            this.worker = worker
            nameView.text = worker.name
            companyView.text = worker.company
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)
    }
}