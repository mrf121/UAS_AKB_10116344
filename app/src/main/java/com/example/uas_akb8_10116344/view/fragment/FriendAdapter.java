package com.example.uas_akb8_10116344.view.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilham.uas.DetailActivity;
import com.example.ilham.uas.R;
import com.example.ilham.uas.model.FriendModel;

import java.util.List;

//Nama  : Ilham Maulana Pratama
//NIM   : 10116335
//KLS   : IF 8
//TGL   : 3 Agustus 2019

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {
    private List<FriendModel> friendModels;
    Context context;

    public FriendAdapter(Context context, List<FriendModel> friendModels){
        this.context = context;
        this.friendModels = friendModels;
    }

    @Override
    public FriendAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(FriendAdapter.MyViewHolder holder, int position) {
        final FriendModel model = friendModels.get(position);
        holder.nim.setText(model.getNim());
        holder.nama.setText(model.getNama());
        holder.kelas.setText(model.getKelas());
        holder.telp.setText(model.getTelp());
        holder.email.setText(model.getEmail());
        holder.sosmed.setText(model.getSosmed());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id", model.getId());
                intent.putExtra("nim", model.getNim());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("kelas", model.getKelas());
                intent.putExtra("telp", model.getTelp());
                intent.putExtra("email", model.getEmail());
                intent.putExtra("sosmed", model.getSosmed());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return friendModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, kelas, telp, email, sosmed;

        public MyViewHolder(View itemView){
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
            kelas = itemView.findViewById(R.id.tvKelas);
            telp = itemView.findViewById(R.id.tvTelp);
            email = itemView.findViewById(R.id.tvEmail);
            sosmed = itemView.findViewById(R.id.tvSosmed);
        }
    }
}

