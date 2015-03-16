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
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("open")) {
				try {
					openN();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
			}
			return true;
	}
	private void openN() throws IOException {

		intent = new Intent(this.cordova.getActivity().getApplicationContext(), MainActivity.class);

		this.cordova.getActivity().startActivityForResult(intent,0);
		this.cordova.getActivity().startActivity(intent);
		this.cordova.getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	}

	}
}