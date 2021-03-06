package com.ole.black.networkrequest.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ole.black.networkrequest.R;

public class MahasiswaHolder extends RecyclerView.ViewHolder {
    public TextView txt_nama;
    public TextView txt_nim;
    public Button btnDelete;
    public Button btnFavorite;

    public MahasiswaHolder(View itemView) {
        super(itemView);
        txt_nama = (TextView) itemView.findViewById(R.id.tnama);
        txt_nim = (TextView) itemView.findViewById(R.id.tnim);
        btnDelete=(Button)itemView.findViewById(R.id.btn_delete);
        btnFavorite=(Button)itemView.findViewById(R.id.btn_fav);
    }
}
