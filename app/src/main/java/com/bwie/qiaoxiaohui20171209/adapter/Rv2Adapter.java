package com.bwie.qiaoxiaohui20171209.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.qiaoxiaohui20171209.R;
import com.bwie.qiaoxiaohui20171209.bean.Recommend;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class Rv2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Recommend.ListBean> lists;

    public Rv2Adapter(Context context, List<Recommend.ListBean> lists) {
        this.context = context;
        this.lists = lists;
    }
    //为点击事件设置自定义接口
    public RvAdapter.OnClickListener onClickItemListener;

    public interface OnClickListener {
        public void OnClickItemListener(int position);
    }

    public void setOnClickItemListener(RvAdapter.OnClickListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Recommend.ListBean listBean = lists.get(position);
        holder1.sdv.setImageURI(listBean.getHd_thumb_url());
        holder1.tv1.setText(listBean.getShort_name());
        holder1.tv2.setText("￥"+listBean.getPrice());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        TextView tv1;
        TextView tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.rsdv);
            tv1 = itemView.findViewById(R.id.rtv1);
            tv2 = itemView.findViewById(R.id.rtv2);
        }
    }
}
