package ddazua.hs.ex_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

public class CalActivity extends AppCompatActivity {

    Button[] numbers; //0~9까지의 숫자버튼
    //+-*/=C버튼
    Button plus, sub, multi, div, equal, clear;

    TextView txt_result;
    String resultStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);

        txt_result = findViewById(R.id.txt_result);
        numbers = new Button[10];
        for(int i = 0; i<numbers.length; i++){
            try{
                numbers[i] = findViewById(R.id.class.getField("btn"+i)
                        .getInt(null));
                numbers[i].setOnClickListener(numberClick);
            }catch (Exception e){

            }
        }

        plus = findViewById(R.id.btn10);
        sub = findViewById(R.id.btn11);
        multi = findViewById(R.id.btn12);
        div = findViewById(R.id.btn13);
        equal = findViewById(R.id.btn14);
        clear = findViewById(R.id.btn15);

        plus.setOnClickListener(signClick);
        sub.setOnClickListener(signClick);
        multi.setOnClickListener(signClick);
        div.setOnClickListener(signClick);
        equal.setOnClickListener(signClick);
        clear.setOnClickListener(signClick);

    }//onCreate()

    View.OnClickListener numberClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //숫자버튼 클릭 감지
            resultStr += ((Button)view).getText().toString();
            txt_result.setText(resultStr);
        }
    };

    View.OnClickListener signClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //기호버튼 클릭( = 제외)
            if(view != equal){
                resultStr += " " + ((Button)view).getText().toString()+ " ";
                txt_result.setText(resultStr);

                if(view == clear){
                    resultStr = "";
                    txt_result.setText(resultStr);
                }
            }else{
                //=기호 클릭(결과처리)
                JsEvaluator jsEvaluator = new JsEvaluator(CalActivity.this);
                //evaluate(연산하고자 하는 문자열), 연산결과를 반환
                jsEvaluator.evaluate(resultStr, new JsCallback() {
                    @Override
                    public void onResult(String s) {

                        txt_result.setText(s);
                    }
                });
            }
        }
    };
}