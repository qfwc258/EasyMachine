package com.walixiwa.easy.machine.model;

import com.google.gson.Gson;

import java.io.Serializable;
/**
 * 搜索结果Model
 */
public class BaseResultModel implements Serializable {
    private String resultLink;//搜索结果详情页链接规则
    private String resultTitle;//搜索结果标题
    private String resultType;//类型
    private String resultTime;//时间
    private BaseRuleModel baseRuleModel;

    public String getResultLink() {
        return resultLink;
    }

    public void setResultLink(String resultLink) {
        this.resultLink = resultLink;
    }

    public String getResultTitle() {
        return resultTitle;
    }

    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    public BaseRuleModel getBaseRuleModel() {
        return baseRuleModel;
    }

    public void setBaseRuleModel(BaseRuleModel baseRuleModel) {
        this.baseRuleModel = baseRuleModel;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
