package com.example.tribe.ui.insights

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tribe.R
import com.example.tribe.ui.blog.NewsPage
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val context: Context): RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    private val list = listOf(NewsModel(category = "Risk and Strategy"), NewsModel(category = "Research and Development"))
    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): NewsHolder {
        return NewsHolder(LayoutInflater.from(context).inflate(R.layout.item_news, viewgroup, false))
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NewsHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(model: NewsModel) {
            itemView.category.text = model.category
            itemView.date.text = model.date
            itemView.content.text = model.content
            itemView.topic.text = model.topic

            itemView.setOnClickListener { context.startActivity(Intent(context, NewsPage::class.java)) }
        }
    }
}

data class NewsModel(
    val category: String = "Finance and Tax",
    val date: String = "03 Sept, 2020",
    val timeRange: String = "3 mins read",
    val content: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    val topic: String = "How do we determine our interest rates"
)