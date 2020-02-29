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
import android.widget.Toast;

import com.example.firstapplication.AdapterGeneral.AdapterofViews;
import com.example.firstapplication.Interfaces.ItemOnClickListener;
import com.example.firstapplication.Interfaces.OnFragmentIteractionListener;
import com.example.firstapplication.R;
import com.example.firstapplication.Utils.RecyclerItemTouchHelper;

import org.json.JSONException;
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
                ItemTouchHelper.SimpleCallback simpleCallback = new RecyclerItemTouchHelper(0,ItemTouchHelper.RIGHT,this);
                new ItemTouchHelper(simpleCallback).attachToRecyclerView(rcv);
            }catch (Exception e){}

           mAdapter.setOnIItemClickLister(new ItemOnClickListener() {
               @Override
               public void ItemOnclick(View view, int position) {
                   JSONObject item = mAdapter.mItems.get(position).getItem();
                   Log.e("QUEHAY",item.toString());
                   if (item.has("detail"))
                   {
                       try {
                           ShowMessage("detalle de producto",item.getString("detail"),"comprar","ver mas productos",R.drawable.ic_advertencia);
                       } catch (JSONException e) {
                         Log.e("que",e.toString());
                       }

                   }

                   try {
                       if (item.getString("t").equals("product"))
                       {
                           Toast.makeText(getContext(), item.getString("title"), Toast.LENGTH_SHORT).show();

                       }else {
                           if (item.getString("t").equals("category")){
                               switch (view.getId())
                               {
                                   case R.id.image3 :
                                       Toast.makeText(getContext(), "clic en esta imagen", Toast.LENGTH_SHORT).show();
                                       break;
                                   case R.id.seeMore:
                                       Toast.makeText(getContext(), "clic en ver mas", Toast.LENGTH_SHORT).show();

                                       break;

                               }
                           }
                       }
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }


               }
           });

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

    }


    /*@Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder, int direction, int position) {

        mAdapter.removeItem(viewHolder.getAdapterPosition());
    }*/
}
