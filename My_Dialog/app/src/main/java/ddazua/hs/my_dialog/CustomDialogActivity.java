package ddazua.hs.my_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomDialogActivity extends AppCompatActivity {

    Dialog dialog;
    Button btn_ok, btn_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customdialog);


    }//onCreate()

    //뒤로가기 버튼 클릭 감지
    @Override
    public void onBackPressed() {
        //super.onBackPressed(); 무조건 앱 종료
        //다이얼로그 생성
        dialog = new Dialog(CustomDialogActivity.this);
        dialog.setContentView(R.layout.my_dialog);

        btn_ok = dialog.findViewById(R.id.btn_yes);
        btn_no = dialog.findViewById(R.id.btn_no);

        btn_ok.setOnClickListener(click);
        btn_no.setOnClickListener(click);

        dialog.setTitle("app name");

        //show() 메소드를 호출하지 않으면 다이얼로그가 화면에 호출되지 않음
        dialog.show();
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn_yes:
                    //앱(액티비티) 종료
                    finish();
                    break;
                case R.id.btn_no:
                    //다이얼로그 취소소
                    dialog.dismiss();
                   break;
            }
        }
    };
}