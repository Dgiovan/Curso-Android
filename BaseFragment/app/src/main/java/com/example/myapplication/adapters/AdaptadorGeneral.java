package com.example.myapplication.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdaptadorGeneral extends adapterexample {


    public AdaptadorGeneral(Activity mContext,JSONObject object) {
        super(mContext);
        getTipyes(object);
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_large){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.large, parent, false);
            return new Large(view);
        }else
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
            return new Card(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position ) {
    final itemContent item = mItems.get(position);
        if (holder.getItemViewType() == VIEW_TYPE_large){
            final Large viewLarge = (Large)holder;
            viewLarge.onBinLarge(item.getItem());
        }else {
            final Card viewCard = (Card)holder;
            viewCard.onBinCard(item.getItem());
        }
    }
    public void getTipyes(JSONObject objets){

        try {
            JSONArray body= objets.getJSONArray("body");

            for (int i = 0;i<body.length();i++){
                if (body.getJSONObject(i).getString("t").equals("one")){
                    mItems.add(new itemContent(body.getJSONObject(i)).tipo1());
                }
                if (body.getJSONObject(i).getString("t").equals("two")){
                    mItems.add(new itemContent(body.getJSONObject(i)).tipo2());
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
