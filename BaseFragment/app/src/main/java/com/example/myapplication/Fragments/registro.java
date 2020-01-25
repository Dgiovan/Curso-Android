package com.example.myapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.Utils.Constants;
import com.example.myapplication.adapters.AdaptadorGeneral;
import com.example.myapplication.interfaces.OnFragmetIteractionListener;
import com.example.myapplication.interfaces.OnItemClickListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class registro extends BaseFragmentListener {

    LinearLayout Container;
    AdaptadorGeneral mAdapter;
    RecyclerView rcv;
    View a,b;

    public registro() {
        // Required empty public constructor
    }
    public static registro newInstance(OnFragmetIteractionListener onFragmetIteractionListener)
    {
        registro fragment = new registro();
        fragment.setOnFragmetIteractionListener(onFragmetIteractionListener);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        if (getArguments()!=null){
            Toast.makeText(getActivity(), "hola : " +getArguments().get(Constants.USER), Toast.LENGTH_SHORT).show();
        }
        Container = v.findViewById(R.id.container);

        publishView();
        return v;
    }

    private void publishView() {
        Container.addView(aa());
        Container.addView(bb());
    }

    private View bb() {
        if (b==null){
            b = getActivity().getLayoutInflater().inflate(R.layout.generalrcv, Container, false);
        }
        String jsondata = null;
        try {
            jsondata = readJsonDataFromFile();
            mData = new JSONObject(jsondata);

             rcv = b.findViewById(R.id.rcv);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rcv.setLayoutManager(linearLayoutManager);
            rcv.setHasFixedSize(true);

            mAdapter= new AdaptadorGeneral(getActivity(),mData);
            mAdapter.setOnItemClickListener(new OnItemClickListener() {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    private View aa() {
        if (a==null){
            a = getActivity().getLayoutInflater().inflate(R.layout.sue, Container, false);
        }
        ImageView image;
        image = a.findViewById(R.id.image);

        Glide.with(this)
                .load("https://http2.mlstatic.com/D_Q_NP_863049-MLM40001568996_122019-AB.webp")
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image);
        return a;
    }
    /**Empieza metodo para leer desde Json borrar terminando pruebas*/
    private String readJsonDataFromFile() throws IOException
    {
        /**       InputStream inputStream = null;
         StringBuilder builder = new StringBuilder();

         String jsonDataString = null;
         inputStream = getResource()*/
        //BufferedReader
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
    }
}
