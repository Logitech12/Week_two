package com.bwie.qiaoxiaohui20171209.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bwie.qiaoxiaohui20171209.R;
import com.bwie.qiaoxiaohui20171209.adapter.Rv1Adapter;
import com.bwie.qiaoxiaohui20171209.adapter.Rv2Adapter;
import com.bwie.qiaoxiaohui20171209.bean.Commentaries;
import com.bwie.qiaoxiaohui20171209.bean.Particulars;
import com.bwie.qiaoxiaohui20171209.bean.Recommend;
import com.bwie.qiaoxiaohui20171209.presenter.ParticularsPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class ParticularsActivity extends AppCompatActivity implements IParticularsActivity {

    private SimpleDraweeView mPSdv;
    private TextView mPTv1;
    private TextView mPTv2;
    private TextView mPTv3;
    /**
     * 商品评价
     */
    private TextView mPj;
    /**
     * 查看全部
     */
    private TextView mCk;
    private RecyclerView mPRv1;
    private RecyclerView mPRv2;
    private TextView mPTv4;
    private ParticularsPresenter particularsPresenter = new ParticularsPresenter(this);
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);
        initView();
        id = getIntent().getStringExtra("id");
        particularsPresenter.setParticulars(id);
        particularsPresenter.setRecommend("mall",id);
        particularsPresenter.setCommentaries(id);
        mPRv1.setLayoutManager(new LinearLayoutManager(this));
        mPRv2.setLayoutManager(new GridLayoutManager(this,3));
    }

    private void initView() {
        mPSdv = findViewById(R.id.p_sdv);
        mPTv1 = findViewById(R.id.p_tv1);
        mPTv2 = findViewById(R.id.p_tv2);
        mPTv3 = findViewById(R.id.p_tv3);
        mPj = findViewById(R.id.pj);
        mCk = findViewById(R.id.ck);
        mPRv1 = findViewById(R.id.p_rv1);
        mPRv2 = findViewById(R.id.p_rv2);
        mPTv4 = findViewById(R.id.p_tv4);
    }

    @Override
    public void showParticulars(Particulars particulars) {
        mPSdv.setImageURI(particulars.getGallery().get(0).getUrl());
        mPTv1.setText("￥"+particulars.getMarket_price());
        mPTv2.setText(particulars.getGoods_name());
        List<Particulars.ServicePromiseBean> list1 = particulars.getService_promise();
        mPTv3.setText(list1.get(0).getType()+"      "+list1.get(1).getType()+"      "+list1.get(2).getType()+"      "+list1.get(3).getType());
        mPTv4.setText(particulars.getGoods_name()+"/n"+particulars.getShare_desc());
    }

    @Override
    public void showCommentaries(Commentaries commentaries) {
        mPRv1.setAdapter(new Rv1Adapter(this,commentaries.getData()));
    }

    @Override
    public void showRecommend(Recommend recommend) {
        mPRv2.setAdapter(new Rv2Adapter(this,recommend.getList()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
