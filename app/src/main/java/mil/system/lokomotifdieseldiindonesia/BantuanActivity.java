package mil.system.lokomotifdieseldiindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class BantuanActivity extends AppCompatActivity {

    private RelativeLayout layoutBantuan;
    private ScrollView layoutScrollBantuan;
    private LinearLayout buttonbantuan;
    SharedPreferences FirstHelp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_bantuan);
        initLevel0();
        initLevel1();

    }

    private void initLevel0(){
        FirstHelp = getSharedPreferences("mil.system.lokomotifdieseldiindonesia", MODE_PRIVATE);
        layoutBantuan = findViewById(R.id.layouterBantuan);
        layoutScrollBantuan = findViewById(R.id.layouterScrollBantuan);
        buttonbantuan = findViewById(R.id.buttonBantuan);
    }

    private void initLevel1(){
        if (FirstHelp.getBoolean("firstrunning", true)) {
            buttonbantuan.setVisibility(View.VISIBLE);
            FirstHelp.edit().putBoolean("firstrun", false).commit();
        }
        else{
            buttonbantuan.setVisibility(View.GONE);
            initLevel2();
        }
    }

    private void initLevel2(){
        layoutBantuan.setOnTouchListener(new OnSwipeTouchListener(BantuanActivity.this) {
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

        layoutScrollBantuan.setOnTouchListener(new OnSwipeTouchListener(BantuanActivity.this) {
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

    public void dismissHelp(View V){
        FirstHelp.edit().putBoolean("firstrunning", false).commit();
        startActivity(new Intent(BantuanActivity.this, MainActivity.class));
        finish();
    }
}