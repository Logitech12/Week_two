package com.bwie.qiaoxiaohui20171209.net;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class Api {
    public static final String HOST1 = "http://apiv3.yangkeduo.com/";
    public static final String HOST2 = "http://apiv4.yangkeduo.com/";
    public static final String NWESLIST = "v5/newlist?page=1&size=20&ver=1512745500001&pdduid=3470667255";//新品列表
    public static final String PARTICULARS = "v5/goods/202517471?pdduid=3470667255";//产品详情页面接口
    public static final String RECOMMEND = "recommendation/mall?{goods_id}?&pdduid=3470667255";//店铺推荐接口
    public static final String COMMENTARIES = "reviews/{gid}?page=1&size=2&label=1&is_back=1&pdduid=3470667255";//产品评论接口
}
