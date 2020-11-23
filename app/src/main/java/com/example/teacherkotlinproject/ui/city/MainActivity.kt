package com.example.teacherkotlinproject.ui.city

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.*
import com.example.teacherkotlinproject.ui.detail_activity.NewsDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsAdapter.Listener {

    //Прочитать про Snackbar
    //Прочитать про AlertDialog
    //Прочитать про Floating Action Button (FAB)
    //Сделать кастомизацию Alert Dialog -> 1. Заменить шрифт; 2. Сделать закругления; 3. Сделать кастомные кнопки
    //Выполнить все предыдущие дз.

    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = NewsAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        adapter.updateItems(newsArray)
    }


    override fun onItemClick(item: News) {
        val intent = Intent(this, NewsDetailActivity::class.java)
        intent.putExtra("news_item", news)
        startActivity(intent)
    }

    private var news: News? = null
    private var position: Int? = null
    override fun onLongItemClick(item: News, position: Int) {
        news = item
        this.position = position
        showDeleteAlertDialog()
    }

    private fun deleteItem() {
        showSnackbar(recycler_view, "Новость был удалена.", "Востановить", this::restoreNewsItem)
        adapter.deleteItem(position!!)
    }

    private fun restoreNewsItem() {
        if (news != null && position != null) adapter.restoreItem(news!!, position!!)
    }

    private fun showDeleteAlertDialog() {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)

        val inflater = layoutInflater.inflate(R.layout.alert_delete, null)
        alert.setView(inflater)
        val header: TextView = inflater.findViewById(R.id.header)
        val negative: Button = inflater.findViewById(R.id.negative)
        val positive: Button = inflater.findViewById(R.id.positive)
        val dialog = alert.create()
        header.text = "Вы уверены что хотите удалить элемент?"
        negative.text = "Отменить"
        positive.text = "Удалить"
        negative.setOnClickListener {
            dialog.dismiss()
        }
        positive.setOnClickListener {
            deleteItem()
            dialog.dismiss()
        }
        dialog.show()
    }
}

