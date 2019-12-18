package com.walixiwa.easy.machine.model;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 详情页Model
 */
public class BaseDetailModel implements Serializable {
    private String cover;
    private String description;
    private List<BaseVodModel> m3u8List = new ArrayList<>();
    private List<BaseVodModel> shareList = new ArrayList<>();
    private List<BaseVodModel> downList = new ArrayList<>();
    private List<BaseVodModel> parseList = new ArrayList<>();

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BaseVodModel> getM3u8List() {
        return m3u8List;
    }

    public void setM3u8List(List<BaseVodModel> m3u8List) {
        this.m3u8List = m3u8List;
    }

    public List<BaseVodModel> getShareList() {
        return shareList;
    }

    public void setShareList(List<BaseVodModel> shareList) {
        this.shareList = shareList;
    }

    public List<BaseVodModel> getDownList() {
        return downList;
    }

    public void setDownList(List<BaseVodModel> downList) {
        this.downList = downList;
    }

    public List<BaseVodModel> getParseList() {
        return parseList;
    }

    public void setParseList(List<BaseVodModel> parseList) {
        this.parseList = parseList;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
