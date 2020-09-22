package ru.dmitryvitutnev.day23_manual

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


internal class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent
        //получаем строку и формируем имя ресурса
        val resName = "n" + intent.getIntExtra("title", 0)
        Log.i("name", resName)
        val context: Context = baseContext //получаем контекст

        //читаем текстовый файл из ресурсов по имени
        val text = readRawTextFile(
            context, resources.getIdentifier(
                resName,
                "raw", "ru.dmitryvitutnev.day23_manual"
            )
        )
        webView.loadDataWithBaseURL(null, text!!, "text/html", "en_US", null)
    }

    private fun readRawTextFile(context: Context, resId: Int): String? {
        val buffReader = BufferedReader(InputStreamReader(context.getResources().openRawResource(resId)))
        var line: String?
        val builder = StringBuilder()
        try {
            line = buffReader.readLine()
            while (line != null) {
                builder.append(line)
                builder.append("\n")
                line = buffReader.readLine()
            }
        } catch (e: IOException) {
            return null
        }
        return builder.toString()
    }
}