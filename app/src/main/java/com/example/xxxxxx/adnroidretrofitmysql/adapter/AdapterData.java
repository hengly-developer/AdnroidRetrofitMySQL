package com.example.xxxxxx.adnroidretrofitmysql.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xxxxxx.adnroidretrofitmysql.MainActivity;
import com.example.xxxxxx.adnroidretrofitmysql.R;
import com.example.xxxxxx.adnroidretrofitmysql.model.DataModel;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private List<DataModel> mList;
    private Context ctx;

    public AdapterData(List<DataModel> mList, Context ctx) {
        this.mList = mList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        HolderData holder = new HolderData(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel model = mList.get(position);
        holder.npm.setText(model.getNpm());
        holder.nama.setText(model.getNama());
        holder.prodi.setText(model.getProdi());
        holder.fakeultas.setText(model.getFakeultas());
        holder.models=model;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{

        TextView npm,nama,prodi,fakeultas;
        DataModel models;
        public HolderData(View itemView) {
            super(itemView);

            npm = itemView.findViewById(R.id.tvNpm);
            nama = itemView.findViewById(R.id.tvnama);
            prodi = itemView.findViewById(R.id.tvprodi);
            fakeultas = itemView.findViewById(R.id.tvfakeultas);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent input = new Intent(ctx, MainActivity.class);
                    input.putExtra("npm",models.getNpm());
                    input.putExtra("nama",models.getNama());
                    input.putExtra("prodi",models.getProdi());
                    input.putExtra("fakeultas",models.getFakeultas());

                    ctx.startActivity(input);
                }
            });
        }
    }
}
