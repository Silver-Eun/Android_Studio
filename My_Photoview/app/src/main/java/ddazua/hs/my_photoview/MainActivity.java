package ddazua.hs.my_photoview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {

    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = findViewById(R.id.photo);

        //이미지 뷰와 PhotoViewAttacher를 연결
        PhotoViewAttacher attacher = new PhotoViewAttacher(photo);
        attacher.update();

    }
}