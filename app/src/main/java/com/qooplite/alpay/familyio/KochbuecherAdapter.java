package com.qooplite.alpay.familyio;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class KochbuecherAdapter extends RecyclerView.Adapter<KochbuecherAdapter.KochbuecherHolder>{

    public ArrayList<Kochbuch> data;
    public Context context;


    public KochbuecherAdapter(ArrayList<Kochbuch> data, Context context){

        this.data = data;
        this.context = context;

    }

    @NonNull
    @Override
    public KochbuecherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.kochbuchliste,    viewGroup , false);

        return new KochbuecherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KochbuecherHolder kochbuecherHolder, int i) {

        kochbuecherHolder.nameKochBuch.setText(data.get(i).getName());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class KochbuecherHolder extends RecyclerView.ViewHolder {

        TextView nameKochBuch;


        public KochbuecherHolder(@NonNull View itemView) {
            super(itemView);

            nameKochBuch = itemView.findViewById(R.id.kochbuchname);


        }
    }

}
