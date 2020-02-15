package com.example.multivistarecycler.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.multivistarecycler.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class adpterViews extends GlobalAdapter {

    public adpterViews(Activity mcontext) {
        super(mcontext);
    }

    public adpterViews(Activity mcontext, JSONObject objet) {
        super(mcontext);
        getTypes(objet);
    }
/**
 *Todo En caso de ser un arreglo sin nombre
 * @param objet en lugar de ser de Tipo JSONobjet seria un JSONArray
 * ejemplo (JSONArray objet)*/

    private void getTypes(JSONObject objet) {
        try {
            /**Todo se deberia hacer una comprobacion de que venga contenido en el
             *@param array sea mayor que sero el try catch se encargara de los objetos nulos
             */

            JSONArray array = objet.getJSONArray("body");

            for (int i=0; i<array.length();i++){
                if (array.getJSONObject(i).getString("t").equals("playlist"))
                {
                    mItems.add(new SuperPojo(array.getJSONObject(i)).isplaylist());
                }else if (array.getJSONObject(i).getString("t").equals("banner")||array.getJSONObject(i).has("idpublisher") )
                {
                    mItems.add(new SuperPojo(array.getJSONObject(i)).isbanners());
                }else if (array.getJSONObject(i).getString("t").equals("genero"))
                {
                    mItems.add(new SuperPojo(array.getJSONObject(i)).isGenero());
                }

            }
        }catch (Exception e){}
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_BANNER)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner,parent,false);
            return new Banner(view);
        }else if (viewType == VIEW_TYPE_GENERO)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genero,parent,false);
            return new Genero(view);
        }else
            {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlis,parent,false);
            return new PlayList(view);
            }

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        super.onBindViewHolder(holder, position);
    }
}
