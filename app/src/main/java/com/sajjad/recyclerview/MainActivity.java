package com.sajjad.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sajjad.recyclerview.PersonPackage.ItemModel;
import com.sajjad.recyclerview.PersonPackage.ItemRecyclerViewAdapter;
import com.sajjad.recyclerview.PersonPackage.PersonModel;
import com.sajjad.recyclerview.PersonPackage.PersonRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;
    PersonRecyclerAdapter personRecyclerAdapter;
    List<PersonModel>personModels;
    RecyclerView personRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    //

    ItemRecyclerViewAdapter itemRecyclerViewAdapter;
    List<ItemModel> itemModels;
    RecyclerView itemRecyclerView;
    RecyclerView.LayoutManager horizontalLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar=findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);

        personRecyclerView=findViewById(R.id.personRecyclerView);
        itemRecyclerView=findViewById(R.id.horizontalRecyclerView);

        layoutManager=new LinearLayoutManager(this);
        personRecyclerView.setLayoutManager(layoutManager);
    }

    public void showRecyclerView(View view) {
        fillData();
        personRecyclerAdapter =new PersonRecyclerAdapter(this,personModels);
        personRecyclerView.setAdapter(personRecyclerAdapter);

        new ItemTouchHelper(personRecyclerAdapter.swipeToDelete).attachToRecyclerView(personRecyclerView);
    }

    private void fillData() {
        personModels=new ArrayList<>();
        personModels.add(new PersonModel(1,20,"Ahmed"));
        personModels.add(new PersonModel(2,22,"Mohammed"));
        personModels.add(new PersonModel(3,23,"Aya"));
        personModels.add(new PersonModel(4,24,"Suha"));
        personModels.add(new PersonModel(5,25,"Adnan"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        MenuItem searchItem=menu.findItem(R.id.searchItem);

        SearchView searchView= (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                personRecyclerAdapter.searchPerson(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void showHorizontalRecyclerView(View view) {
        horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        itemRecyclerView.setLayoutManager(horizontalLayoutManager);


        fillHorizontalData();
        itemRecyclerViewAdapter = new ItemRecyclerViewAdapter(itemModels );
        itemRecyclerView.setAdapter(itemRecyclerViewAdapter);
    }

    private void fillHorizontalData() {
        itemModels=new ArrayList<>();
        itemModels.add(new ItemModel("Sajjad"));
        itemModels.add(new ItemModel("Ahmed"));
        itemModels.add(new ItemModel("Suha"));
        itemModels.add(new ItemModel("Qassim"));
        itemModels.add(new ItemModel("Ayman"));
        itemModels.add(new ItemModel("Ayman"));
        itemModels.add(new ItemModel("Ayman"));
        itemModels.add(new ItemModel("Ayman"));
        itemModels.add(new ItemModel("Ayman"));
        itemModels.add(new ItemModel("Ayman"));
        itemModels.add(new ItemModel("Ayman"));
    }
}
