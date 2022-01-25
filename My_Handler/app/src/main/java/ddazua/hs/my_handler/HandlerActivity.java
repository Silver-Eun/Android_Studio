package ddazua.hs.my_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class HandlerActivity extends AppCompatActivity {

    TextView txt_count;
    Button btn_start, btn_stop;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        txt_count = findViewById(R.id.txt_count);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(click);
        btn_stop.setOnClickListener(click);

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_start:
                    //핸들러 실행
                    hanlder.sendEmptyMessage(0);

                    btn_start.setEnabled(false);//버튼 클릭 비활성화
                    break;
                case R.id.btn_stop:
                    //핸들러 정지
                    hanlder.removeMessages(0);

                    btn_start.setEnabled(true);//버튼 클릭 활성화
                    break;
            }//switch
        }
    };

    //카운트를 증가시키는 핸들러
    Handler hanlder = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            //super.handleMessage(msg);
            //일정 간격으로 핸들러 자신을 반복 호출
            hanlder.sendEmptyMessageDelayed(0, 1000);

            txt_count.setText(String.valueOf(++count));

        }
    };
}