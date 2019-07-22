package com.sajjad.recyclerview.PersonPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.sajjad.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private Context context;
    private List<PersonModel> personModels;
    private List<PersonModel> baseResouce;

    public PersonRecyclerAdapter(Context context, List<PersonModel> personModels) {
        this.context = context;
        this.personModels = personModels;
        baseResouce=personModels;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View personView= LayoutInflater.from(context).inflate(R.layout.person_item,parent,false);
        return new PersonViewHolder(personView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, final int position) {
        holder.id.setText(String.valueOf(personModels.get(position).getId()));
        holder.age.setText(String.valueOf(personModels.get(position).getAge()));
        holder.fullName.setText(personModels.get(position).getFullName());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"I am from button "+position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return personModels.size();
    }

    public void searchPerson(String newText) {
        personModels = new ArrayList<>();
        if (newText.isEmpty()) {
            personModels = baseResouce;
        } else {
            for (PersonModel person : baseResouce) {
                if (person.getFullName().toLowerCase().trim().contains(newText.toLowerCase().trim())) {
                    personModels.add(person);
                }
            }
        }
        notifyDataSetChanged();
    }


    private void removePerson(int position){
        personModels.remove(position);
        notifyDataSetChanged();
    }

    public ItemTouchHelper.SimpleCallback swipeToDelete=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            removePerson(viewHolder.getAdapterPosition());
        }
    };
}