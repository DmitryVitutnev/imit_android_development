package ru.dmitryvitutnev.day34_database.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import ru.dmitryvitutnev.day34_database.data.HotelContract.GuestEntry


class HotelDbHelper(context: Context?) :
    SQLiteOpenHelper(
        context,
        DATABASE_NAME,
        null,
        DATABASE_VERSION
    ) {
    override fun onCreate(db: SQLiteDatabase) {
        // Строка для создания таблицы
        val SQL_CREATE_GUESTS_TABLE = ("CREATE TABLE " + GuestEntry.TABLE_NAME + " ("
                + GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GuestEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + GuestEntry.COLUMN_CITY + " TEXT NOT NULL, "
                + GuestEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT 3, "
                + GuestEntry.COLUMN_AGE + " INTEGER NOT NULL DEFAULT 0);")

        // Запускаем создание таблицы
        db.execSQL(SQL_CREATE_GUESTS_TABLE)
    }


    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        db.execSQL("DROP TABLE IF IT EXISTS " + GuestEntry.TABLE_NAME);

        onCreate(db);
    }

    companion object {
        val LOG_TAG = HotelDbHelper::class.java.simpleName

        private const val DATABASE_NAME = "hotel.db"

        private const val DATABASE_VERSION = 1
    }
}