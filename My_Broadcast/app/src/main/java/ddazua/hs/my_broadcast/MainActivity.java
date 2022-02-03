package ddazua.hs.my_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;
    Button btn_start, btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        btn_start.setOnClickListener(click);
        btn_stop.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent receiverIntent = null;

            //intent의 화면 전환 정보를 임시로 가지고 있다가
            // 이벤트 발생시 처리해주는 클래스
            PendingIntent pendingIntent = null;

            switch (view.getId()){
                case R.id.btn_start:
                    alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                    receiverIntent = new Intent(MainActivity.this,MyReceiver.class);

                    pendingIntent = PendingIntent.getBroadcast(
                            MainActivity.this, 0,
                            receiverIntent, PendingIntent.FLAG_CANCEL_CURRENT);

                    //1분 간격으로 호출될 알람
                    alarmManager.setRepeating(
                            AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(),
                            1000*5, pendingIntent);
                    break;
                case R.id.btn_stop:
                    alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                    receiverIntent = new Intent(MainActivity.this,MyReceiver.class);

                    pendingIntent = PendingIntent.getBroadcast(
                            MainActivity.this, 0,
                            receiverIntent, PendingIntent.FLAG_CANCEL_CURRENT);
                    alarmManager.cancel(pendingIntent);
                    break;
            }
        }
    };
}