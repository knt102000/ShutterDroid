package com.trial.chiutsui.shutterdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trial.chiutsui.shutterdroid.shutterstock.ShutterImages;
import com.trial.chiutsui.shutterdroid.shutterstock.ShutterStock;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private List<ShutterImages> mImages;
    private ImagesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImages = new ArrayList<>();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.images_view);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mAdapter = new ImagesAdapter(MainActivity.this,mImages);
        recyclerView.setAdapter(mAdapter);

        ShutterStock.getRecent(new Date(), new Callback<List<ShutterImages>>() {
            @Override
            public void success(List<ShutterImages> shutterImages, Response response) {
                updateImages(shutterImages);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void updateImages(List<ShutterImages> images) {
        mImages.clear();
        mImages.addAll(images);
        mAdapter.notifyDataSetChanged();
    }
}
