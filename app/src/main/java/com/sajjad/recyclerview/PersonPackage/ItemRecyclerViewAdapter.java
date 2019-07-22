package com.sajjad.recyclerview.PersonPackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sajjad.recyclerview.R;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<ItemModel> itemModels;

    public ItemRecyclerViewAdapter(List<ItemModel> itemModels) {
        this.itemModels = itemModels;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item,parent,false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.item.setText(itemModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }
}
