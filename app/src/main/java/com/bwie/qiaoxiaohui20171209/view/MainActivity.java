package com.bwie.qiaoxiaohui20171209.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwie.qiaoxiaohui20171209.R;
import com.bwie.qiaoxiaohui20171209.adapter.RvAdapter;
import com.bwie.qiaoxiaohui20171209.bean.NewsList;
import com.bwie.qiaoxiaohui20171209.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private RecyclerView rv;
    private MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter.setNewsList();
        rv.setLayoutManager(new GridLayoutManager(this,2));
    }

    private void initView() {
        rv = findViewById(R.id.rv);
    }

    @Override
    public void showNewsList(NewsList newsList) {
        final List<NewsList.GoodsListBean> list = newsList.getGoods_list();
        RvAdapter adapter = new RvAdapter(this, list);
        rv.setAdapter(adapter);
        adapter.setOnClickItemListener(new RvAdapter.OnClickListener() {
            @Override
            public void OnClickItemListener(int position) {
                Toast.makeText(MainActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ParticularsActivity.class);
                int id = list.get(position).getGoods_id();
                intent.putExtra("id",id+"");
                startActivity(intent);
            }
        });
    }
}
