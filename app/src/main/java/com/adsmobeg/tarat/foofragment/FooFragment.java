package com.adsmobeg.tarat.foofragment;

/**
 * Created by karve on 4/27/17.
 */
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.JsResult;

import com.adsmobeg.tarat.adsmobeg.R;

public class FooFragment extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    private WebView mWebView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater
                .inflate(R.layout.webfragment, parent, false);

        mWebView = (WebView) view.findViewById(R.id.simulate_view);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
//        mWebView.loadUrl("http://www.example.com");
//        mWebView.loadUrl("file:///android_asset/example.html");
        mWebView.loadUrl("file:///android_asset/horizontal.html");
        return view;
    }
 // The one that works
 //   public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
 //       // Defines the xml file for the fragment
 //       return inflater.inflate(R.layout.webfragment, parent, false);
 //   }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}