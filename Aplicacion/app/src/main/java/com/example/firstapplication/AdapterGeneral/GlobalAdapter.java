package com.example.firstapplication.AdapterGeneral;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.firstapplication.R;

import org.json.JSONObject;

import java.util.ArrayList;

public class GlobalAdapter extends RecyclerView.Adapter<GlobalAdapter.Holder> {


    public static final int
    VIEW_TYPE_PRODUCT=0x01,
    VIEW_TYPE_CATEGORY=0x02;

    Activity context;
    public ArrayList<SuperPojo> mItems = new ArrayList<SuperPojo>();

    public GlobalAdapter(Activity context) {
        this.context = context;
    }

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

    public  class Categorys extends Holder {
        TextView title, description1,precio1, description2,precio2, description3,precio3,vermas;
        ImageView one,dos,tres;
        ConstraintLayout uno,two,three;
        public Categorys(@NonNull View v) {
            super(v);
            title        = v.findViewById(R.id.title);

            precio1      = v.findViewById(R.id.price1);
            one          = v.findViewById(R.id.image1);


            precio2      = v.findViewById(R.id.price2);
            dos          = v.findViewById(R.id.image2);

            precio3      = v.findViewById(R.id.price3);
            tres         = v.findViewById(R.id.image3);
            vermas       = v.findViewById(R.id.seeMore);

        }
        public void onbinCategorys(JSONObject object)
        {
            try {
                title.setText(object.getString("title"));
                precio1.setText(object.getString("key1"));
                Glide.with(context)
                        .load(object.getString("image1"))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(one);

                precio2.setText(object.getString("key2"));
                Glide.with(context)
                        .load(object.getString("image3"))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(dos);

                precio3.setText(object.getString("key3"));
                Glide.with(context)
                        .load(object.getString("image3"))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(tres);

            }catch (Exception e){
                Log.e("Catch",e.toString());}
        }
    }

    public class Product extends Holder{
        TextView mtitle,sale,oferta;
        ImageView mimage;
        public Product(@NonNull View v) {
            super(v);
            mtitle=  v.findViewById(R.id.title);
            mimage =  v.findViewById(R.id.image);
            sale  =  v.findViewById(R.id.sale) ;
            oferta=  v.findViewById(R.id.ofert);
        }

    public void onBinProduct(String title,String image,double price,double ofert)
    {
        mtitle.setText(title);
        if (ofert!=price){
            sale.setPaintFlags(sale.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        sale.setText(String.valueOf(price));
        oferta.setText(String.valueOf(ofert));

        Glide.with(context)
                .load(image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mimage);

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
