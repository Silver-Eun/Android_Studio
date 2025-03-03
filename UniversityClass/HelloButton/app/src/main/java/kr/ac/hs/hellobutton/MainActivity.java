package kr.ac.hs.hellobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private View.OnClickListener change;
    private int word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word = 0;

        button = (Button) findViewById(R.id.button);
        change = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                word++;
                if (word % 2 == 1)
                    button.setText("버튼");
                if (word % 2 == 0)
                    button.setText("BUTTON");
            }
        };
        button.setOnClickListener(change);
    }
}