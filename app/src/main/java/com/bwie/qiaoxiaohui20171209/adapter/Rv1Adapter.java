package com.bwie.qiaoxiaohui20171209.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.qiaoxiaohui20171209.R;
import com.bwie.qiaoxiaohui20171209.bean.Commentaries;

import java.util.List;

/**
 * Created by 乔晓慧 on 2017/12/10.
 */

public class Rv1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Commentaries.DataBean> list;

    public Rv1Adapter(Context context, List<Commentaries.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item0, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        Commentaries.DataBean dataBean = list.get(position);
        holder1.tv1.setText(dataBean.getComment());
        holder1.tv2.setText(dataBean.getSpecs());
        holder1.tv3.setText("**名称："+dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv_1);
            tv2 = itemView.findViewById(R.id.tv_2);
            tv3 = itemView.findViewById(R.id.tv_3);
        }
    }
}
