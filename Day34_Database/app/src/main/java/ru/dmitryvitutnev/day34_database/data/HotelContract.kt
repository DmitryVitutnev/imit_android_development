package ru.dmitryvitutnev.day34_database.data

import android.provider.BaseColumns


class HotelContract private constructor() {
    object GuestEntry : BaseColumns {
        const val TABLE_NAME = "guests"
        const val _ID = BaseColumns._ID
        const val COLUMN_NAME = "name"
        const val COLUMN_CITY = "city"
        const val COLUMN_GENDER = "gender"
        const val COLUMN_AGE = "age"
        const val GENDER_FEMALE = 0
        const val GENDER_MALE = 1
        const val GENDER_UNKNOWN = 2
    }
}