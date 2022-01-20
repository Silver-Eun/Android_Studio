package ddazua.hs.my_event;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickActivity extends AppCompatActivity {

    Button btn_blue, btn_red;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        //사용할 객체들을 검색
        btn_blue = findViewById(R.id.btn_blue);
        btn_red = findViewById(R.id.btn_red);
        txt = findViewById(R.id.txt);

        //버튼에 이벤트 감지자 등록
        btn_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //버튼을 클릭했을때 이벤트 처리 영역
                txt.setBackgroundColor(Color.BLUE);
            }
        });

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setBackgroundColor(Color.RED);
            }
        });
        
    }//onCreate()
}