package ru.dmitryvitutnev.day12_popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.PopupMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val popupMenu = PopupMenu(this, imageView)
        popupMenu.inflate(R.menu.popupmenu)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    textView.text = "Вы выбрали PopupMenu 1"
                    true
                }
                R.id.menu2 -> {
                    textView.text = "Вы выбрали PopupMenu 2"
                    true
                }
                R.id.menu3 -> {
                    textView.text = "Вы выбрали PopupMenu 3"
                    true
                }
                else -> false
            }
        }

        imageView.setOnClickListener{
            popupMenu.show()
        }

    }
}