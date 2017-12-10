package com.bwie.qiaoxiaohui20171209.presenter;

import com.bwie.qiaoxiaohui20171209.bean.Commentaries;
import com.bwie.qiaoxiaohui20171209.bean.Particulars;
import com.bwie.qiaoxiaohui20171209.bean.Recommend;
import com.bwie.qiaoxiaohui20171209.model.IParticularsModel;
import com.bwie.qiaoxiaohui20171209.model.ParticularsModel;
import com.bwie.qiaoxiaohui20171209.net.OnNetListener;
import com.bwie.qiaoxiaohui20171209.view.IParticularsActivity;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class ParticularsPresenter {
    private IParticularsModel iParticularsModel;
    private IParticularsActivity iParticularsActivity;

    public ParticularsPresenter(IParticularsActivity iParticularsActivity) {
        this.iParticularsActivity = iParticularsActivity;
        iParticularsModel = new ParticularsModel();
    }

    public void setParticulars(String id){
        iParticularsModel.getParticulars(new OnNetListener<Particulars>() {
            @Override
            public void onSuccess(Particulars particulars) {
                iParticularsActivity.showParticulars(particulars);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },id);
    }
    public void setCommentaries(String id){
        iParticularsModel.getCommentaries(new OnNetListener<Commentaries>() {
            @Override
            public void onSuccess(Commentaries commentaries) {
                iParticularsActivity.showCommentaries(commentaries);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },id);
    }
    public void setRecommend(String mall,String id){
        iParticularsModel.getRecommend(new OnNetListener<Recommend>() {
            @Override
            public void onSuccess(Recommend recommend) {
                iParticularsActivity.showRecommend(recommend);
            }

            @Override
            public void onFailure(Exception e) {

            }
        },mall,id);
    }
}
