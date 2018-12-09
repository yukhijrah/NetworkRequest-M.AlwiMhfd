package com.ole.black.networkrequest.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ole.black.networkrequest.R;

public class MahasiswaHolder extends RecyclerView.ViewHolder {
    public TextView txt_nama;
    public TextView txt_nim;

    public MahasiswaHolder(View itemView) {
        super(itemView);
        txt_nama = (TextView) itemView.findViewById(R.id.tnama);
        txt_nim = (TextView) itemView.findViewById(R.id.tnim);
    }
}
