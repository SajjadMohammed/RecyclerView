package com.sajjad.recyclerview.PersonPackage;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sajjad.recyclerview.R;

class PersonViewHolder extends RecyclerView.ViewHolder {

    TextView id, age, fullName;
    public Button remove;

    PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.personId);
        age = itemView.findViewById(R.id.peronAge);
        fullName = itemView.findViewById(R.id.personName);
        remove = itemView.findViewById(R.id.removePerson);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), fullName.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}