package com.example.chattickfront;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageAdapter = new MessageAdapter(this);
        listView = findViewById(R.id.messages_view);
        listView.setAdapter(messageAdapter);

        AuthoriziedUser.setAuthoriziedUser(new User(1L, "Evgeniy", null));

        try {
            DBHelper dbHelper = new DBHelper(this);
            DataBaseConnector.setSqLiteDatabase(dbHelper);
            MessageRepository.addMessage(new Message(1L, "Hi", "755", 1L, true, 1L));
            MessageRepository.addMessage(new Message(21L, "Hi", "755", 2L, true, 1L));
            MessageRepository.addMessage(new Message(3L, "Hi", "755", 1L, true, 1L));
            MessageRepository.addMessage(new Message(4L, "Hi", "755", 2L, true, 1L));
            List<Message> messages = MessageRepository.getMessagesOfChat(1L);
            for (Message message : messages) {
                messageAdapter.add(message);
            }
        }
        catch (Exception e){
            messageAdapter.add(new Message(null, e.getMessage(), null, null, null, null));
        }

    }
}
