package mil.system.lokomotifdieseldiindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class TentangActivity extends AppCompatActivity {

    private RelativeLayout layoutTentang;
    private ScrollView layoutScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_tentang);
        initLevel0();
        initLeve1();
    }

    private void initLevel0(){
        layoutTentang = findViewById(R.id.layouterTentang);
        layoutScroll = findViewById(R.id.layouterScrollTentang);
    }

    private void initLeve1(){
        layoutTentang.setOnTouchListener(new OnSwipeTouchListener(TentangActivity.this) {
            public void onSwipeTop() {

            }
            public void onSwipeRight() {
                finish();
            }
            public void onSwipeLeft() {

            }
            public void onSwipeBottom() {

            }

        });

        layoutScroll.setOnTouchListener(new OnSwipeTouchListener(TentangActivity.this) {
            public void onSwipeTop() {

            }
            public void onSwipeRight() {
                finish();
            }
            public void onSwipeLeft() {

            }
            public void onSwipeBottom() {

            }

        });
    }
}