package com.ywzheng.znote.http;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by yongwei on 2016/9/7.
 */

public class Note {

    /**
     * Volley Get请求
     */
    public void VolleyHttp(final Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
//                gson.fromJson(response, ItemObject.class);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Maaf, terjadi kesalahan.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(stringRequest);
    }


}
