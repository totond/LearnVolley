package scut.learnvolley;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.lang.reflect.Method;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(MainActivity.this);
        findViewById(R.id.btnGetSting).setOnClickListener(this);
        findViewById(R.id.btnGetJSon).setOnClickListener(this);

    }
    public void stringRequestGet(){
        StringRequest stringRequest = new StringRequest("http://fanyi.youdao.com/openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=good", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                System.out.println("成功连接："+s);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("连接失败"+volleyError);

            }
        });
        mQueue.add(stringRequest);

    }
    public void jsonRequestGet(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://fanyi.youdao.com/openapi.do?keyfrom=Yanzhikai&key=2032414398&type=data&doctype=json&version=1.1&q=car", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                System.out.println("连接成功："+jsonObject.toString());
                Gson gson = new Gson();
                fanyi fy = gson.fromJson(jsonObject.toString(),fanyi.class);
                fy.show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("连接失败："+volleyError);

            }
        });
        mQueue.add(jsonObjectRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGetSting:
                System.out.println("连接中...");
                stringRequestGet();
                break;
            case R.id.btnGetJSon:
                System.out.println("连接中...");
                jsonRequestGet();
                break;
        }
    }
}
