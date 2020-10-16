package com.example.tribe.ui.blog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tribe.R
import kotlinx.android.synthetic.main.activity_news_page.view.*
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentAdapter(private val context: Context): RecyclerView.Adapter<CommentAdapter.CommentHolder>() {
    val list = listOf(Comment(name = "Michael Doe"), Comment(name = "John Doe"))
    var setClick: (() -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CommentHolder {
        return CommentHolder(LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false))
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class CommentHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(comment: Comment) {
            itemView.user_name.text = comment.name
            itemView.tv_comment.text = comment.user_comment
            itemView.tv_time.text = comment.time
            itemView.user_img.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_woman_1))
            itemView.tv_reply.setOnClickListener { setClick?.invoke() }
        }
    }
}

data class Comment(
    val name: String = "John Doe",
    val user_comment: String = "Varius vel pharetra vel turpis nunc eget, Varius vel pharetra\n" +
            "vel turpis nunc eget Varius vel pharetra vel turpis nunc eget.",
    val time: String = "In a few seconds",
)