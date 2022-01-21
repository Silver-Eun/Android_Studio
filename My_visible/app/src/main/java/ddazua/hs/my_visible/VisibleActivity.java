package ddazua.hs.my_visible;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VisibleActivity extends AppCompatActivity {

    Button back1, back2;
    ImageView back1_img, back2_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visible);

        back1= findViewById(R.id.back1);
        back2= findViewById(R.id.back2);
        back1_img = findViewById(R.id.back1_img);
        back2_img = findViewById(R.id.back2_img);

        back1.setOnClickListener(click);
        back2.setOnClickListener(click);

    }//onCreate()

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.back1:
                    back1_img.setVisibility(View.VISIBLE);
                    back2_img.setVisibility(View.INVISIBLE);
                    break;
                case R.id.back2:
                    back1_img.setVisibility(View.INVISIBLE);
                    back2_img.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}