package com.example.quizet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import androidx.appcompat.widget.Toolbar;

public class SetsActivity extends AppCompatActivity {

    //widgets
    private GridView setsGrid;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        //binding
        toolbar = findViewById(R.id.set_toolbar);
        setsGrid = findViewById(R.id.sets_gridView);
        //toolbar
        setSupportActionBar(toolbar);
        String title=getIntent().getStringExtra("Category");
        getSupportActionBar().setTitle(title);

        //return button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        SetAdapter adapter = new SetAdapter(6);
        setsGrid.setAdapter(adapter);


    }
    //handling the button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            SetsActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}