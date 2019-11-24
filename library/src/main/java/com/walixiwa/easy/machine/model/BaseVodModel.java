package com.walixiwa.easy.machine.model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * 播放地址和标题Model
 */
public class BaseVodModel implements Serializable {
    private String name;
    private String url;
    private boolean checked;

    public BaseVodModel(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
