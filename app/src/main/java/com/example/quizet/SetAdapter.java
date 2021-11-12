package com.example.quizet;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SetAdapter extends BaseAdapter {

    // private  int nbrOfSets;
    private List<Set> setList;

    /**public SetAdapter(int nbrOfSets) {
     this.nbrOfSets = nbrOfSets;
     }**/

    public SetAdapter(List<Set> setList) {
        this.setList = setList;
    }


    @Override
    public int getCount() {
        // return nbrOfSets;
        return  setList.size();
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
           /**  @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(),QuestionsActivity.class);
                parent.getContext().startActivity(intent);
            }*/

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(parent.getContext(),QuestionsActivity.class);

            intent.putExtra("ids",setList.get(position).getSetId());
            intent.putExtra("bscore",setList.get(position).getBestScore());

            parent.getContext().startActivity(intent);
        }



        });
        int bst = setList.get(position).getBestScore();


            ((TextView) view.findViewById(R.id.setNo_tv)).setText(String.valueOf(position + 1));
        ((TextView) view.findViewById(R.id.bestScore)).setText("best score:"+ String.valueOf(bst));

        return view;
    }
}
