package com.example.chattickfront;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRepository {

    private static final SQLiteDatabase sqLiteDatabase = DataBaseConnector.sqLiteDatabase;

    private static final String CHATS_TABLE_NAME = "chats";

    private static final String CLAUSE_CHAT_ID = "chat_id = ?";

    private static final String GET_CHATS_OF_USER = "select c.* from chats c, entry e where e.user_id = ? and c.chat_id = e.chat_id";

    public static List<Chat> getChats() {
        Cursor cursor = sqLiteDatabase.rawQuery(GET_CHATS_OF_USER, new String[]{
                AuthoriziedUser.getAuthoriziedUser().getId().toString()});

        List<Chat> chats = Collections.emptyList();
        int count = cursor.getCount();
        if (count != 0) {
            int chatIdCol = cursor.getColumnIndex("chat_id");
            int chatNameCol = cursor.getColumnIndex("chat_name");

            chats = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                cursor.move(i);
                Chat chat = new Chat(cursor.getLong(chatIdCol),
                        cursor.getString(chatNameCol));
                chats.add(chat);
            }
        }
        return chats;
    }

    public static void deleteChat(Chat chat) {
        sqLiteDatabase.delete(CHATS_TABLE_NAME, CLAUSE_CHAT_ID, new String[]{
                chat.getChatId().toString()});
    }

    public static Chat addChat(Chat chat) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("chat_id", chat.getChatId());
        contentValues.put("chat_name", chat.getChatName());
        sqLiteDatabase.insert(CHATS_TABLE_NAME, null, contentValues);
        return chat;
    }

    public static Chat updateChat(Chat chat) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("chat_name", chat.getChatName());
        sqLiteDatabase.update(CHATS_TABLE_NAME, contentValues, CLAUSE_CHAT_ID, new String[]{
                chat.getChatId().toString()});
        return chat;
    }
}
