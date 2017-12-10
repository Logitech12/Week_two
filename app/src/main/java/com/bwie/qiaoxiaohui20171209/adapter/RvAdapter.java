package com.bwie.qiaoxiaohui20171209.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.qiaoxiaohui20171209.R;
import com.bwie.qiaoxiaohui20171209.bean.NewsList;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<NewsList.GoodsListBean> lists;

    public RvAdapter(Context context, List<NewsList.GoodsListBean> lists) {
        this.context = context;
        this.lists = lists;
    }
    //为点击事件设置自定义接口
    public OnClickListener onClickItemListener;

    public interface OnClickListener {
        public void OnClickItemListener(int position);
    }

    public void setOnClickItemListener(OnClickListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.xrv_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        final NewsList.GoodsListBean bean = lists.get(position);
        holder1.sdv.setImageURI(bean.getImage_url());
        holder1.tv1.setText(bean.getShort_name());
        holder1.tv2.setText("￥"+bean.getNormal_price());
        holder1.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItemListener.OnClickItemListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linear;
        SimpleDraweeView sdv;
        TextView tv1;
        TextView tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            linear = itemView.findViewById(R.id.liear);
            sdv = itemView.findViewById(R.id.sdv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
