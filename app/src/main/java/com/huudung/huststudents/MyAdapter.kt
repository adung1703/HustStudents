package com.huudung.huststudents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.Normalizer
import java.util.regex.Pattern

class MyAdapter(val items : ArrayList<StudentModel>) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {
    class ItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name : TextView
        val studentID : TextView
        val mail : TextView
        init {
            name = itemView.findViewById(R.id.Name)
            studentID = itemView.findViewById(R.id.StudentID)
            mail = itemView.findViewById(R.id.Mail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val name = items[position].Name
        val sid = items[position].StudentID

        val words = Pattern.compile("\\p{InCombiningDiacriticalMarks}+") //mang ho va ten
            .matcher(Normalizer.normalize(name, Normalizer.Form.NFD))
            .replaceAll("")//chuyen sang khong dau
            .lowercase()//chuyen thanh chu thuong
            .split("\\s+".toRegex()) //cat chuoi
        var abbreviatedName = "" //ten viet tat
        for (i in 0..words.size - 2) {
            abbreviatedName += words[i][0]
        }
        val mail = words[words.size - 1] + "." + abbreviatedName + sid.substring(2) + "@sis.hust.edu.vn"
        holder.name.text = name
        holder.studentID.text = sid
        holder.mail.text = mail
    }
}