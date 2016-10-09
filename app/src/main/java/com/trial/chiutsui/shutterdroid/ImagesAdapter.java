package com.trial.chiutsui.shutterdroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.trial.chiutsui.shutterdroid.shutterstock.ShutterImages;

import java.util.List;

/**
 * Created by chiutsui on 5/22/16.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder>{
    private List<ShutterImages> mImages;
    private Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView=(ImageView) itemView;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShutterImages image = mImages.get(position);

        Picasso.with(mContext).load(image.getPreview()).into(holder.mImageView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_image,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public ImagesAdapter(Context context, List<ShutterImages> images) {
        mImages=images;
        mContext = context;
    }
}
