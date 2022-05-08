package com.example.usuynmidtest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usuynmidtest.databinding.RowBinding

class MyAdapter(val items: ArrayList<MyData>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun OnImageClick(data: MyData)
        fun OnNameClick(data: MyData)
    }

    var itemClickListener: OnItemClickListener? = null

    inner class ViewHolder(val binding: RowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.textView4.setOnClickListener{
                itemClickListener?.OnNameClick(items[adapterPosition])
            }
            binding.imageView.setOnClickListener {
                itemClickListener?.OnImageClick(items[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = RowBinding.inflate( // row.xml에 대한 RowBinding 만들어져 있다.
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.binding.apply {
            holder.binding.textView4.text = "이름 " + items[position].name
            holder.binding.textView5.text = "회사명 " + items[position].corp
            holder.binding.textView6.text = "전화번호 " + items[position].tel
            holder.binding.button.text = items[position].count.toString()
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

}