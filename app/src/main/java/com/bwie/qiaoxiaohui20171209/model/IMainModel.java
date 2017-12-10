package com.bwie.qiaoxiaohui20171209.model;

import com.bwie.qiaoxiaohui20171209.bean.NewsList;
import com.bwie.qiaoxiaohui20171209.net.OnNetListener;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public interface IMainModel {
    public void getNewsList(OnNetListener<NewsList> onNetListener);
}
