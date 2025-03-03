package kr.ac.hs.challengetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText1=(EditText)findViewById(R.id.editText1);
        final EditText editText2=(EditText)findViewById(R.id.editText2);
        final EditText editText3=(EditText)findViewById(R.id.editText3);

        Button button=(Button)findViewById(R.id.button);

        final TextView textView1=(TextView)findViewById(R.id.textView1);
        final TextView textView2=(TextView)findViewById(R.id.textView2);
        final TextView textView3=(TextView)findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("First Name "+ editText1.getText());
                textView2.setText("Last Name "+ editText2.getText());
                textView3.setText("Email "+ editText3.getText());
            }
        });
    }
}