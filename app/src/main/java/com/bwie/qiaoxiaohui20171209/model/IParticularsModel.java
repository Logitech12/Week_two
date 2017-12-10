package com.bwie.qiaoxiaohui20171209.model;

import com.bwie.qiaoxiaohui20171209.bean.Commentaries;
import com.bwie.qiaoxiaohui20171209.bean.Particulars;
import com.bwie.qiaoxiaohui20171209.bean.Recommend;
import com.bwie.qiaoxiaohui20171209.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public interface IParticularsModel {
    public void getParticulars(OnNetListener<Particulars> onNetListener,String id);
    public void getCommentaries(OnNetListener<Commentaries> onNetListener,String id);
    public void getRecommend(OnNetListener<Recommend> onNetListener, String mall, String id);
}
