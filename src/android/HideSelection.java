package com.wstorm.selectionplugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.View;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class HideSelection extends CordovaPlugin {

    private CordovaWebView webViewObject;
    private Activity activity;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        Log.i("Teste", "Passou initialize");

        super.initialize(cordova, webView);

        this.webViewObject = webView;
        this.activity = cordova.getActivity();
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        try {
            switch (action) {
            case "hideMenu":
                webViewObject.getView().setLongClickable(false);
                webViewObject.getView().setHapticFeedbackEnabled(false);
                callbackContext.success("Sucesso, n�o clicavel.");
                break;
            case "showMenu":
                webViewObject.getView().setLongClickable(true);
                webViewObject.getView().setHapticFeedbackEnabled(true);                
                callbackContext.success("Sucesso, clicavel.");
                break;
            default:
                callbackContext.error("Erro, comando n�o encontrado.");
                break;
            }
        } catch (Exception e) {
            callbackContext.error(e.getMessage());
        }
    }

}
