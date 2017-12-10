package com.bwie.qiaoxiaohui20171209.net;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public interface OnNetListener<T> {
    public void onSuccess(T t);
    public void onFailure(Exception e);
}
