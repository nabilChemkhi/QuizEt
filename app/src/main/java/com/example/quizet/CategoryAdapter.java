package com.example.quizet;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.LayoutInflaterFactory;

import java.util.List;
import java.util.Random;

public class CategoryAdapter extends BaseAdapter {

   /** private List<String> categoryList;

    public CategoryAdapter(List<String> categoryList) {
        this.categoryList = categoryList;
    }*/

   private List<Category> categoryList;


    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;


    }



    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout, parent, false);
        }
        else {
            view=convertView;
        }
        //onclicklistener pour acceder aux sets
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /** Intent intent = new Intent(parent.getContext(), SetsActivity.class);
                intent.putExtra("Category",categoryList.get(position));
                parent.getContext().startActivity(intent);*/

                Intent intent = new Intent(parent.getContext(), SetsActivity.class);
                intent.putExtra("Category",categoryList.get(position).getName());


                intent.putExtra("id1",categoryList.get(position).getCategoryId());

                parent.getContext().startActivity(intent);
            }
        });

        ((TextView) view.findViewById(R.id.categoryName)).setText(categoryList.get(position).getName());//categoryList.get(position));
    int i= categoryList.get(position).getCategoryId();
    switch (i) {
        case 1:

            ((ImageView) view.findViewById(R.id.miamgeview)).setImageResource(R.drawable.ball);
          break;
        case  2:
            ((ImageView) view.findViewById(R.id.miamgeview)).setImageResource(R.drawable.golf);
       break;
        case  3:
            ((ImageView) view.findViewById(R.id.miamgeview)).setImageResource(R.drawable.g);
            break;
        case  4:
            ((ImageView) view.findViewById(R.id.miamgeview)).setImageResource(R.drawable.cine);
            break;
        case  5:
            ((ImageView) view.findViewById(R.id.miamgeview)).setImageResource(R.drawable.swimmer17_41361);
            break;
        default:
    }

                //(categoryList.get(position).getImageCateg());
        /*  Random rnd=new Random();
        int color = Color.argb(255, rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
        view.setBackgroundColor(color);*/


        return view;
    }
}
