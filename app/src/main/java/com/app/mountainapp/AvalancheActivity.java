package com.app.mountainapp;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AvalancheActivity extends BaseActivity {

    WebView webView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avalanche);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.avalanche);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initWebsite();
        listenerWebsite();
    }

    private void initWebsite(){
        webView = (WebView) findViewById(R.id.avalanche_view);
        webView.getSettings().setJavaScriptEnabled(true);

        progressDialog = new ProgressDialog(AvalancheActivity.this);
        progressDialog.setTitle("PDF");
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+getResources().
                getString(R.string.avalanche_website));
    }

    private void listenerWebsite() {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressDialog.dismiss();
            }
        });
    }
}
