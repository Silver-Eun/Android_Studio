package ddazua.hs.my_broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //외부에서 브로드캐스트를 호출하면 실행되는 메소드

        //알림 객체
        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(context)
                .setContentTitle("noti title")
                .setContentText("noti text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

        //알림 매니저를 통해 알림을 전송
        manager.notify(0, notification);
    }
}