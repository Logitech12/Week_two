package com.bwie.qiaoxiaohui20171209.net;

import com.bwie.qiaoxiaohui20171209.bean.Commentaries;
import com.bwie.qiaoxiaohui20171209.bean.NewsList;
import com.bwie.qiaoxiaohui20171209.bean.Particulars;
import com.bwie.qiaoxiaohui20171209.bean.Recommend;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public interface ServerApi {
    @GET(Api.NWESLIST)
    Observable<NewsList> newslist();
    @POST("v5/goods/{gid}?pdduid=3470667255")
    Observable<Particulars> particulars(@Path("gid") String id);
    @POST("recommendation/{mall}?pdduid=3470667255&")
    Observable<Recommend> recommend(@Path("mall") String mall,@Query("goods_id") String id);
    @GET(Api.COMMENTARIES)
    Observable<Commentaries> commentaries(@Path("gid") String id);
}
