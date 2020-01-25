package com.example.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorGeneral extends adapterexample {


   // public OnItemClickListener listener;
    public AdaptadorGeneral(Activity mContext,JSONObject object) {
        super(mContext);
        getTipyes(object);
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_large){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.large, parent, false);
            //        view.getLayoutParams().width = (int) (getScreenWidth()/showItems)+(int) (-50);
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


    public int getScreenWidth() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
/*    public void setOnItemClickListener(final BaseAdapter.OnItemClickListener mItemClickListener) {
        this.listener = mItemClickListener;
    }*/

/*
    @Override
    public void onClick(View v) {
        if(listener != null) {
            listener.onItemClick( v, getAdapterPosition() );
            try {
                Intent intent = new Intent(context,item.get(getAdapterPosition()).getItem().getString("t").equals("tip")? Article.class:CookBook.class)
                        .putExtra("nombre", item.get(getAdapterPosition()).getItem().getString("n") )
                        .putExtra("clave", item.get(getAdapterPosition()).getItem().getString("k") )
                        .putExtra("local", !InternetConnection.isOnline(mContex));
                intent.putExtra( Collecctions.IS_PURCHASED, false);
                KiwilimonUtils.startActivityAnimated(context, intent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}*/
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    //Para recycler in recycler
   /* public class RecipeClasificationHolder extends GridItemViewHolder
    {
        TextView description,title;
        ConstraintLayout titleForTemp;
        Recipe_Clasisification adapter;
        List<Recipe_Clasisification.itemClassificationRecipe> mItems = new ArrayList<>();
        RecyclerView rcv;
        public RecipeClasificationHolder(View view)
        {
            super(view);
            description  = view.findViewById(R.id.recipedescription);
            titleForTemp = view.findViewById(R.id.titleforTemp);
            title		 = view.findViewById(R.id.titleTemp);
            rcv 		 = view.findViewById(R.id.rcv);

        }
        public void binRecipe(Activity mContext,JSONArray objet,String description,String key,String titles) {

            if (key.equals("3119")||key.equals("3128")||key.equals("3140")||
                    key.equals("3127")||key.equals("3157")||key.equals("3160")||key.equals("3123")||
                    key.equals("3132")||key.equals("3774")||key.equals("3120")||key.equals("3125")||
                    key.equals("3150")||key.equals("3495")||key.equals("3171")||key.equals("3799")||
                    key.equals("3884")||key.equals("3913")||key.equals("3941"))
            {
                titleForTemp.setVisibility(View.VISIBLE);
                title.setText(titles);
            }
            else {titleForTemp.setVisibility(View.GONE);}
            if (description.length()<30){this.description.setVisibility(View.GONE);}else {this.description.setText(description);}

            for (int i = 0; i<objet.length();i++)
            {
                try {
                    mItems.add(new Recipe_Clasisification.itemClassificationRecipe(objet.getJSONObject(i)));
                }catch (Exception e){}
            }
            rcv.setHasFixedSize(true);
            LinearLayoutManager layoutManager= new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL, false);
            rcv.setLayoutManager(layoutManager);
            adapter = new Recipe_Clasisification(mItems,mContext);
            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    JSONObject item = mItems.get(position).getItem();

                }
            });
            rcv.setAdapter(adapter);
        }
    }*/
}
