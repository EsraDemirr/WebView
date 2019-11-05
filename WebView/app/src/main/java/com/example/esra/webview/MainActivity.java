package com.example.esra.webview;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //webView'i tasarımdakiyle Bağlıyoruz
        webView = (WebView) findViewById(R.id.Web);

        //webView'i JavaScript kodlarını çalıştıracak şekilde set ediyoruz.
        webView.getSettings().setJavaScriptEnabled(true);

        //Sayfanın yüklendiğinin anlaşılması için ProgressDialog oluşturuyoruz.
        final ProgressDialog progressDialog = ProgressDialog.show(this,"Deneme","Sayfa Yükleniyor...",true);

        //Sayfa yükenirken bir hata oluşursa kullanıcıyı uuyarıyoruz.
        webView.setWebViewClient(new WebViewClient() {

            // Sayfa Yüklenirken bir hata oluşursa kullanıcıyı uyarıyoruz.
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "İnternet Bağlantısı Yok!",
                        Toast.LENGTH_SHORT).show();
                //İstege bağlı olarak bir hata sayfası oluşturulup oraya yönlendirme yapılabilir.
                //setContentView( R.layout.hata);
            }


        // Sayfanın yüklenme işlemi bittiğinde progressDialog'u kapatıyoruz.
          @Override
          public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
         if (progressDialog.isShowing())
            progressDialog.dismiss();
        }
        });

        //Web sayfamızın url'ini webView'e yüklüyoruz.
        webView.loadUrl("https://www.vbd.org.tr/");
    }
}
