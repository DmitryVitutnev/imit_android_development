package ru.dmitryvitutnev.day34_database

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_first.*
import ru.dmitryvitutnev.day34_database.data.HotelContract.GuestEntry
import ru.dmitryvitutnev.day34_database.data.HotelDbHelper


class MainActivity : AppCompatActivity() {

    private var mDbHelper: HotelDbHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val intent = Intent(this, EditorActivity::class.java)
            startActivity(intent)
        }

        mDbHelper = HotelDbHelper(this);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_insert_new_data ->  {             // Пока ничего не делаем
                insertGuest()
                displayDatabaseInfo()
                return true;
            }
            R.id.action_delete_all_entries -> {
                return true
            }                 // Пока ничего не делаем

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        displayDatabaseInfo()
    }

    private fun displayDatabaseInfo() {
        // Создадим и откроем для чтения базу данных
        val db: SQLiteDatabase = mDbHelper!!.getReadableDatabase()

        // Зададим условие для выборки - список столбцов
        val projection = arrayOf(
            GuestEntry._ID,
            GuestEntry.COLUMN_NAME,
            GuestEntry.COLUMN_CITY,
            GuestEntry.COLUMN_GENDER,
            GuestEntry.COLUMN_AGE
        )

        // Делаем запрос
        val cursor: Cursor = db.query(
            GuestEntry.TABLE_NAME,  // таблица
            projection,  // столбцы
            null,  // столбцы для условия WHERE
            null,  // значения для условия WHERE
            null,  // Don't group the rows
            null,  // Don't filter by row groups
            null
        ) // порядок сортировки

        try {
            text_view_info.text = """Таблица содержит ${cursor.getCount().toString()} гостей.

"""
            text_view_info.append(
                """${GuestEntry._ID} - ${GuestEntry.COLUMN_NAME} - ${GuestEntry.COLUMN_CITY} - ${GuestEntry.COLUMN_GENDER} - ${GuestEntry.COLUMN_AGE}
"""
            )

            // Узнаем индекс каждого столбца
            val idColumnIndex: Int = cursor.getColumnIndex(GuestEntry._ID)
            val nameColumnIndex: Int = cursor.getColumnIndex(GuestEntry.COLUMN_NAME)
            val cityColumnIndex: Int = cursor.getColumnIndex(GuestEntry.COLUMN_CITY)
            val genderColumnIndex: Int = cursor.getColumnIndex(GuestEntry.COLUMN_GENDER)
            val ageColumnIndex: Int = cursor.getColumnIndex(GuestEntry.COLUMN_AGE)

            // Проходим через все ряды
            while (cursor.moveToNext()) {
                // Используем индекс для получения строки или числа
                val currentID: Int = cursor.getInt(idColumnIndex)
                val currentName: String = cursor.getString(nameColumnIndex)
                val currentCity: String = cursor.getString(cityColumnIndex)
                val currentGender: Int = cursor.getInt(genderColumnIndex)
                val currentAge: Int = cursor.getInt(ageColumnIndex)
                // Выводим значения каждого столбца
                text_view_info.append(
                    """
$currentID - $currentName - $currentCity - $currentGender - $currentAge"""
                )
            }
        } finally {
            // Всегда закрываем курсор после чтения
            cursor.close()
        }
    }

    private fun insertGuest() {

        // Gets the database in write mode
        val db = mDbHelper!!.writableDatabase
        // Создаем объект ContentValues, где имена столбцов ключи,
        // а информация о госте является значениями ключей
        val values = ContentValues()
        values.put(GuestEntry.COLUMN_NAME, "Мурзик")
        values.put(GuestEntry.COLUMN_CITY, "Мурманск")
        values.put(GuestEntry.COLUMN_GENDER, GuestEntry.GENDER_MALE)
        values.put(GuestEntry.COLUMN_AGE, 7)
        val newRowId = db.insert(GuestEntry.TABLE_NAME, null, values)
    }


}