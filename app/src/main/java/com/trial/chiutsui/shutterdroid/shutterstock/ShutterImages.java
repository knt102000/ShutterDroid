package com.trial.chiutsui.shutterdroid.shutterstock;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chiutsui on 5/22/16.
 */
public class ShutterImages {
    @SerializedName("id")
    private String mId;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("assets")
    private ImageAssets mAssets;

    private class ImageAssets{
        @SerializedName("preview")
        private Thumbnail preview;

        @SerializedName("small_thumb")
        private Thumbnail mSmallThumb;

        @SerializedName("large_thumb")
        private Thumbnail mLargeThumb;
    }

    private class Thumbnail{
        @SerializedName("url")
        private String mUrl;
    }

    public String getId() {
        return mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getLargeThumb() {
        return mAssets.mLargeThumb.mUrl;
    }
}
