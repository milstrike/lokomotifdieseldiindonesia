package mil.system.lokomotifdieseldiindonesia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listLokomotif;
    public DatabaseAccess databaseAccess;
    public List<String> daftarLokomotif;
    private ImageView iconBantuan, iconTentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_main);
        initLevel0();

    }

    private void initLevel0(){

        iconBantuan = findViewById(R.id.iconbantuan);
        iconTentang = findViewById(R.id.icontentang);

        databaseAccess = DatabaseAccess.getInstance(this);
        listLokomotif = (ListView) findViewById(R.id.listlokomotif);

        databaseAccess.open();
        daftarLokomotif = databaseAccess.getDaftarLokomotif();
        databaseAccess.close();

        listLokomotif.setAdapter(new AdapterLokomotif(this, daftarLokomotif));
        listLokomotif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFromList = (listLokomotif.getItemAtPosition(position).toString());
                databaseAccess.open();
                databaseAccess.getDataLokomotif(selectedFromList);
                databaseAccess.close();
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apakah Anda ingin keluar dari aplikasi \"Lokomotif Diesel di Indonesia?\"")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(1);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

    public void goToTentang(View V){
        Animation anima = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tentang_anim);
        iconTentang.startAnimation(anima);
        startActivity(new Intent(MainActivity.this, TentangActivity.class));
    }

    public void goToBantuan(View V){
        Animation anima = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bantuan_anim);
        iconBantuan.startAnimation(anima);
        startActivity(new Intent(MainActivity.this, BantuanActivity.class));
    }
}