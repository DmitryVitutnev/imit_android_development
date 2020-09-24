package ru.dmitryvitutnev.periodic

import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val mTimeBroadCastReceiver: TimeBroadcastReceiver = TimeBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun registerBroadcastReceiver(view: View?) {
        this.registerReceiver(
            mTimeBroadCastReceiver, IntentFilter(
                "android.intent.action.TIME_TICK"
            )
        )
        Toast.makeText(
            applicationContext, "Приёмник включен",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun unregisterBroadcastReceiver(view: View?) {
        unregisterReceiver(mTimeBroadCastReceiver)
        Toast.makeText(applicationContext, "Приёмник выключён", Toast.LENGTH_SHORT)
            .show()
    }
}
