package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    TextView txtSaludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnEjecutar(View view){
        txtSaludo = (TextView)findViewById(R.id.textView);
        Map<String, String> datos = new HashMap<String, String>();
        /* http://api.androidhive.info/contacts/ */
        /* http://www.geognos.com/api/en/countries/info/all.json*/
        WebService ws= new WebService("https://api.androidhive.info/contacts/", datos, this, this);
        ws.execute("");
    }

    public void processFinish(String result) throws JSONException {
        Log.i("processFinish", result);
        txtSaludo.setText(result);
    }
}