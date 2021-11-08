package com.example.quizet;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SetAdapter extends BaseAdapter {

    private  int nbrOfSets;

    public SetAdapter(int nbrOfSets) {
        this.nbrOfSets = nbrOfSets;
    }

    @Override
    public int getCount() {
        return nbrOfSets;
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
        if(convertView==null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sets_item_layout,parent,false);
        }
        else {
            view=convertView;
        }

        //on click listener to get question view
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(),QuestionsActivity.class);
                parent.getContext().startActivity(intent);
            }
        });

            ((TextView) view.findViewById(R.id.setNo_tv)).setText(String.valueOf(position + 1));

        return view;
    }
}
