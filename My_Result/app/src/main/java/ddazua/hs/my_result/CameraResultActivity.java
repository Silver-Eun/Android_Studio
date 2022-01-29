package ddazua.hs.my_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraResultActivity extends AppCompatActivity {

    ImageView imgview;
    Button btn_camera;

    final int TAKE_CAMERA = 1;//리퀘스트 코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameraresult);

        imgview = findViewById(R.id.imgview);
        btn_camera = findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                //내부 카메라로 연결
               intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

               startActivityForResult(intent, TAKE_CAMERA);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_CAMERA) {

            //카메라로 사진을 찍은 결과처리에 문제가 없을 경우
            if (resultCode == RESULT_OK) {

                //data 파라미터는 카메라 촬영이 정상적으로 완료되었다면
                //비어있지 않을 것이다.
                if (data != null) {

                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");

                    imgview.setImageBitmap(thumbnail);
                }
            }
        }
    }
}