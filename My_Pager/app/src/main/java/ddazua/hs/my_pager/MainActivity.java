package ddazua.hs.my_pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pager = findViewById(R.id.pager);
        //뷰 페이저가 화면으로 참조할 어댑터
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //시작 페이지
        pager.setCurrentItem(0);

        CirclePageIndicator circlePageIndicator = findViewById(R.id.circles);
        circlePageIndicator.setViewPager(pager);
    }
}