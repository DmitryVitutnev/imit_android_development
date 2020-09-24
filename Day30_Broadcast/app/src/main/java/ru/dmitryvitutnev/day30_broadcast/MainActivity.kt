package ru.dmitryvitutnev.day30_broadcast

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    /*
    * В итоге у меня не заработало
    * Погуглил - возможно в последних андроидах отключили некоторые возможности
    * отправки сообщений
    * */

    val WHERE_MY_CAT_ACTION = "ru.dmitryvitutnev.action.CAT"
    val ALARM_MESSAGE = "Срочно пришлите кота!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent()
            intent.action = WHERE_MY_CAT_ACTION
            intent.putExtra("ru.dmitryvitutnev.broadcast.Message", ALARM_MESSAGE)
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            sendBroadcast(intent)
        }

    }
}