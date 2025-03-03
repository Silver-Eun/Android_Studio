package kr.ac.hs.tabhostexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();


        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("ONE").setIndicator("TAB ONE");
        tabSpecSong.setContent(R.id.tab1);
        tabHost.addTab(tabSpecSong);

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("TWO").setIndicator("TAB TWO");
        tabSpecArtist.setContent(R.id.tab2);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("THREE").setIndicator("TAB THREE");
        tabSpecAlbum.setContent(R.id.tab3);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);
    }
}