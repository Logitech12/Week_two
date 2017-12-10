package com.bwie.qiaoxiaohui20171209.view;

import com.bwie.qiaoxiaohui20171209.bean.Commentaries;
import com.bwie.qiaoxiaohui20171209.bean.Particulars;
import com.bwie.qiaoxiaohui20171209.bean.Recommend;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public interface IParticularsActivity {
    public void showParticulars(Particulars particulars);
    public void showCommentaries(Commentaries commentaries);
    public void showRecommend(Recommend recommend);
}
