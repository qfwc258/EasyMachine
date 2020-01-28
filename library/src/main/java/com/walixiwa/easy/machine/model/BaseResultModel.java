package com.walixiwa.easy.machine.model;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
/**
 * 搜索结果Model
 */
public class BaseResultModel implements Serializable {
    private String resultCover;//搜索详情标题
    private String resultLink;//搜索结果详情页链接规则
    private String resultTitle;//搜索结果标题
    private String resultType;//类型
    private String resultTime;//时间
    private BaseRuleModel baseRuleModel;

    public String getResultCover() {
        return resultCover;
    }

    public BaseResultModel setResultCover(String resultCover) {
        this.resultCover = resultCover;
        return this;
    }

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
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("resultTitle", this.resultTitle);
            jsonObject.put("resultLink", this.resultLink);
            jsonObject.put("resultTime", this.resultTime);
            jsonObject.put("resultType", this.resultType);
            jsonObject.put("baseRuleModel", this.baseRuleModel.toBase64Linker());
        } catch (JSONException var3) {
            var3.printStackTrace();
        }
        return jsonObject.toString();
    }

    public BaseResultModel() {
    }

    public BaseResultModel(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            this.resultTitle = this.getString(jsonObject, "resultTitle");
            this.resultLink = this.getString(jsonObject, "resultLink");
            this.resultType = this.getString(jsonObject, "resultType");
            this.resultTime = this.getString(jsonObject, "resultTime");
            this.baseRuleModel = new BaseRuleModel(getString(jsonObject, "baseRuleModel"));
        } catch (JSONException var3) {
            var3.printStackTrace();
        }
    }

    private String getString(JSONObject jsonObject, String key) {
        if (jsonObject.has(key)) {
            try {
                return jsonObject.getString(key);
            } catch (JSONException var4) {
                return "";
            }
        } else {
            return "";
        }
    }
}
