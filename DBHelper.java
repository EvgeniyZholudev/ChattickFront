package com.example.chattickfront;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "chattickDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS messages (\n" +
                "message_id INTEGER NOT NULL,\n" +
                "text TEXT NOT NULL,\n" +
                "created_when TEXT NOT NULL,\n" +
                "created_by INTEGER NOT NULL,\n" +
                "is_read INTEGER NOT NULL,\n" +
                "chat_id INTEGER NOT NULL,\n" +
                "PRIMARY KEY(message_id)\n" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS chats (" +
                "chat_id INTEGER NOT NULL," +
                "chat_name TEXT NOT NULL," +
                "PRIMARY KEY(chat_id)" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS auth_user (" +
                "user_id INTEGER NOT NULL," +
                "user_name TEXT NOT NULL," +
                "photo BLOB," +
                "PRIMARY KEY(user_id)" +
                ");");

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS entry (" +
                "chat_id INTEGER NOT NULL," +
                "user_id INTEGER NOT NULL" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
