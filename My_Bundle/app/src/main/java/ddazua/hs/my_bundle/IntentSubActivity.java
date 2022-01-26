package ddazua.hs.my_bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentSubActivity extends AppCompatActivity {

    TextView txt_name, txt_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sub);

        txt_name = findViewById(R.id.txt_name);
        txt_age = findViewById(R.id.txt_age);

        //main에서 넘겨준 intent의 정보를 sub에서 받는다.
        Intent i = getIntent();

        //String name = i.getStringExtra("m_name");
        //String age = i.getStringExtra("m_age");

        //intent에서 bundle 추출
        Bundle bundle = i.getExtras();
        String name = bundle.getString("m_name");
        String age = bundle.getString("m_age");

        txt_name.setText(name);
        txt_age.setText(age);
    }
}