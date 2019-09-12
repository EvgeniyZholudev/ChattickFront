package com.example.chattickfront;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends BaseAdapter {

    private List<Message> messages = new ArrayList<>();
    private Context context;

    public MessageAdapter(Context context) {
        this.context = context;
    }

    public void add(Message message) {
        messages.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MessageView messageView = new MessageView();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Message message = (Message) getItem(i);
        if(message.isAuthorizedUserMessage()){
            view = layoutInflater.inflate(R.layout.my_message, null);
        }
        else{
            view = layoutInflater.inflate(R.layout.their_message, null);
        }

        messageView.messageText = (TextView) view.findViewById(R.id.message_body);
        view.setTag(messageView);
        messageView.messageText.setText(message.getText());
        return view;
    }

    class MessageView {

        public TextView messageText;
    }
}
