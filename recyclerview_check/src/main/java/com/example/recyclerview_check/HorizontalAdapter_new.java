package com.example.recyclerview_check;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Administrator on 2017/4/27.
 */

//竞猜上面的item
public class HorizontalAdapter_new extends RecyclerView.Adapter<HorizontalAdapter_new.ViewHolder> {

    private List<User> mList;

    public HorizontalAdapter_new(List<User> mList) {
        this.mList = mList;

    }


    //设置数据 需要个获取选中那个item
    private int position;

    public void setList(List<User> mList, int position) {
        this.mList = mList;
        this.position = position;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_horizontal, viewGroup, false);
        ViewHolder vh = new ViewHolder(inflate);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // 设置数据
        holder.text.setText(mList.get(position).getContent() + "");

        //设置点击状态
        holder.text.setSelected(mList.get(position).isSelect());
        holder.text2.setSelected(mList.get(position).isSelect2());


        //回调监听
        holder.text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //逻辑处理 保存状态
                if (holder.text.isSelected() == true) {
                    if (holder.text2.isSelected() == true) {
                        mList.get(position).setSelect(true);
                        mList.get(position).setSelect2(false);
                    } else {
                        mList.get(position).setSelect(false);
                        mList.get(position).setSelect2(true);
                    }


                } else {
                    if (holder.text2.isSelected() == true) {
                        mList.get(position).setSelect(false);
                        mList.get(position).setSelect2(false);
                    } else {
                        mList.get(position).setSelect(false);
                        mList.get(position).setSelect2(true);
                    }


                }

                //回调
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);

                }

            }
        });


        //回调监听
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //回调
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(position);
                }

                //逻辑处理 保存状态
                if (holder.text2.isSelected() == true) {
                    if (holder.text.isSelected() == true) {
                        mList.get(position).setSelect(false);
                        mList.get(position).setSelect2(true);
                    } else {
                        mList.get(position).setSelect(true);
                        mList.get(position).setSelect2(false);
                    }
                } else {
                    if (holder.text.isSelected() == true) {
                        mList.get(position).setSelect(false);
                        mList.get(position).setSelect2(false);
                    } else {
                        mList.get(position).setSelect(true);
                        mList.get(position).setSelect2(false);
                    }

                }


            }
        });


    }


    /**
     * ItemClick的回调接口
     */
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    /**
     * 布局
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text, text2;

        public ViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.item_horizontaltext);
            text2 = view.findViewById(R.id.item_2);
        }
    }


}