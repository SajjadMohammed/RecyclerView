package com.sajjad.recyclerview.PersonPackage;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sajjad.recyclerview.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView item;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        item=itemView.findViewById(R.id.item);
    }
}
