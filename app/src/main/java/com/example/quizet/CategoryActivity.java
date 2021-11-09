package com.example.quizet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    //widgets
    private GridView catGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
   //binding
        Toolbar toolbar=findViewById(R.id.toolBarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        catGridView = findViewById(R.id.categoryGridViewId);

        List<String> categoryList=new ArrayList<>();
        categoryList.add("Cat 1");
        categoryList.add("Cat 2");
        categoryList.add("Cat 3");
        categoryList.add("Cat 4");
        categoryList.add("Cat 5");
        categoryList.add("Cat 6");
        categoryList.add("Cat 7");
        categoryList.add("Cat 8");
        categoryList.add("Cat 9");
        categoryList.add("Cat 10");
        categoryList.add("Cat 11");
        categoryList.add("Cat 12");

        CategoryAdapter adapter=new CategoryAdapter(categoryList);
        catGridView.setAdapter(adapter);

    }
    //return home click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            CategoryActivity.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}