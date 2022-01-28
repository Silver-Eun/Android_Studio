package ddazua.hs.my_canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //그림으로 그리는 메소드

        //그림을 그리기 위해 필요한 붓과 같은 객체
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);

        //캔버스에 사각형 그리기
        canvas.drawRect(100, 200, 300, 400, paint);
        
        //테두리만 있는 도형을 그리기 위한 준비
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);//테두리 두께

        //캔버스에 원 그리기
        canvas.drawCircle(200, 600, 100, paint);
    }
}
