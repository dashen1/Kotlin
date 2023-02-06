package com.example.kotlinlearning.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlearning.R
import com.example.kotlinlearning.database.Student

class CollectAdapter : RecyclerView.Adapter<CollectAdapter.MyViewHolder>() {

    //接受数据库的数据
    var allStudents: List<Student> = ArrayList()

    // 内部类
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvId: TextView = itemView.findViewById(R.id.tv_id)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvAge: TextView = itemView.findViewById(R.id.tv_age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectAdapter.MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView: View = layoutInflater.inflate(R.layout.item_collect_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CollectAdapter.MyViewHolder, position: Int) {
        val student: Student = allStudents[position]
        holder.tvId.text = "${position+1}"
        holder.tvName.text = student.name
        holder.tvAge.text = "${student.age}"
        // Jump to external website when click item.
        holder.itemView.setOnClickListener {
            val uri: Uri = Uri.parse("https://m.youdao.com/dict?le=eng&q=" + holder.tvName.text)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = allStudents.size

}