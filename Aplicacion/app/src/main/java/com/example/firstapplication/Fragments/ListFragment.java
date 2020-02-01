package com.example.firstapplication.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstapplication.AdapterGeneral.AdapterofViews;
import com.example.firstapplication.AdapterGeneral.GlobalAdapter;
import com.example.firstapplication.Interfaces.OnFragmentIteractionListener;
import com.example.firstapplication.R;
import com.example.firstapplication.Utils.RecyclerItemTouchHelper;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends BaseFragmentListener implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {
    private static final String TAG = ListFragment.class.getName();
View view;
RecyclerView rcv;
AdapterofViews mAdapter;
    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance(OnFragmentIteractionListener onFragmentIteractionListener){
        ListFragment fragment = new ListFragment();
        fragment.setOnFragmentIteractionListener(onFragmentIteractionListener);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        String mydata = null;
        try {
            mydata = readJsonDataFromFile();
            JSONObject objet = new JSONObject(mydata);
            rcv  = view.findViewById(R.id.rcv);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            rcv.setLayoutManager(linearLayoutManager);
            rcv.setHasFixedSize(true);
            mAdapter = new AdapterofViews(getActivity(),objet);
            try {
                ItemTouchHelper.SimpleCallback simpleCallback = new RecyclerItemTouchHelper(0,ItemTouchHelper.LEFT,this);
                new ItemTouchHelper(simpleCallback).attachToRecyclerView(rcv);
            }catch (Exception e){}


            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    rcv.setAdapter(mAdapter);
                }
            });





        }catch (Exception e){ }

        return view;
    }

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
            inputStream = getResources().openRawResource(R.raw.mercadolibre);
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


    @Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int direction, int position) {

        mAdapter.removeItem(viewHolder.getAdapterPosition());
    }
}
