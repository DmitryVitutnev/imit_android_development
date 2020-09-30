package ru.dmitryvitutnev.day34_database

import android.content.ContentValues
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import kotlinx.android.synthetic.main.activity_editor.*
import ru.dmitryvitutnev.day34_database.data.HotelContract
import ru.dmitryvitutnev.day34_database.data.HotelContract.GuestEntry
import ru.dmitryvitutnev.day34_database.data.HotelDbHelper


class EditorActivity : AppCompatActivity() {
    private var mGender = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        setupSpinner()
    }

    /**
     * Настраиваем spinner для выбора пола у гостя.
     */
    private fun setupSpinner() {
        val genderSpinnerAdapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.array_gender_options, R.layout.support_simple_spinner_dropdown_item
        )
        genderSpinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinner_gender!!.adapter = genderSpinnerAdapter
        spinner_gender!!.setSelection(2)
        spinner_gender!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selection = parent.getItemAtPosition(position) as String
                if (!TextUtils.isEmpty(selection)) {
                    mGender = if (selection == getString(R.string.gender_female)) {
                        HotelContract.GuestEntry.GENDER_FEMALE; // Кошка
                    } else if (selection == getString(R.string.gender_male)) {
                        HotelContract.GuestEntry.GENDER_MALE // Кот
                    } else {
                        HotelContract.GuestEntry.GENDER_UNKNOWN // Не определен
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                mGender = 2 // Unknown
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_editor, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // User clicked on a menu option in the app bar overflow menu
        when (item.getItemId()) {
            R.id.action_save -> {
                insertGuest()
                // Закрываем активность
                finish()
                return true
            }
            R.id.action_delete ->                 // Do nothing for now
                return true
            R.id.home -> {
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertGuest() {
        // Считываем данные из текстовых полей
        val name: String = edit_guest_name.getText().toString().trim()
        val city: String = edit_guest_city.getText().toString().trim()
        val ageString: String = edit_guest_age.getText().toString().trim()
        val age = ageString.toInt()
        val mDbHelper = HotelDbHelper(this)
        val db = mDbHelper.writableDatabase
        val values = ContentValues()
        values.put(GuestEntry.COLUMN_NAME, name)
        values.put(GuestEntry.COLUMN_CITY, city)
        values.put(GuestEntry.COLUMN_GENDER, mGender)
        values.put(GuestEntry.COLUMN_AGE, age)

        // Вставляем новый ряд в базу данных и запоминаем его идентификатор
        val newRowId = db.insert(GuestEntry.TABLE_NAME, null, values)

        // Выводим сообщение в успешном случае или при ошибке
        if (newRowId == -1L) {
            // Если ID  -1, значит произошла ошибка
            Toast.makeText(this, "Ошибка при заведении гостя", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Гость заведён под номером: $newRowId", Toast.LENGTH_SHORT)
                .show()
        }
    }

}
