package com.example.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.interfaces.OnItemClickListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class adapterexample extends RecyclerView.Adapter<adapterexample.Holder> {

    public static final int
            VIEW_TYPE_large = 0X00,
            VIEW_TYPE_card   =0X02
                    ;

    Context context;
    public ArrayList<itemContent> mItems = new ArrayList<itemContent>();
    public OnItemClickListener listener;
    /**
     * Contexto a utilizar
     */
    protected final Activity mContext;

    public adapterexample(Activity mContext) {
        this.mContext = mContext;
    }


    @Override
    public int getItemViewType(int position) {

        return mItems.get(position).tipo1 ? VIEW_TYPE_large : VIEW_TYPE_card;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //todo se sobre esribe
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        //todo se sobre esribe
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Holder extends RecyclerView.ViewHolder
    {
        public Holder(View view) {
            super(view);
            //todo se sobre esribe
        }

    }
public class Large extends  Holder {
        ImageView image;
        TextView  text;
    public Large(View v) {
        super(v);
        image = v.findViewById(R.id.image);
        text = v.findViewById(R.id.text);
    }
public void onBinLarge(JSONObject object){
    try {

        text.setText(object.getString("title"));
    } catch (JSONException e) {
        e.printStackTrace();
    }
}
}

public class Card extends Holder implements View.OnClickListener {
    ImageView image;
    TextView  text;
    public Card(View v) {
        super(v);
        image = v.findViewById(R.id.image);
        text = v.findViewById(R.id.text);
        v.setOnClickListener(this);
    }
    public void onBinCard(JSONObject object){
        try {

            text.setText(object.getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        if(listener != null) {
            listener.onItemClick( view, getAdapterPosition() );
        }
    }
}
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.listener = mItemClickListener;
    }



    public static class itemContent{

        JSONObject item;
        public boolean tipo1,tipo2;

        public JSONObject getItem() {return item;}
        public void setItem(JSONObject item) {this.item = item;}

        public  itemContent(JSONObject item) {
            this.item = item;
        }

        public itemContent tipo1() { this.tipo1 = true; return this; }
        public itemContent tipo2  () { this.tipo2   = true; return this; }


    }
}
