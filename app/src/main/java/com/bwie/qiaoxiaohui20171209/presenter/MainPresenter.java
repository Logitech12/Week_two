package com.bwie.qiaoxiaohui20171209.presenter;

import com.bwie.qiaoxiaohui20171209.bean.NewsList;
import com.bwie.qiaoxiaohui20171209.model.IMainModel;
import com.bwie.qiaoxiaohui20171209.model.MainModel;
import com.bwie.qiaoxiaohui20171209.net.OnNetListener;
import com.bwie.qiaoxiaohui20171209.view.IMainActivity;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class MainPresenter {
    private IMainModel iMainModel;
    private IMainActivity iMainActivity;

    public MainPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        iMainModel = new MainModel();
    }
    public void setNewsList(){
        iMainModel.getNewsList(new OnNetListener<NewsList>() {
            @Override
            public void onSuccess(NewsList newsList) {
                iMainActivity.showNewsList(newsList);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
