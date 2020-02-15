package com.example.multivistarecycler.adapters;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multivistarecycler.MainActivity;
import com.example.multivistarecycler.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GlobalAdapter extends RecyclerView.Adapter<GlobalAdapter.Holder> {


    Activity mcontext;
    ArrayList<SuperPojo> mItems = new ArrayList<>();

    public static final int

            VIEW_TYPE_HOME = 0X00,
            VIEW_TYPE_BANNER = 0X01,
            VIEW_TYPE_PLAYLIST=0X03,
            VIEW_TYPE_GENERO=0X04;
    ;

    public GlobalAdapter(Activity mcontext) { this.mcontext = mcontext;}

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
        //Sobre escribe sus hijos
    }

    public class Holder extends RecyclerView.ViewHolder {
        public Holder(@NonNull View itemView) {
            super(itemView);
        }
        //Todo sobre escrito en los hijos
    }
    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        //Todo Sobre escrito en los hijos
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class Banner extends Holder
    {
        LinearLayout linear;
        public Banner(@NonNull View itemView) {
            super(itemView);
            linear = itemView.findViewById(R.id.banner);
        }

        public void onBinBanner(JSONObject object)
        {
            String color="";

            try {
                color = object.getString("color");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            switch (color){
                case "primero":
                    linear.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));
                    break;
                case "segundo":
                    linear.setBackgroundColor(mcontext.getResources().getColor(R.color.colorAccent));
                    break;

                default: linear.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimaryDark));
            }

        }
    }

    public class Genero extends  Holder
    {
     TextView titles;
     LinearLayout primera,segunda;
        public Genero(@NonNull View itemView) {
            super(itemView);
            titles = itemView.findViewById(R.id.title);
            primera = itemView.findViewById(R.id.one);
            segunda = itemView.findViewById(R.id.two);
        }

        public void onBinGenero(String title,String color)
        {
            titles.setText(title);

            switch (color){
                case "primero":
                    segunda.setBackgroundColor(mcontext.getResources().getColor(R.color.colorAccent));
                    primera.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));
                    break;
                case "segundo":
                    primera.setBackgroundColor(mcontext.getResources().getColor(R.color.colorAccent));
                    segunda.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));
                break;

                default:
                    primera.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));
                    segunda.setBackgroundColor(mcontext.getResources().getColor(R.color.colorPrimary));
                    break;
            }
        }
    }

    public class PlayList extends  Holder{
        TextView titulo,descripcion;
        ImageView album;
        public PlayList(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.title);
            descripcion = itemView.findViewById(R.id.detail);
            album = itemView.findViewById(R.id.image);
        }
        public void onBinPlayList(int image,String title,String descripciones)
        {
            titulo.setText(title);
            descripcion.setText(descripciones);
        }
    }

    public static class SuperPojo{

        JSONObject item;
        public boolean genero,playList,banners,home;

        public SuperPojo(JSONObject item) {this.item = item;}
        public JSONObject getItem() {return item; }
        public void setItem(JSONObject item) {this.item = item; }

        public SuperPojo isGenero(){ this.genero = true; return this;}
        public SuperPojo isplaylist(){ this.playList = true; return this;}
        public SuperPojo isbanners(){ this.banners = true; return this;}
        public SuperPojo ishome(){ this.home = true; return this;}
    }
    /*    { \"skulist\": [{ \"name\": \"TELCEL $10\", \"sku\": \"001000000010A\", \"monto\": \"10\", \"service\": \"0\", \"montos\": \"10,20,30,50,80,100,150,200,300,500\", \"prioridadMonto\": \"2\", \"leyenda\": \"Celular\", \"accountRegex\": \"[0-9]{10}\", \"comision\": \"0.0000\", \"carrier\": \"TELCEL\", \"producto\": \"RECARGA\", \"info\": \"Duda o aclaración desde su Telcel llamar al *264. Mayor información sobre vigencias y promociones en &lt;a href=\"https://www.telcel.com/personas/telefonia/amigo\" target=\"_blank\" style=\"display: contents;\"&gt;https://telcel.com&lt;/a&gt;\", \"urlRecibo\": \"\" },{ \"skulist\": [{ \"name\": \"TELCEL $10\", \"sku\": \"001000000010A\", \"monto\": \"10\", \"service\": \"0\", \"montos\": \"10,20,30,50,80,100,150,200,300,500\", \"prioridadMonto\": \"2\", \"leyenda\": \"Celular\", \"accountRegex\": \"[0-9]{10}\", \"comision\": \"0.0000\", \"carrier\": \"TELCEL\", \"producto\": \"RECARGA\", \"info\": \"Duda o aclaración desde su Telcel llamar al *264. Mayor información sobre vigencias y promociones en &lt;a href=\"https://www.telcel.com/personas/telefonia/amigo\" target=\"_blank\" style=\"display: contents;\"&gt;https://telcel.com&lt;/a&gt;\", \"urlRecibo\": \"\" },
     */

}
