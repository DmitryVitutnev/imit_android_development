package ru.dmitryvitutnev.bootreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


class BootReceiver : BroadcastReceiver() {
    var mContext: Context? = null
    private val BOOT_ACTION = "android.intent.action.BOOT_COMPLETED"
    override fun onReceive(context: Context, intent: Intent) {
        mContext = context
        val action = intent.action
        if (action.equals(BOOT_ACTION, ignoreCase = true)) {
            //для Activity
            val activivtyIntent = Intent(context, MainActivity::class.java)
            activivtyIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(activivtyIntent)
        }
    }
}