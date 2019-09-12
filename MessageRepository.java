package com.example.chattickfront;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageRepository {

    private static final String GET_MESSAGES_OF_CHAT = "select * from messages where chat_id = ?";
    private static final String MESSAGES_TABLE_NAME = "messages";
    private static final String CLAUSE_MESSAGE_ID = "message_id = ?";

    private static final SQLiteDatabase sqLiteDatabase = DataBaseConnector.sqLiteDatabase;


    public static List<Message> getMessagesOfChat(Long chatId) {
        Cursor cursor = sqLiteDatabase.rawQuery(GET_MESSAGES_OF_CHAT, new String[]{chatId.toString()});

        List<Message> messages = Collections.emptyList();
        int count = cursor.getCount();
        if (count != 0) {
            int messageIdCol = cursor.getColumnIndex("message_id");
            int messageTextCol = cursor.getColumnIndex("text");
            int createdByCol = cursor.getColumnIndex("created_by");
            int createdWhenCol = cursor.getColumnIndex("created_when");
            int isReadCol = cursor.getColumnIndex("is_read");
            int chatIdCol = cursor.getColumnIndex("chat_id");
            messages = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                cursor.move(i);
                Message message = new Message(cursor.getLong(messageIdCol),
                        cursor.getString(messageTextCol),
                        cursor.getString(createdWhenCol),
                        cursor.getLong(createdByCol),
                        DataTypesTransfer.longToBoolean(cursor.getLong(isReadCol)),
                        cursor.getLong(chatIdCol));
                messages.add(message);
            }
        }
        return messages;

    }

    public static Message addMessage(Message message) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", message.getMessageId());
        contentValues.put("text", message.getText());
        contentValues.put("created_by", message.getCreatedBy());
        contentValues.put("created_when", message.getCreatedWhen());
        contentValues.put("is_read", DataTypesTransfer.booleanToLong(message.isRead()));
        contentValues.put("chat_id", message.getChatId());
        sqLiteDatabase.insert(MESSAGES_TABLE_NAME, null, contentValues);
        return message;
    }

    public static void deleteMessage(Message message) {
        sqLiteDatabase.delete(MESSAGES_TABLE_NAME, CLAUSE_MESSAGE_ID, new String[]{
                message.getMessageId().toString()});
    }

    public static Message updateMessage(Message message) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("text", message.getText());
        sqLiteDatabase.update(MESSAGES_TABLE_NAME, contentValues, CLAUSE_MESSAGE_ID, new String[]{
                message.getMessageId().toString()});
        return message;
    }
}
