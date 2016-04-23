package com.example.mkrzywan.teleinformatyka;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MKRZYWAN on 20.03.2016.
 */
public class HttpHelper {

    private static String ADDRESS = "http://192.168.0.100";
    private static String PORT = "5000";
    private static String SEMICOLON_SEPARATOR = ":";
    private static String SLASH_SEPARATOR = "/";
    private static String QUESTION_MARK_SEPARATOR = "?";
    private static String EQUALITY_SIGN = "=";
    private static HttpHelper instance = null;

    private HttpHelper(){}

    public static HttpHelper getInstance(){
        if(instance == null){
            instance = new HttpHelper();
        }

            return instance;
    }

    public void makeGetRequest(Context context, final int pinNumber,
                               final OnResponseListener listener){
        // Instantiate the RequestQueue.
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        String url = ADDRESS + SEMICOLON_SEPARATOR + PORT + SLASH_SEPARATOR +  RasberryCommand.ACTION_GET_STATE;

        url = loadParameterToUrl(url, pinNumber);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private String loadParameterToUrl(String url, int pinNumber){
        if(pinNumber > -1){
            url = url + QUESTION_MARK_SEPARATOR + RasberryCommand.PIN_NUMBER +
                    EQUALITY_SIGN + pinNumber;
        }
        return url;
    }

    public void makePostRequestWithSingleParam(Context context, final OnResponseListener listener, final String activityType, final Map<String, String> parameters) throws Exception
    {
        // Instantiate the RequestQueue.
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        String url = ADDRESS + SEMICOLON_SEPARATOR + PORT + SLASH_SEPARATOR + activityType;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        listener.onResponse(response);
                        Log.i("RESPONSE: ", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        })
        {
            @Override
            protected Map<String, String> getParams()
            {
                return parameters;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


}
