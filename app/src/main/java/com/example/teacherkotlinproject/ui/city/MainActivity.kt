package com.example.teacherkotlinproject.ui.city

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teacherkotlinproject.*
import com.example.teacherkotlinproject.ui.detail_activity.NewsDetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsAdapter.Listener {

    //1. Добавить EditText в AddAlertDialog для добавления картинки новости
    //2. Сделать проверку на добавления данных, если данные пустые, то вывести в Snackbar.
    // Если сможете вывести ошибку в Snackbar, то попробуйте вывести в EditText.error = "Exception"
    //3. ДОП(+15) Вынести повторяющиеся AlertDialogs

    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
        addAction()
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

    private fun addAction() {
        fab.setOnClickListener {
            showAddAlertDialog()
        }
    }

    private fun showAddAlertDialog() {
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)

        val inflater = layoutInflater.inflate(R.layout.alert_add, null)
        alert.setView(inflater)
        val header: TextView = inflater.findViewById(R.id.header)
        val negative: Button = inflater.findViewById(R.id.negative)
        val positive: Button = inflater.findViewById(R.id.positive)
        val title: EditText = inflater.findViewById(R.id.title_edit_text)
        val description: EditText = inflater.findViewById(R.id.description_edit_text)
        val dialog = alert.create()
        header.text = "Добавление новости"
        negative.text = "Отменить"
        positive.text = "Добавить"
        negative.setOnClickListener {
            dialog.dismiss()
        }
        positive.setOnClickListener {
            addItem(title.text.toString(), description.text.toString())
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun addItem(title: String, description: String) {
        val news = News("", title, description)
        adapter.addItem(news)
    }
}

