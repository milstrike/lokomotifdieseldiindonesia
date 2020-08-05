package mil.system.lokomotifdieseldiindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class OnlineActivity extends AppCompatActivity {

    private LinearLayout progeress;
    private WebView informationViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#FFFFFF"));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        setContentView(R.layout.activity_online);
        setTitle("Sumber Online: " + GeneralVariable.dataLokomotif[1]);
        initLevel0();
        initLevel1();
        initLevel2();
    }

    private void initLevel0(){
        progeress = findViewById(R.id.progeress);
        informationViewer = findViewById(R.id.info_viewer);
    }

    private void initLevel1(){
        loadPage(GeneralVariable.dataLokomotif[37]);
    }

    private void initLevel2(){

    }


    private void loadPage(String URL){
        progeress.setVisibility(View.VISIBLE);

        WebChromeClient webChromeClient = new WebChromeClient();
        informationViewer.getSettings().setJavaScriptEnabled(true);
        informationViewer.setWebChromeClient(webChromeClient);
        informationViewer.setBackgroundColor(0x00000000);
        informationViewer.setLayerType(WebView.LAYER_TYPE_SOFTWARE, null);
        informationViewer.setWebViewClient(new loaderProgress());
        informationViewer.loadUrl(URL);
        ButtonClickJavascriptInterface myJavaScriptInterface = new OnlineActivity.ButtonClickJavascriptInterface(OnlineActivity.this);
        informationViewer.addJavascriptInterface(myJavaScriptInterface, "MyFunction");
        informationViewer.getSettings().setJavaScriptEnabled(true);
        //progress.show();
    }

    private class loaderProgress extends WebViewClient {



        public void onPageFinished (WebView view, String url) {
            progeress.setVisibility(View.GONE);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            informationViewer.loadUrl("file:///android_asset/webpage/index.html");
        }
    }

    public class ButtonClickJavascriptInterface {
        Context mContext;
        ButtonClickJavascriptInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void onActivityChooser(String destination, String key) {

        }
    }
}