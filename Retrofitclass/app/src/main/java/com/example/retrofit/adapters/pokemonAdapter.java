package com.example.retrofit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.Interfaces.ItemOnClickListener;
import com.example.retrofit.Models.pokemon;
import com.example.retrofit.R;

import java.util.ArrayList;

public class pokemonAdapter extends RecyclerView.Adapter<pokemonAdapter.VH> {

    private ArrayList<pokemon> data;
    private Context context;
    public ItemOnClickListener listener;
    public pokemonAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();

    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itempokemon,parent,false);
        return new VH(view);
    }

    public class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        public VH(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.Pokemonname);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener!=null){
                listener.ItenOnclicListener(view,getAdapterPosition());
            }
        }
    }

    public ArrayList<pokemon> getData() {
        return data;
    }

    public void setData(ArrayList<pokemon> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        pokemon p = data.get(position);
        holder.name.setText(p.getName());
    }

    public void  addListPokemon(ArrayList<pokemon> listpokemon){
        data.addAll(listpokemon);
        notifyDataSetChanged();
    }

    public void setOnitemClickListener(ItemOnClickListener itemOnClickListener){
        this.listener = itemOnClickListener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
