package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView messageRecyclerView;
    private MessageAdapter messageAdapter;
    private List<String> messageList;
    private EditText messageInput;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageRecyclerView = findViewById(R.id.messageList);
        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);

        // Initialize message list and adapter
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);

        // Set up RecyclerView with no scrolling
        messageRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageRecyclerView.setAdapter(messageAdapter);
        messageRecyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER); // Disable scrolling

        // Set onClickListener for send button
        Thread running=new Thread(()-> {
            SimpleClient.connect(5000);

            sendButton.setOnClickListener(v -> {
                String msg=messageInput.getText().toString();
                new Thread(() -> {
                    SimpleClient.writer.println(msg);
                    runOnUiThread(() -> {
                        messageList.add(msg);
                        messageAdapter.notifyDataSetChanged();  // Notify adapter to update
                        messageInput.setText("");               // Clear input field
                    });
                }).start();


            });
            new Thread(() -> {
                while (true) {
                    try {
                    String msg=SimpleClient.reader.readLine();
                    runOnUiThread(()-> {
                        messageList.add(msg);
                        messageAdapter.notifyDataSetChanged();
                    }); // Notify adapter to update

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        });
        running.start();
        try{
            running.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
