package com.trial.chiutsui.shutterdroid.shutterstock;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chiutsui on 5/22/16.
 */
class Response {
    @SerializedName("data")
    public List<ShutterImages> data;
}
