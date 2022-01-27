package ddazua.hs.my_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PreferenceActivity extends AppCompatActivity {

    TextView value;
    Button btn_up, btn_down;
    int n = 0;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        pref = PreferenceManager.getDefaultSharedPreferences(PreferenceActivity.this);

        //저장된 값을 로드
        n = pref.getInt("save", 0);

        value = findViewById(R.id.value);
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);

        value.setText(String.valueOf(n));

        btn_up.setOnClickListener(click);
        btn_down.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_up:
                    value.setText(String.valueOf(++n));
                    break;
                case R.id.btn_down:
                    value.setText(String.valueOf(--n));
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //n값을 저장
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt("save", n);
        edit.commit();//값을 물리적으로 저장
    }
}