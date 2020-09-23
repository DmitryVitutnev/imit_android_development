package ru.dmitryvitutnev.day27_notepad

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*


class MainActivity : AppCompatActivity() {
    private val FILENAME = "sample.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onResume() {
        super.onResume()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        if (prefs.getBoolean(getString(R.string.pref_openmode), false)) {
            openFile(FILENAME)
        }

        val fSize = prefs.getString(
            getString(R.string.pref_size), "20"
        )!!.toFloat()
        editText.textSize = fSize

        val regular = prefs.getString(getString(R.string.pref_style), "")
        var typeface = Typeface.NORMAL

        if (regular!!.contains("Полужирный")) typeface += Typeface.BOLD

        if (regular!!.contains("Курсив")) typeface += Typeface.ITALIC

        editText.setTypeface(null, typeface)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            R.id.action_open -> {
                openFile(FILENAME)
                true
            }
            R.id.action_save -> {
                saveFile(FILENAME)
                true
            }
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent);
                return true;
            }
            else -> true
        }
    }

    // Метод для открытия файла
    private fun openFile(fileName: String) {
        try {
            val inputStream: InputStream? = openFileInput(fileName)
            if (inputStream != null) {
                val reader = BufferedReader(InputStreamReader(inputStream))
                var line: String?
                val builder = StringBuilder()
                line = reader.readLine()
                while (line != null) {
                    builder.append(line)
                    line = reader.readLine()
                }
                inputStream.close()
                editText.setText(builder.toString())
            }
        } catch (t: Throwable) {
            Toast.makeText(applicationContext,
                    "Exception: $t", Toast.LENGTH_LONG).show()
        }
    }

    // Метод для сохранения файла
    private fun saveFile(fileName: String) {
        try {
            val outputStream: OutputStream = openFileOutput(fileName, 0)
            val osw = OutputStreamWriter(outputStream)
            osw.write(editText.text.toString())
            osw.close()
        } catch (t: Throwable) {
            Toast.makeText(applicationContext,
                    "Exception: $t", Toast.LENGTH_LONG).show()
        }
    }
}