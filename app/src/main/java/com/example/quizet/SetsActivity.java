package com.example.quizet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class SetsActivity extends AppCompatActivity {

    //widgets
    private GridView setsGrid;
    private Toolbar toolbar;

    private  AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        //binding
        toolbar = findViewById(R.id.set_toolbar);
        setsGrid = findViewById(R.id.sets_gridView);
        //toolbar
        setSupportActionBar(toolbar);
        //get categoryname from intent
        String title=getIntent().getStringExtra("Category");
        getSupportActionBar().setTitle(title);

        //return button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appDatabase = AppDatabase.getAppDatabase(this);

        int  id1=getIntent().getIntExtra("id1",1);
        List<SetsFromCategory> scl=  appDatabase.setsFromCategoryDAO().getSetsFromCategory(id1);
        List<Set> xset= scl.get(0).sets;
        //
        // int x=xset.size();

        //SetAdapter adapter = new SetAdapter(6);
        SetAdapter adapter = new SetAdapter(xset);
        setsGrid.setAdapter(adapter);



    }
    //handling the return button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            SetsActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}