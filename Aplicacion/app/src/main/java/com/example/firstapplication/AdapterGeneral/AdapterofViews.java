package com.example.firstapplication.AdapterGeneral;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.firstapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdapterofViews extends GlobalAdapter {


    public AdapterofViews(Activity context,JSONObject object) {
        super(context);
        getTypes(object);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // return super.onCreateViewHolder(parent, viewType);
        View view;
        if (viewType == VIEW_TYPE_PRODUCT){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product,parent,false);
            return new Product(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clasification,parent,false);        }
        return  new Categorys(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        //super.onBindViewHolder(holder, position);
        final SuperPojo item = mItems.get(position);
        if (holder.getItemViewType() == VIEW_TYPE_PRODUCT)
        {
            final Product product = (Product) holder;

            try {
                product.onBinProduct(item.getItem().getString("title"),
                        item.getItem().getString("image"),
                        item.getItem().getDouble("sale"),
                        item.getItem().getDouble("ofert"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }else {
            final Categorys category = (Categorys) holder;
            category.onbinCategorys(item.getItem());
        }

    }

    private void getTypes(JSONObject objet) {

        try {
            JSONArray body = objet.getJSONArray("payload");
            for(int i= 0; i<body.length();i++ )
            {
                if (body.getJSONObject(i).getString("t").equals("product")){
                    mItems.add(new SuperPojo(body.getJSONObject(i)).product());
                }else if (body.getJSONObject(i).getString("t").equals("category")){
                    mItems.add(new SuperPojo(body.getJSONObject(i)).category());
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
