package com.example.recyclerview_seclected;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycleView;
    private MyAdapter myAdapter;
    private List<UserBean> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        recycleView.setHasFixedSize(true);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 1);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(mList);

        //动画重复
        //myAdapter.isFirstOnly(false);
        //设置那种动画
        myAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);

        recycleView.setAdapter(myAdapter);


      myAdapter.setOnItemListener(new MyAdapter.OnItemListener() {
          @Override
          public void onItemClick(int position) {
             myAdapter.notifyItemChanged(position);
          }
      });

        initData();



    }





    //数据


    private void initData() {
        for (int i = 0; i < 100; i++) {
            UserBean userBean = new UserBean("第" + i + "中学");
            mList.add(userBean);
        }
        myAdapter.setList(mList);
    }


}
