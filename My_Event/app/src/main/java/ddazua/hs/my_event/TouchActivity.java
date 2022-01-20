package ddazua.hs.my_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TouchActivity extends AppCompatActivity {

    Button event_btn;
    TextView box, txt_view;
    boolean isCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        event_btn = findViewById(R.id.event_btn);
        box = findViewById(R.id.box);
        txt_view = findViewById(R.id.txt_view);

        event_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isCheck = !isCheck;

            }
        });

        //빨간색 상자(box)의 터치를 감지
        box.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                String msg = "";

                int x = 0;
                int y = 0;

                //현재 터치 상태를 구별
                switch( event.getAction() ){
                    case MotionEvent.ACTION_DOWN:
                        msg = "result : down";
                        break;
                    case MotionEvent.ACTION_UP:
                        msg = "result : up";
                        break;
                    case MotionEvent.ACTION_MOVE:
                        x = (int)event.getX();
                        y = (int)event.getY();
                        msg = "x : " + x + ", y : " +y;
                        break;
                }//switch

                txt_view.setText(msg);

                return isCheck;
            }
        });

    }//onCreate()
}