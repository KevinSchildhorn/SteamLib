package com.kevinschildhorn.steamlib.HTTP;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Kevin Schildhorn on Nov 03, 2014.
 *
 * HTTPRequestHandler is used to request information over an HTTP protocol
 * It is called from a platform, and uses an AsyncTask to retrieve data from the protocol API
 * When finished it calls HTTPReplyHandler functions
 */

public class HTTPRequestHandler{

    HTTPReplyHandler mReplyHandler;

    public HTTPRequestHandler (HTTPReplyHandler handler){
        mReplyHandler = handler;
    }

    public void sendRequest(final String requestURI){
        new Thread(new Runnable() {
            public void run() {

                InputStream inputStream = null;
                String result = "";
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpResponse httpResponse = httpclient.execute(new HttpGet(requestURI));
                    inputStream = httpResponse.getEntity().getContent();

                    if(inputStream != null){
                        // parse text into JSON
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
                        StringBuilder sb = new StringBuilder();

                        String line = null;
                        while ((line = reader.readLine()) != null)
                        {
                            sb.append(line + "\n");
                        }
                        mReplyHandler.HTTPRequestSuccess(new JSONObject(sb.toString()));
                    }
                    else
                        mReplyHandler.HTTPRequestFailure("Did not work!");

                } catch (Exception e) {
                    if(e.getLocalizedMessage() != null) {
                        Log.d("InputStream", e.getLocalizedMessage());
                    }else if(e.getMessage() != null) {
                        Log.d("InputStream", e.getMessage());
                    }
                    mReplyHandler.HTTPRequestFailure(e.getLocalizedMessage());
                }
            }
        }).start();
    }
}


