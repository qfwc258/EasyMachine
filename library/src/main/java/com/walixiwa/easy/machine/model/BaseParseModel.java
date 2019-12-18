package com.walixiwa.easy.machine.model;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class BaseParseModel  implements Serializable {
    private String parseHeader;//解析id and地址：http://www.baidu.com/jx.php?id=%id
    private String rulePlayUrl;//<iframe src="https://g.shumafen.cn/api/file/530655cd742700ee/a606c6695f59f00a.mp4"

    public String getParseHeader() {
        return parseHeader;
    }

    public void setParseHeader(String parseHeader) {
        this.parseHeader = parseHeader;
    }

    public String getRulePlayUrl() {
        return rulePlayUrl;
    }

    public void setRulePlayUrl(String rulePlayUrl) {
        this.rulePlayUrl = rulePlayUrl;
    }

    public BaseParseModel() {
    }

    public BaseParseModel(String json) {
        try {
            JSONObject object = new JSONObject(json);
            if (object.has("parseHeader")) {
                this.parseHeader = object.getString("parseHeader");
            }
            if (object.has("rulePlayUrl")) {
                this.rulePlayUrl = object.getString("rulePlayUrl");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONObject toJsonObject() {
        JSONObject object = null;
        try {
            object = new JSONObject();
            if (!TextUtils.isEmpty(parseHeader)) {
                object.put("parseHeader", parseHeader);
            }
            if (!TextUtils.isEmpty(rulePlayUrl)) {
                object.put("rulePlayUrl", rulePlayUrl);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object;
    }

}
