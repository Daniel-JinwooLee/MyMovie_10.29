package com.example.mymovie_1029;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private ArrayList<Dictionary> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView userID;
        protected TextView comment;

        public CustomViewHolder(View view) {
            super(view);
            this.userID = (TextView) view.findViewById(R.id.userid_text);
            this.comment = (TextView) view.findViewById(R.id.comment_text);
        }
    }

    public CustomAdapter(ArrayList<Dictionary> list) {
        this.mList = list;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.comment_item, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {



//        viewholder.userID.setGravity(Gravity.CENTER);
//        viewholder.comment.setGravity(Gravity.CENTER);


        viewholder.userID.setText(mList.get(position).getUserID());
        viewholder.comment.setText(mList.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
