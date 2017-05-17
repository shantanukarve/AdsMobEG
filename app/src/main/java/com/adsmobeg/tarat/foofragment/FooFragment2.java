package com.adsmobeg.tarat.foofragment;

/**
 * Created by karve on 5/3/17.
 */
/**
 * Created by karve on 4/27/17.
 */
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.JsResult;

import com.adsmobeg.tarat.adsmobeg.R;


public class FooFragment2 extends Fragment {
    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    private WebView mWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater
                .inflate(R.layout.webfragment2, parent, false);

        mWebView = (WebView) view.findViewById(R.id.simulate_view2);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new WebAppInterface(getActivity()), "Android");

        //mWebView.setWebChromeClient(new WebChromeClient() {
        //    @Override
        //    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        //        return super.onJsAlert(view, url, message, result);
        //    }
        //});

        mWebView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {
                Log.d("MyApplication", cm.message() + " -- From line "
                        + cm.lineNumber() + " of "
                        + cm.sourceId() );
                return true;
            }
        });
//        mWebView.loadUrl("http://www.example.com");
//        mWebView.loadUrl("file:///android_asset/example.html");
        mWebView.loadUrl("file:///android_asset/horizontal.html");
        return view;
    }
   // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }
        @JavascriptInterface
        public int getWinHeight() {
            return mWebView.getHeight();
        }
        @JavascriptInterface
        public int getWinWidth() {
            return mWebView.getWidth();
        }
    }

}
