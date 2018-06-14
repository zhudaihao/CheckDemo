package com.example.recyclerview_check;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HorizontalAdapter_new horizontalAdapter;
    private int positions = -1;//设置初始化选中的item
    private List<User> mList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        horizontalAdapter = new HorizontalAdapter_new(mList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(horizontalAdapter);


        initData();
        horizontalAdapter.setOnItemClickListener(new HorizontalAdapter_new.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position != -1) {
                    //刷新数据
                    horizontalAdapter.setList(mList, position);
                    Log.e("AGT","---------------");
                }
            }
        });



    }



    //数据
    int position =-1;
    private void initData() {
        for (int i = 0; i < 100; i++) {
            mList.add(new User("第一" + i + "中学"));
        }
        horizontalAdapter.setList(mList,position);

    }
}
