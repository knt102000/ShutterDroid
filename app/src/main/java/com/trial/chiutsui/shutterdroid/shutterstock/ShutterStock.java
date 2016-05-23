package com.trial.chiutsui.shutterdroid.shutterstock;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by chiutsui on 5/22/16.
 */
public class ShutterStock {
    private static final String API_URL = "https://api.shutterstock.com/v2";

    private static final String CLIENT_ID = "85cc76dc2f03d8d2c17c";
    private static final String CLIENT_SECRET = "e0f2890e721a144eeeee9150f4bb078e81e7a29a";

    private static final RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API_URL)
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = CLIENT_ID+":"+CLIENT_SECRET;
                    String auth = "Basic "+ Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", auth);
                }
            })
            .build();

    private static final ShutterstockService service = restAdapter.create(ShutterstockService.class);

    public static ShutterstockService getService() { return service;}

    public static void search(String query, Callback<List<ShutterImages>> cb) {
        service.searchImages(query, new imageCallback(cb));
    }

    public static void getRecent(Date date, Callback<List<ShutterImages>> cb) {
        service.recentImages(new SimpleDateFormat("yyyy-MM-dd").format(date), new imageCallback(cb));
    }

    private static class imageCallback implements Callback<Response> {
        Callback<List<ShutterImages>> cb;

        imageCallback(Callback<List<ShutterImages>> cb) {
            this.cb = cb;
        }

        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data, response2);
        }

        @Override
        public void failure(RetrofitError error) {
            cb.failure(error);
        }
    }
}
