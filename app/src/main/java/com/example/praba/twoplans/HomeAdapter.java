package com.example.praba.twoplans;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private static final String TAG = "HomeAdapter";

    String nama [] = {"Gunung","Pantai","Pura","Desa Wisata"};
    int gambar [] = {R.drawable.gunungagung,
            R.drawable.pantaisanur,
            R.drawable.purauluwatu,
            R.drawable.desa_wisata_penglipuran};

    Context mContext;
    LayoutInflater layoutInflater;

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txt.setText(nama[position]);
        holder.img.setImageResource(gambar[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nama[position]=="Gunung"){
                    Intent kirimData = new Intent(mContext, GunungActivity.class);
                    kirimData.putExtra("Nama", nama[position]);
                    kirimData.putExtra("img", gambar[position]);
                    mContext.startActivity(kirimData);
                } else if(nama[position]=="Pantai"){
                    Intent kirimData = new Intent(mContext, PantaiActivity.class);
                    kirimData.putExtra("Nama", nama[position]);
                    kirimData.putExtra("img", gambar[position]);
                    mContext.startActivity(kirimData);
                } else if (nama[position]=="Pura"){
                    Intent kirimData = new Intent(mContext, PuraActivity.class);
                    kirimData.putExtra("Nama", nama[position]);
                    kirimData.putExtra("img", gambar[position]);
                    mContext.startActivity(kirimData);
                } else if (nama[position]=="Desa Wisata"){
                    Intent kirimData = new Intent(mContext, DesaActivity.class);
                    kirimData.putExtra("Nama", nama[position]);
                    kirimData.putExtra("img", gambar[position]);
                    mContext.startActivity(kirimData);
                }

        }
        });

    }

    @Override
    public int getItemCount() {
        return nama.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imgView);
            txt = (TextView) itemView.findViewById(R.id.txtView);
        }
    }
}

