package com.example.tribe.ui.blog

import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.example.tribe.R
import com.example.tribe.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_news_page.*


class NewsPage : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_page)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val commentAdapter = CommentAdapter(this)
        recyclerview.adapter = commentAdapter
        commentAdapter.setClick = {
            MaterialDialog(this).show {
                input(
                    hint = "Comment here", allowEmpty = false,
                ) { dialog, input ->
                    Toast.makeText(this@NewsPage, "Comment made", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }.negativeButton { it.dismiss() }
            }
        }
    }
}
