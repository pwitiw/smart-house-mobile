package com.example.mkrzywan.teleinformatyka;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by MKRZYWAN on 20.03.2016.
 */
public class HttpHelper {

    public static void makeRequest(Context context, String rasberryCommand) throws Exception
    {
        // Instantiate the RequestQueue.
        com.android.volley.RequestQueue queue = Volley.newRequestQueue(context);
        String url ="192.168.0.100";

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
}
