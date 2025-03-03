package kr.ac.hs.messageexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message2);

        Intent intent = getIntent();
        String  messageText = intent.getStringExtra("message");
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(messageText);
    }
}