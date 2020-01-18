package com.example.firstapplication.AdapterGeneral;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.util.ArrayList;

public class GlobalAdapter extends RecyclerView.Adapter<GlobalAdapter.Holder> {


    public static final int
    VIEW_TYPE_PRODUCT=0x01,
    VIEW_TYPE_CATEGORY=0x02;

    public ArrayList<SuperPojo> mItems = new ArrayList<SuperPojo>();

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).cardProduc? VIEW_TYPE_PRODUCT: VIEW_TYPE_CATEGORY;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
        //Todo sobre escrito de sus hijos
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    public  class Products extends Holder {
        public Products(@NonNull View itemView) {
            super(itemView);
        }
        public void onbinProducts(JSONObject object){

        }
    }
    public  class Categorys extends Holder {
        public Categorys(@NonNull View itemView) {
            super(itemView);
        }
        public void onbinCategorys(JSONObject object){

        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
            //Todo sobre escrito de sus hijos

        }
    }

    public static class SuperPojo{

        JSONObject item;

        public boolean cardCategory,cardProduc=false;

        public JSONObject getItem() {return item;}
        public void setItem(JSONObject item) { this.item = item;}

        public SuperPojo(JSONObject item) {this.item = item;}

        public SuperPojo category(){ this.cardCategory = true; return this;}
        public SuperPojo product (){ this.cardProduc   = true; return this;}
    }
}
