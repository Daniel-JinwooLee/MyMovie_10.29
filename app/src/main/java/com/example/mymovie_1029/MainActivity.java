package com.example.mymovie_1029;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private boolean upClicked=false;
    private boolean downClicked=false;
    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;
    private int count = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button thumbs_up_button = findViewById(R.id.thumbs_up);
        final Button thumbs_down_button = findViewById(R.id.thumbs_down);
        final TextView like_number_text = findViewById(R.id.like_number_text);
        final TextView dislike_number_text = findViewById(R.id.dislike_number_text);
        final int like_number = R.string.like_number_string;
        final int like_number_plus = R.string.like_number_plus;
        final int dislike_number = R.string.dislike_number_string;
        final int dislike_number_plus = R.string.dislike_number_plus;

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        // Data Sample
        Dictionary data1 = new Dictionary("jwl**","너무 꿀잼이에요~");
        mArrayList.add(data1);
        Dictionary data2 = new Dictionary("pri**","ㅇㅈㅇㅈ!");
        mArrayList.add(data2);






        // 좋아요 버튼
        thumbs_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!upClicked) {
                    upClicked = true;
                    if (downClicked) {
                        downClicked = false;
                        dislike_number_text.setText(dislike_number);
                    }
                    like_number_text.setText(like_number_plus);
                }//click 되지 않았다면
                else{
                    upClicked = false;
                    like_number_text.setText(like_number);
                }//click 되어 있다면
                changeButton(upClicked,downClicked);
            }
        });

        thumbs_down_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!downClicked) {
                    downClicked = true;
                    if (upClicked) {
                        upClicked = false;
                        like_number_text.setText(like_number);
                    }
                    dislike_number_text.setText(dislike_number_plus);
                }//click 되지 않았다면
                else{
                    downClicked = false;
                    dislike_number_text.setText(dislike_number);
                }//click 되어 있다면
                changeButton(upClicked,downClicked);
            }
        });
        // --좋아요 버튼

    }

    public void changeButton(boolean upClicked, boolean downClicked){
        Button thumbs_up_button = findViewById(R.id.thumbs_up);
        Button thumbs_down_button = findViewById(R.id.thumbs_down);
        if(upClicked){
            thumbs_up_button.setBackgroundResource(R.drawable.ic_thumb_up_selected);
        }
        else{
            thumbs_up_button.setBackgroundResource(R.drawable.ic_thumb_up);
        }

        if(downClicked){
            thumbs_down_button.setBackgroundResource(R.drawable.ic_thumb_down_selected);
        }
        else{
            thumbs_down_button.setBackgroundResource(R.drawable.ic_thumb_down);
        }
    };

}