package com.example.recyclerview_seclected;


import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * Created by Administrator on 2017/8/22.
 */

public class MyAdapter extends BaseQuickAdapter<UserBean, BaseViewHolder> {

    private List<UserBean> mList;

    public MyAdapter(List<UserBean> mList) {
        super(R.layout.item_layout, mList);
        this.mList = mList;
    }

    //标记当前点击的item
    private int positions;

    //重点 设置数据时把点击那里item获取
    public void setList(List<UserBean> mList, int positions) {
        this.mList = mList;
        this.positions = positions;
        notifyDataSetChanged();

    }


    @Override
    protected void convert(BaseViewHolder helper, UserBean item) {
        TextView tvId = helper.itemView.findViewById(R.id.item_horizontaltext);
        tvId.setText(item.getName() + "");

        //点击的item和对应所有数据对应item一致就设置状态
        if (positions == helper.getPosition()) {
            tvId.setSelected(true);
        } else {
            tvId.setSelected(false);
        }

    }


}
