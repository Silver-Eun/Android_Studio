package ddazua.hs.my_swipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SwipeActivity extends AppCompatActivity {

    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        refreshLayout = findViewById(R.id.swipe);

        //디스크 배경색
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.argb(255,127,179,255));

        //화면이 당겨진 것을 감지하기 위한 감지자
        refreshLayout.setOnRefreshListener(listener);
    }

    SwipeRefreshLayout.OnRefreshListener listener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            h.sendEmptyMessageDelayed(0, 3000);

        }
    };

    //로딩을 한다고 가정한 핸들러
    Handler h = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            //로딩 완료시 디스크 제거
            refreshLayout.setRefreshing(false);
        }
    };
}