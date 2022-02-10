package ddazua.hs.my_shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class GameView extends View implements SensorEventListener {

    Context context;
    int width, height;
    Bitmap back1, back2, unit;
    int back1_y, back2_y;
    int unitW, unitH, unitX, unitY;
    Canvas canvas;

    //토끼 이미지 관련
    Bitmap[] rabbit = new Bitmap[2];
    int imageIndex;
    int rabbitX = 100;
    int rabbitY = 100;
    int rabbitH, rabbitW;
    int speedX = 5;
    int speedY = 5;

    //센서 관련
    SensorManager sensorM;
    int h_int;

    //미사일 관련
    Bitmap missile;
    //미사일 객체를 ArrayList저장
    ArrayList<Missile> missList = new ArrayList<>();
    //미사일의 크기, 위치값
    int missileW, missileH, missileX, missileY;

    public GameView(Context context) {
        super(context);

        this.context = context;
        //현재 뷰의 크기를 알아낸다.
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        //디스플레이의 일반적인 정보를 담을 수 있도록 만들어진 클래스
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        width = dm.widthPixels;
        height = dm.heightPixels;

        //필요한 이미지들을 로드
        back1 = BitmapFactory.decodeResource(getResources(), R.mipmap.space);
        back2 = BitmapFactory.decodeResource(getResources(), R.mipmap.space);
        unit = BitmapFactory.decodeResource(getResources(), R.mipmap.gunship);
        rabbit[0] = BitmapFactory.decodeResource(getResources(), R.mipmap.rabbit);
        rabbit[1] = BitmapFactory.decodeResource(getResources(), R.mipmap.rabbit2);
        missile = BitmapFactory.decodeResource(getResources(), R.mipmap.missile);

        //배경 1, 2의 y좌표값
        back1_y = 0;
        back2_y = -height;

        init();
        initSensor();

        handler.sendEmptyMessage(0);
    }

    private void initSensor(){

        sensorM = (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        sensorM.registerListener(this, sensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }

    //초기화
    private void init(){
        back1 = Bitmap.createScaledBitmap(back1, width, height + 15, false);
        back2 = Bitmap.createScaledBitmap(back2, width, height + 15, false);

        rabbit[0] = Bitmap.createScaledBitmap(rabbit[0], width/6, height/6, false);
        rabbit[1] = Bitmap.createScaledBitmap(rabbit[1], width/6, height/6, false);

        rabbitW = rabbit[0].getWidth();//토끼이미지의 너비
        rabbitH = rabbit[0].getWidth();//토끼이미지의 높이

        missileW = missile.getWidth();//원본 미사일 이미지의 너비
        missileH = missile.getHeight();//원본 미사일 이미지의 높이

        unitW = unit.getWidth();//원본 이미지의 너비
        unitH = unit.getHeight();//원본 이미지의 높이

        unitX = width/2;
        unitY = height - 300;
    }

    //게임 진행 핸들러
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {

            h_int++;
            if(h_int % 20 == 0){
                imageIndex++;
                if(imageIndex == 2){
                    imageIndex = 0;
                }
            }

            invalidate(); //화면갱신 -onDraw()
            handler.sendEmptyMessageDelayed(0, 10);
        }
    };

    //캔버스에 이미지를 추가하는 메소드
    private void progressState(){

        canvas.drawBitmap(back1, 0, back1_y, null);
        canvas.drawBitmap(back2, 0, back2_y, null);
        canvas.drawBitmap(unit, unitX, unitY, null);
        canvas.drawBitmap(rabbit[imageIndex], rabbitX, rabbitY, null);

        //미사일 그려주기
        for(int i = 0; i < missList.size(); i++){
            Missile ms = missList.get(i);
            canvas.drawBitmap(missile, ms.x, ms.y, null);
        }

        scrollBack();
        doRabbit();
        checkMissile();
    }

    //토끼 이미지를 움직이는 메소드
    private void doRabbit(){
        rabbitX += speedX;
        rabbitY += speedY;

        //벽에 부딛혔을 때 방향전환
        if(rabbitX <= 0){
            speedX *= -1;
        }else if(rabbitX >= width - rabbitW){
            speedX *= -1;
        }

        if(rabbitY <= 0){
            speedY *= -1;
        }else if(rabbitY >= height - rabbitH){
            speedY *= -1;
        }
    }

    //배경을 움직이기 위한 메소드
    private void scrollBack(){

        back1_y += 5;
        back2_y += 5;

        //화면을 벗어난 배경을 다시 화면 꼭대기로 이동
        if(back1_y >= height){
            back1_y = -height;
        }
        if(back2_y >= height){
            back2_y = -height;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        progressState();
    }

    //센서 관련 메소드
    @Override
    public void onSensorChanged(SensorEvent event) {
        //센서의 변경사항이 감지되면 호출되는 메소드
        //x축의 값을 unitX에 저장
        unitX -= (int)event.values[0] * 5;

        //화면을 벗어나지 않도록 제어
        if(unitX <= 0){
            unitX = 0;
        }

        if(unitX >= width - unitW){
            unitX = width - unitW;
        }

        //비행기이 y좌표값
        unitY +=(int)event.values[1] * 5;

        //화면을 벗어나지 않도록 제어
        if(unitY < 0){
            unitY = 0;
        }

        if(unitY >= height - unitH){
            unitY = height - unitH;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //센서의 반응 속도
    }

    //화면을 터치 감지
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //화면이 터치되면 미사일을 발사
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Missile m1 = new Missile(unitX, unitY);
            missList.add(m1);
        }
        return true;
    }

    //미사일 이동 메소드
    private void checkMissile(){
        if(missList.size() > 0){

            for(int i = 0; i < missList.size(); i++){
                Missile ms = missList.get(i);
                ms.move();

                if(ms.isDead()){
                    //미사일의 y좌표가 화면을 벗어났다고 판단되면
                    //ArrayList에서 미사일을 제거
                    missList.remove(ms);
                }
            }//for
        }
    }
}
