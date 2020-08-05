package mil.system.lokomotifdieseldiindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences FirstSplash = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initLevel0();
    }

    private void initLevel0(){
        FirstSplash = getSharedPreferences("mil.system.lokomotifdieseldiindonesia", MODE_PRIVATE);


        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                initLevel1();
            }
        }, SPLASH_TIME_OUT);
    }

    private void initLevel1(){
        if (FirstSplash.getBoolean("firstrunner", true)) {
            FirstSplash.edit().putBoolean("firstrunner", false).commit();
            Intent i = new Intent(SplashActivity.this, BantuanActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
        else{
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }
    }
}