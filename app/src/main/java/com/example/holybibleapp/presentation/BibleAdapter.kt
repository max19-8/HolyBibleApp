package com.example.holybibleapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.holybibleapp.R
import com.example.holybibleapp.core.Book

class BibleAdapter : RecyclerView.Adapter<BibleAdapter.BibleVIewHolder>() {

    private val books = ArrayList<Book>()

    fun update(new:List<Book>){
        books.clear()
        books.addAll(new)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BibleVIewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.book_layout,parent,false)
        //todo progress and fail
        return BibleVIewHolder(view)
    }

    override fun onBindViewHolder(holder: BibleVIewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size


    inner class BibleVIewHolder(view: View):RecyclerView.ViewHolder(view) {
            fun bind(book: Book){
                itemView.findViewById<TextView>(R.id.textVIew).text = book.name
            }

    }

}