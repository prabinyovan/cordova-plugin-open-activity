package com.example.sample;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import com.example.sample.MainActivity;

public class Hello extends CordovaPlugin
{
    private static final String TAG   = "CustomPlugin";

    private CallbackContext callbackContext = null;
    private MainActivity activity = null;

    /** 
     * Override the plugin initialise method and set the Activity as an 
     * instance variable.
     */
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) 
    {
        super.initialize(cordova, webView);

        // Set the Activity.
        this.activity = (MainActivity) cordova.getActivity();
    }

    /**
     * Here you can delegate any JavaScript methods. The "action" argument will contain the
     * name of the delegated method and the "args" will contain any arguments passed from the
     * JavaScript method.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
    {
        this.callbackContext = callbackContext;

        Log.d(TAG, callbackContext.getCallbackId() + ": " + action);

        if (action.equals("greet")) 
        {
        	try{
        		String message = this.callNativeMethod();
            	callbackContext.success(message);
    			return true;
        	}catch(Exception ex){
        		callbackContext.error(ex.toString());
    			return false;
        	}
        	
        }
        else
        {
            return false;
        }

    }

    private String callNativeMethod()
    {
        // Here we simply call the method from the Activity.
    	return this.activity.GetSomeString();
    }
}