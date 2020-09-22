package ru.dmitryvitutnev.day23_manual

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val titles = arrayOf(
            "00. Начало",
            "01. Чем кормить кота.",
            "02. Как гладить кота."
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, titles)
        listView.isTextFilterEnabled = true

        listView.onItemClickListener = OnItemClickListener { a, v, position, id ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("title", position)

            startActivity(intent)
        }
    }
}