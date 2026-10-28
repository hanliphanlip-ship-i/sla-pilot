
package net.slapilot.private;
import android.app.*;
import android.content.Intent;
import android.os.IBinder;
public class SlaPilotService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        NotificationChannel ch = new NotificationChannel("slapilot","슬라 파일럿", NotificationManager.IMPORTANCE_LOW);
        ((NotificationManager)getSystemService(NOTIFICATION_SERVICE)).createNotificationChannel(ch);
        Notification n = new Notification.Builder(this,"slapilot")
            .setContentTitle("슬라 파일럿 실행중")
            .setContentText("모델 Y 2024 자동화 대기중")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .build();
        startForeground(1,n);
        return START_STICKY;
    }
    @Override public IBinder onBind(Intent i){return null;}
}
