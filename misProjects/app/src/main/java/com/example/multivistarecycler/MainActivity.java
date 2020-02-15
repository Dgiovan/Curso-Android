package com.example.multivistarecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.multivistarecycler.adapters.adpterViews;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    adpterViews mAdapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);




            String jsondata = null;
            try {
                jsondata = readJsonDataFromFile();
                JSONObject mData = new JSONObject(jsondata);
                rcv = findViewById(R.id.rcv);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rcv.setLayoutManager(linearLayoutManager);
                rcv.setHasFixedSize(true);

                mAdapter= new AdaptadorGeneral(getActivity(),mData);
                mAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        JSONObject item = mAdapter.mItems.get(position).getItem();
                        Log.e("AAA",item.toString());
                    }
                });
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rcv.setAdapter(mAdapter);

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
        }

/*Empieza metodo para leer desde Json borrar terminando pruebas*/
            private String readJsonDataFromFile() throws IOException{

                Log.e("ENTRE","si");
                InputStream inputStream = null;
                StringBuilder builder = new StringBuilder();

                try {
                    String jsonDataString = null;
                    inputStream = getResources().openRawResource(R.raw.ejemplo);
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(inputStream, "UTF-8"));
                    while ((jsonDataString = bufferedReader.readLine()) != null) {
                        builder.append(jsonDataString);
                    }
                } finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                Log.e("ENTRE",builder.toString());
                return new String(builder);
            }}
}
