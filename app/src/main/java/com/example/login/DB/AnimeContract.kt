package com.example.login.DB

object AnimeContract {
    val TABLE_NAME = "animes"
    val COLUMN_NAME_TITLE = "title"
    val COLUMN_NAME_SEASON = "season"
    val COLUMN_NAME_GENRE = "genre"

    val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${TABLE_NAME} (" +
                "id INTEGER PRIMARY KEY," +
                "${COLUMN_NAME_TITLE} TEXT," +
                "${COLUMN_NAME_SEASON} TEXT," +
                "${COLUMN_NAME_GENRE} TEXT)"

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"
    val SQL_DELETE_ROWS = "DELETE FROM ${TABLE_NAME}"
}
