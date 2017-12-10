package com.bwie.qiaoxiaohui20171209.model;

import com.bwie.qiaoxiaohui20171209.bean.NewsList;
import com.bwie.qiaoxiaohui20171209.net.OnNetListener;
import com.bwie.qiaoxiaohui20171209.net.RetrofitHelper;
import com.bwie.qiaoxiaohui20171209.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class MainModel implements IMainModel {
    public void getNewsList(final OnNetListener<NewsList> onNetListener){
        ServerApi serverApi1 = RetrofitHelper.getServerApi1();
        serverApi1.newslist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(NewsList newsList) {
                        onNetListener.onSuccess(newsList);
                    }
                });
    }
}
