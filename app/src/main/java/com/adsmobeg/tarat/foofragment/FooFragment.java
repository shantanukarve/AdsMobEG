package com.adsmobeg.tarat.foofragment;

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
 // The one that works
/*    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        View view =  inflater.inflate(R.layout.webfragment, parent, false);
        ValueAnimator skyAnim = ObjectAnimator.ofInt(view.findViewById(R.id.green_bg_text),"backgroundColor",
                Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));
        skyAnim.setDuration(3000);
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.start();
        return view;
    }
*/
    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
/*    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
*/
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


