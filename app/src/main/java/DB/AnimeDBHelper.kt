package DB

import android.content.ContentValues
import android.content.Context
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
            const val DATABASE_VERSION = 1
            const val DATABASE_NAME = "animes.db"
        }
        fun insertAnime(a: Anime) {
            val values = ContentValues()
            values.put(AnimeContract.COLUMN_NAME_TITLE, a.title)
            values.put(AnimeContract.COLUMN_NAME_SEASON, a.season)
            values.put(AnimeContract.COLUMN_NAME_YEAR, a.year)

            val db = this.writableDatabase
            db.insert(AnimeContract.TABLE_NAME, null, values)
        }
    }
}