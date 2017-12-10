package com.bwie.qiaoxiaohui20171209.model;

import com.bwie.qiaoxiaohui20171209.bean.Commentaries;
import com.bwie.qiaoxiaohui20171209.bean.Particulars;
import com.bwie.qiaoxiaohui20171209.bean.Recommend;
import com.bwie.qiaoxiaohui20171209.net.OnNetListener;
import com.bwie.qiaoxiaohui20171209.net.RetrofitHelper;
import com.bwie.qiaoxiaohui20171209.net.ServerApi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class ParticularsModel implements IParticularsModel{
    public void getParticulars(final OnNetListener<Particulars> onNetListener,String id){
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.particulars(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Particulars>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(Particulars particulars) {
                        onNetListener.onSuccess(particulars);
                    }
                });
    }

    @Override
    public void getCommentaries(final OnNetListener<Commentaries> onNetListener, String id) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.commentaries(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Commentaries>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(Commentaries commentaries) {
                        onNetListener.onSuccess(commentaries);
                    }
                });
    }

    @Override
    public void getRecommend(final OnNetListener<Recommend> onNetListener, String mall, String id) {
        ServerApi serverApi = RetrofitHelper.getServerApi();
        serverApi.recommend(mall,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Recommend>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        onNetListener.onFailure((Exception) e);
                    }

                    @Override
                    public void onNext(Recommend recommend) {
                        onNetListener.onSuccess(recommend);
                    }
                });
    }
}
