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

    private static String ADDRESS = "http://192.168.0.101";
    private static String PORT = "5000";
    private static String SEMICOLON_SEPARATOR = ":";
    private static String SLASH_SEPARATOR = "/";
    public static String STATE_CHANGE = "stateChange";
    public static String GET_STATE = "getState";

    public static void makeGetRequest(Context context, String[] parameters){
        // Instantiate the RequestQueue.
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        String url = ADDRESS + SEMICOLON_SEPARATOR + PORT + SLASH_SEPARATOR;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("RESPONSE: ", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public static void makePostRequestWithSingleParam(Context context, final String key, final String value) throws Exception
    {
        // Instantiate the RequestQueue.
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        String url = ADDRESS + SEMICOLON_SEPARATOR + PORT + SLASH_SEPARATOR;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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
                Map<String, String>  params = new HashMap<String, String>();
                params.put(key, value);

                return params;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }


}
