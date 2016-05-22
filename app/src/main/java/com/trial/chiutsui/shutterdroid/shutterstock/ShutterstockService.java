package com.trial.chiutsui.shutterdroid.shutterstock;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by chiutsui on 5/22/16.
 */
interface ShutterstockService {

    @GET("/images/search")
    public void searchImages(@Query("query") String query, Callback<Response> cb);

    @GET("/images/search")
    public void recentImages(@Query("added_date_start") String date, Callback<Response> cb);
}
