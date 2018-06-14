package com.example.recyclerview_seclected;


import android.view.View;
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


    //重点 设置数据时把点击那里item获取
    public void setList(List<UserBean> mList) {
        this.mList = mList;

        notifyDataSetChanged();

    }


    @Override
    protected void convert(final BaseViewHolder helper, final UserBean item) {
        final TextView tvId = helper.itemView.findViewById(R.id.item_horizontaltext);
        tvId.setText(item.getName() + "");

        //点击的item和对应所有数据对应item一致就设置状态
        tvId.setSelected(item.isCheck());

        tvId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvId.isSelected()) {
                    mList.get(helper.getPosition()).setCheck(false);
                } else {
                    mList.get(helper.getPosition()).setCheck(true);
                }

                if (onItemListener!=null){
                    onItemListener.onItemClick(helper.getPosition());
                }


            }
        });


    }


    public interface OnItemListener {
        void onItemClick(int position);
    }

    public  OnItemListener onItemListener;

    public  void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }
}
