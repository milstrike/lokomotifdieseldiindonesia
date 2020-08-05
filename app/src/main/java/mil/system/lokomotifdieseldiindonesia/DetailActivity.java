package mil.system.lokomotifdieseldiindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {

    private TextView namaLoko, modelLoko, deskripsiLoko, sumberTenaga, produsen, model, tanggalDibuat, susunanRodaAAR, klasifikasiUIC, lebarSepur, diameterRodaPenggerak, diameterRodaIdle, panjang, lebar, tinggiMaksimum, jarakAntarAlatPerangkai, jarakAntarpivot, tinggiAlatPerangkai, beratKosong, beratAdhesi, kapasitasBahanBakar, kapasitaPelumas, kapasitasAirPendingin, kapasitasBakPasir, penggerakUtama, jenisMesin, generator, motorTraksi, tipeMotorTraksi, kecepatanMaksimum, dayaMesin, dayaKeGenerator, jariJariLengkung, daerahOperasi, mulaiDinas, keadaan;
    private ImageView gambarLoko, iconWeb;
    private RelativeLayout detailAct, guidance;
    private ScrollView detailScroll;
    private AssetManager assetManager;
    private String Paths = "";
    private InputStream is = null;
    SharedPreferences FirstPrefrs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_detail);
        initLevel0();
        initLevel1();
        initLevel2();
        initLevel3();
        initLevel4();
    }

    private void initLevel0(){
        assetManager = getApplicationContext().getAssets();
        iconWeb = findViewById(R.id.iconweb);
        detailAct = findViewById(R.id.detailer);
        detailScroll = findViewById(R.id.detailList);
        guidance = findViewById(R.id.petunjukswipe);
        gambarLoko = findViewById(R.id.gambarlokomotif);
        namaLoko = findViewById(R.id.detailNamaLokomotif);
        modelLoko = findViewById(R.id.detailModelLokomotif);
        deskripsiLoko = findViewById(R.id.detaildeskripsi);
        sumberTenaga = findViewById(R.id.detailsumbertenaga);
        produsen = findViewById(R.id.detailprodusen);
        model = findViewById(R.id.detailmodel);
        tanggalDibuat = findViewById(R.id.detailtanggaldibuat);
        susunanRodaAAR = findViewById(R.id.detailsusunanroda);
        klasifikasiUIC = findViewById(R.id.detailklasifikasiUIC);
        lebarSepur = findViewById(R.id.detaillebarsepur);
        diameterRodaPenggerak = findViewById(R.id.detaildiameterrodapenggerak);
        diameterRodaIdle = findViewById(R.id.detaildiameterrodaidle);
        panjang = findViewById(R.id.detailpanjang);
        lebar = findViewById(R.id.detaillebar);
        tinggiMaksimum = findViewById(R.id.detailtinggimaksimum);
        jarakAntarAlatPerangkai = findViewById(R.id.detailjarakantaraalatperangkai);
        jarakAntarpivot = findViewById(R.id.detailjarakantarpivot);
        tinggiAlatPerangkai = findViewById(R.id.detailtinggiperangkai);
        beratKosong = findViewById(R.id.detailberatkosong);
        beratAdhesi = findViewById(R.id.detailberatadhesi);
        kapasitasBahanBakar = findViewById(R.id.detailkapasitasbahanbakar);
        kapasitaPelumas = findViewById(R.id.detailkapasitaspelumas);
        kapasitasAirPendingin = findViewById(R.id.detailkapasitasairpendingin);
        kapasitasBakPasir = findViewById(R.id.detailkapasitasbakpasir);
        penggerakUtama = findViewById(R.id.detailpenggerakutama);
        jenisMesin = findViewById(R.id.detailjenismesin);
        generator = findViewById(R.id.detailgenerator);
        motorTraksi = findViewById(R.id.detailmotortraksi);
        tipeMotorTraksi = findViewById(R.id.detailtipemotortraksi);
        kecepatanMaksimum = findViewById(R.id.detailkecepatanmaksimum);
        dayaMesin = findViewById(R.id.detaildayamesin);
        dayaKeGenerator = findViewById(R.id.detaildayakegeneratorconverter);
        jariJariLengkung = findViewById(R.id.detailjarijarilengkungterkecil);
        daerahOperasi = findViewById(R.id.detaildaerahoperasi);
        mulaiDinas = findViewById(R.id.detailmulaidinas);
        keadaan = findViewById(R.id.detailkeadaan);
    }

    private void initLevel1(){
        FirstPrefrs = getSharedPreferences("mil.system.lokomotifdieseldiindonesia", MODE_PRIVATE);
        try {
            is = assetManager.open("img/n"+GeneralVariable.dataLokomotif[0]+".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        gambarLoko.setImageBitmap(bitmap);
    }

    @SuppressLint("SetTextI18n")
    private void initLevel2(){
        namaLoko.setText(GeneralVariable.dataLokomotif[1] +"");
        modelLoko.setText("Model: " + GeneralVariable.dataLokomotif[4] +"");
        deskripsiLoko.setText(GeneralVariable.dataLokomotif[36] +"");
        sumberTenaga.setText(GeneralVariable.dataLokomotif[2] +"");
        produsen.setText(GeneralVariable.dataLokomotif[3] +"");
        model.setText(GeneralVariable.dataLokomotif[4] +"");
        tanggalDibuat.setText(GeneralVariable.dataLokomotif[5] +"");
        susunanRodaAAR.setText(GeneralVariable.dataLokomotif[6] +"");
        klasifikasiUIC.setText(GeneralVariable.dataLokomotif[7] +"");
        lebarSepur.setText(GeneralVariable.dataLokomotif[8] +"");
        diameterRodaPenggerak.setText(GeneralVariable.dataLokomotif[9] +"");
        diameterRodaIdle.setText(GeneralVariable.dataLokomotif[10] +"");
        panjang.setText(GeneralVariable.dataLokomotif[11] +"");
        lebar.setText(GeneralVariable.dataLokomotif[12] +"");
        tinggiMaksimum.setText(GeneralVariable.dataLokomotif[13] +"");
        jarakAntarAlatPerangkai.setText(GeneralVariable.dataLokomotif[14] +"");
        jarakAntarpivot.setText(GeneralVariable.dataLokomotif[15] +"");
        tinggiAlatPerangkai.setText(GeneralVariable.dataLokomotif[16] +"");
        beratKosong.setText(GeneralVariable.dataLokomotif[17] +"");
        beratAdhesi.setText(GeneralVariable.dataLokomotif[18] +"");
        kapasitasBahanBakar.setText(GeneralVariable.dataLokomotif[19] +"");
        kapasitaPelumas.setText(GeneralVariable.dataLokomotif[20] +"");
        kapasitasAirPendingin.setText(GeneralVariable.dataLokomotif[21] +"");
        kapasitasBakPasir.setText(GeneralVariable.dataLokomotif[22] +"");
        penggerakUtama.setText(GeneralVariable.dataLokomotif[23] +"");
        jenisMesin.setText(GeneralVariable.dataLokomotif[24] +"");
        generator.setText(GeneralVariable.dataLokomotif[25] +"");
        motorTraksi.setText(GeneralVariable.dataLokomotif[26] +"");
        tipeMotorTraksi.setText(GeneralVariable.dataLokomotif[27] +"");
        kecepatanMaksimum.setText(GeneralVariable.dataLokomotif[28] +"");
        dayaMesin.setText(GeneralVariable.dataLokomotif[29] +"");
        dayaKeGenerator.setText(GeneralVariable.dataLokomotif[30] +"");
        jariJariLengkung.setText(GeneralVariable.dataLokomotif[31] +"");
        daerahOperasi.setText(GeneralVariable.dataLokomotif[32] +"");
        mulaiDinas.setText(GeneralVariable.dataLokomotif[33] +"");
        keadaan.setText(GeneralVariable.dataLokomotif[34] +"");
    }

    private void initLevel3(){
        detailAct.setOnTouchListener(new OnSwipeTouchListener(DetailActivity.this) {
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

        detailScroll.setOnTouchListener(new OnSwipeTouchListener(DetailActivity.this) {
            public void onSwipeTop() {

            }
            public void onSwipeRight() {
                FirstPrefrs.edit().putBoolean("firstrun", false).commit();
                finish();
            }
            public void onSwipeLeft() {

            }
            public void onSwipeBottom() {

            }

        });

        guidance.setOnTouchListener(new OnSwipeTouchListener(DetailActivity.this) {
            public void onSwipeTop() {

            }
            public void onSwipeRight() {
                FirstPrefrs.edit().putBoolean("firstrun", false).commit();
                finish();
            }
            public void onSwipeLeft() {

            }
            public void onSwipeBottom() {

            }

        });
    }

    private void initLevel4(){
        if (FirstPrefrs.getBoolean("firstruns", true)) {
            guidance.setVisibility(View.VISIBLE);
            FirstPrefrs.edit().putBoolean("firstruns", false).commit();
        }
        else{
            guidance.setVisibility(View.GONE);
        }
    }

    public void confirmGuidanceCancelation(View V){
        guidance.setVisibility(View.GONE);
        FirstPrefrs.edit().putBoolean("firstruns", false).commit();
    }

    public void gotoOnlineActivity(View V){
        Animation anima = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.web_anim);
        iconWeb.startAnimation(anima);
        startActivity(new Intent(DetailActivity.this, OnlineActivity.class));
    }
}