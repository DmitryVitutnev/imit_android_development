package ru.dmitryvitutnev.bootreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    /*
     * Запуск при старте на эмуляторе не заработал.
     * На реальное устройство боюсь ставить
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
