package ddazua.hs.my_drawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer_layout;
    View drawer;
    Button btn_main, closedrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_layout = findViewById(R.id.drawer_layout);
        drawer = findViewById(R.id.drawer);
        btn_main = findViewById(R.id.btn_main);
        closedrawer = findViewById(R.id.closedrawer);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //서랍을 연다.
                drawer_layout.openDrawer(drawer);
            }
        });

        closedrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //서랍을 닫는다.
                drawer_layout.closeDrawer(drawer);
            }
        });
    }
}