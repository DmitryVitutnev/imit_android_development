package ru.dmitryvitutnev.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast


class MessageReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        if (intent.action
                .equals("android.intent.action.ACTION_POWER_DISCONNECTED", ignoreCase = true)
        ) {
            val message = ("Обнаружено сообщение "
                    + intent.action)
            Toast.makeText(
                context, message,
                Toast.LENGTH_LONG
            ).show()
        }
    }

}