
package net.slapilot.private;
import android.app.*;
import android.os.Bundle;
import android.widget.*;
import android.view.Gravity;
import android.graphics.Color;
import android.content.Intent;
public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50,120,50,50);
        layout.setBackgroundColor(Color.parseColor("#0a0a0a"));
        TextView title = new TextView(this);
        title.setText("슬라 파일럿"); title.setTextSize(30); title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER); title.setPadding(0,0,0,10);
        TextView sub = new TextView(this);
        sub.setText("모델 Y 2024 개인용 풀옵션\n모든 문구 한글\n\n한파 자동 예열\n폭염 자동 냉방\n집 도착 충전구 열기\n심야 센트리\n고속 과속 방지\n퇴근길 AI 브리핑\n구글 시트 자동 차계부");
        sub.setTextColor(Color.parseColor("#CCCCCC")); sub.setTextSize(15); sub.setLineSpacing(6,1);
        Button btn = new Button(this);
        btn.setText("백그라운드 서비스 시작");
        btn.setOnClickListener(v -> {
            Intent i = new Intent(this, SlaPilotService.class);
            if (android.os.Build.VERSION.SDK_INT >= 26) startForegroundService(i); else startService(i);
            Toast.makeText(this, "슬라 파일럿 서비스 시작됨", Toast.LENGTH_LONG).show();
        });
        layout.addView(title); layout.addView(sub); layout.addView(btn);
        setContentView(layout);
    }
}
