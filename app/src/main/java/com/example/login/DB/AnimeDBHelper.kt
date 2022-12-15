package com.example.login.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.login.Anime

class AnimeDBHelper {
    class DBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(AnimeContract.SQL_CREATE_ENTRIES)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL(AnimeContract.SQL_DELETE_ENTRIES)
            onCreate(db)
        }
        companion object {
            // If you change the database schema, you must increment the database version.
            const val DATABASE_VERSION = 3
            const val DATABASE_NAME = "animes.db"
        }
        fun insertAnime(l: Anime) {
            val values = ContentValues()
            values.put(AnimeContract.COLUMN_NAME_TITLE, l.title)
            values.put(AnimeContract.COLUMN_NAME_SEASON, l.season)
            values.put(AnimeContract.COLUMN_NAME_GENRE, l.genre)

            val db = this.writableDatabase
            db.insert(AnimeContract.TABLE_NAME, null, values)
        }

        fun selectAnima():ArrayList<Anime>{
            val arrayList: ArrayList<Anime> = ArrayList();

            val db = this.readableDatabase
            val c: Cursor = db.rawQuery("SELECT * FROM " + AnimeContract.TABLE_NAME, null)
            if (c.moveToFirst()) {
                do {
                    // Passing values
                    val title: String = c.getString(1)
                    val season: String = c.getString(2)
                    val genre: String = c.getString(3)

                    arrayList.add(Anime(title, season, genre))
                } while (c.moveToNext())
            }
            c.close()
            db.close()

            return arrayList;
        }
    }
}