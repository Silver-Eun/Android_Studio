package ddazua.hs.my_sweetalert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

public class SweetAlertActivity extends AppCompatActivity {

    SweetAlertDialog sweetAlertDialog;
    Button btn_warning, btn_error, btn_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweetalert);

        btn_warning = findViewById(R.id.warning);
        btn_error = findViewById(R.id.error);
        btn_success = findViewById(R.id.success);

        btn_warning.setOnClickListener(click);
        btn_error.setOnClickListener(click);
        btn_success.setOnClickListener(click);

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch(view.getId()){
                case R.id.error:
                    sweetAlert(getString(R.string.alert_error),
                            SweetAlertDialog.ERROR_TYPE, SweetAlertActivity.this);
                    break;
                case R.id.warning:
                    sweetAlert(getString(R.string.alert_warning),
                            SweetAlertDialog.WARNING_TYPE, SweetAlertActivity.this);
                    break;
                case R.id.success:
                    sweetAlert(getString(R.string.alert_success),
                            SweetAlertDialog.SUCCESS_TYPE, SweetAlertActivity.this);
                    break;
            }
        }
    };

    //타입별 다이얼로그 호출 메소드
    private void sweetAlert( String title, int type, Context context){

        sweetAlertDialog = new SweetAlertDialog(context, type);
        sweetAlertDialog.setTitleText(title);
        sweetAlertDialog.setConfirmText("OK");

        sweetAlertDialog.show();
    }//sweetAlert()
}