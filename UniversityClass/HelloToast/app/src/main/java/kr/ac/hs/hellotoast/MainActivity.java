package kr.ac.hs.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        mShowCount = (TextView) findViewById(R.id.show_count);

    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), R.string.toast_message, Toast.LENGTH_SHORT).show();
        }
    });

    button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCount++;
            mShowCount.setText(mCount+"");
        }
    });
    }
}