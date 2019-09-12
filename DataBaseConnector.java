package com.example.chattickfront;

import android.database.sqlite.SQLiteDatabase;

public class DataBaseConnector {

    public static SQLiteDatabase sqLiteDatabase;

    public static void setSqLiteDatabase(DBHelper dbHelper){
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }
}
