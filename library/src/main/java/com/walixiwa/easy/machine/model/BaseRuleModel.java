package com.walixiwa.easy.machine.model;

import android.text.TextUtils;
import android.util.Base64;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 匹配规则
 */
public class BaseRuleModel implements Serializable {
    private String name;//引擎名称
    private String version;//引擎版本
    private String reqCharset;//请求编码
    private String htmlCharset;//返回编码
    private String userAgent;//浏览器UA
    private String baseUrl;//域名来源
    private String searchUrl;//搜索链接：http://www.xxx.com/search.php?keyWords=%s&page=%s
    private String ruleResultList;//搜索结果列表规则 <整个匹配>
    private String ruleResultLinkHeader;//详情页链接前缀
    private String ruleResultLink;//搜索结果详情页链接规则<子匹配>
    private String ruleResultTitle;//搜索结果标题<子匹配>
    private String ruleResultType;//类型<子匹配>
    private String ruleResultTime;//时间<子匹配>
    private boolean hasNextPage = true; //是否有详情页，一般都是true
    private String ruleDetailCoverHeader;//详情页图片前缀
    private String ruleDetailCover;//详情页图片规则<子匹配>
    private String ruleDetailDesc;//详情页简介<子匹配>
    private String ruleDetailListM3u8;//播放地址列表规则<整个匹配>
    private String ruleDetailListShare;//分享链接列表规则<整个匹配>
    private String ruleDetailDownList;//下载链接列表规则<整个匹配>
    private String ruleDetailListSniff;//嗅探播放地址列表规则<整个匹配>
    private String ruleSniffPattern;//嗅探目标规则
    private String ruleDetailMain;//链接&标题<整个匹配>
    private String ruleDetailTitle;//链接规则<子匹配>
    private String ruleDetailLinkHeader;//标题规则<子匹配>
    private String ruleDetailLink;//标题规则<子匹配>

    private List<String> blockWords = new ArrayList<>();//屏蔽的类型或关键字

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReqCharset() {
        return reqCharset;
    }

    public void setReqCharset(String reqCharset) {
        this.reqCharset = reqCharset;
    }

    public String getHtmlCharset() {
        return htmlCharset;
    }

    public void setHtmlCharset(String htmlCharset) {
        this.htmlCharset = htmlCharset;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getRuleResultList() {
        return ruleResultList;
    }

    public void setRuleResultList(String ruleResultList) {
        this.ruleResultList = ruleResultList;
    }

    public String getRuleResultLinkHeader() {
        return ruleResultLinkHeader;
    }

    public void setRuleResultLinkHeader(String ruleResultLinkHeader) {
        this.ruleResultLinkHeader = ruleResultLinkHeader;
    }

    public String getRuleResultLink() {
        return ruleResultLink;
    }

    public void setRuleResultLink(String ruleResultLink) {
        this.ruleResultLink = ruleResultLink;
    }

    public String getRuleResultTitle() {
        return ruleResultTitle;
    }

    public void setRuleResultTitle(String ruleResultTitle) {
        this.ruleResultTitle = ruleResultTitle;
    }

    public String getRuleResultType() {
        return ruleResultType;
    }

    public void setRuleResultType(String ruleResultType) {
        this.ruleResultType = ruleResultType;
    }

    public String getRuleResultTime() {
        return ruleResultTime;
    }

    public void setRuleResultTime(String ruleResultTime) {
        this.ruleResultTime = ruleResultTime;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public String getRuleDetailCoverHeader() {
        return ruleDetailCoverHeader;
    }

    public void setRuleDetailCoverHeader(String ruleDetailCoverHeader) {
        this.ruleDetailCoverHeader = ruleDetailCoverHeader;
    }

    public String getRuleDetailCover() {
        return ruleDetailCover;
    }

    public void setRuleDetailCover(String ruleDetailCover) {
        this.ruleDetailCover = ruleDetailCover;
    }

    public String getRuleDetailDesc() {
        return ruleDetailDesc;
    }

    public void setRuleDetailDesc(String ruleDetailDesc) {
        this.ruleDetailDesc = ruleDetailDesc;
    }

    public String getRuleDetailListM3u8() {
        return ruleDetailListM3u8;
    }

    public void setRuleDetailListM3u8(String ruleDetailListM3u8) {
        this.ruleDetailListM3u8 = ruleDetailListM3u8;
    }

    public String getRuleDetailListShare() {
        return ruleDetailListShare;
    }

    public void setRuleDetailListShare(String ruleDetailListShare) {
        this.ruleDetailListShare = ruleDetailListShare;
    }

    public String getRuleDetailDownList() {
        return ruleDetailDownList;
    }

    public void setRuleDetailDownList(String ruleDetailDownList) {
        this.ruleDetailDownList = ruleDetailDownList;
    }

    public String getRuleDetailListSniff() {
        return ruleDetailListSniff;
    }

    public BaseRuleModel setRuleDetailListSniff(String ruleDetailListSniff) {
        this.ruleDetailListSniff = ruleDetailListSniff;
        return this;
    }

    public String getRuleSniffPattern() {
        return ruleSniffPattern;
    }

    public BaseRuleModel setRuleSniffPattern(String ruleSniffPattern) {
        this.ruleSniffPattern = ruleSniffPattern;
        return this;
    }

    public String getRuleDetailMain() {
        return ruleDetailMain;
    }

    public void setRuleDetailMain(String ruleDetailMain) {
        this.ruleDetailMain = ruleDetailMain;
    }

    public String getRuleDetailTitle() {
        return ruleDetailTitle;
    }

    public void setRuleDetailTitle(String ruleDetailTitle) {
        this.ruleDetailTitle = ruleDetailTitle;
    }

    public String getRuleDetailLink() {
        return ruleDetailLink;
    }

    public void setRuleDetailLink(String ruleDetailLink) {
        this.ruleDetailLink = ruleDetailLink;
    }

    public String getRuleDetailLinkHeader() {
        return ruleDetailLinkHeader;
    }

    public BaseRuleModel setRuleDetailLinkHeader(String ruleDetailLinkHeader) {
        this.ruleDetailLinkHeader = ruleDetailLinkHeader;
        return this;
    }

    public List<String> getBlockWords() {
        return blockWords;
    }

    public void setBlockWords(List<String> blockWords) {
        this.blockWords = blockWords;
    }

    public String toJsonString() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            addParam(jsonObject, "name", name);
            addParam(jsonObject, "version", version);
            addParam(jsonObject, "reqCharset", reqCharset);
            addParam(jsonObject, "htmlCharset", htmlCharset);
            addParam(jsonObject, "userAgent", userAgent);
            addParam(jsonObject, "baseUrl", baseUrl);
            addParam(jsonObject, "searchUrl", searchUrl);
            addParam(jsonObject, "ruleResultList", ruleResultList);
            addParam(jsonObject, "ruleResultLinkHeader", ruleResultLinkHeader);
            addParam(jsonObject, "ruleResultLink", ruleResultLink);
            addParam(jsonObject, "ruleResultTitle", ruleResultTitle);
            addParam(jsonObject, "ruleResultType", ruleResultType);
            addParam(jsonObject, "ruleResultTime", ruleResultTime);
            jsonObject.put("hasNextPage", hasNextPage);
            addParam(jsonObject, "ruleDetailCoverHeader", ruleDetailCoverHeader);
            addParam(jsonObject, "ruleDetailCover", ruleDetailCover);
            addParam(jsonObject, "ruleDetailDesc", ruleDetailDesc);
            addParam(jsonObject, "ruleDetailListM3u8", ruleDetailListM3u8);
            addParam(jsonObject, "ruleDetailListShare", ruleDetailListShare);
            addParam(jsonObject, "ruleDetailDownList", ruleDetailDownList);
            addParam(jsonObject, "ruleDetailListSniff", ruleDetailListSniff);
            addParam(jsonObject, "ruleSniffPattern", ruleSniffPattern);
            addParam(jsonObject, "ruleDetailMain", ruleDetailMain);
            addParam(jsonObject, "ruleDetailTitle", ruleDetailTitle);
            addParam(jsonObject, "ruleDetailLinkHeader", ruleDetailLinkHeader);
            addParam(jsonObject, "ruleDetailLink", ruleDetailLink);
            if (blockWords.size() > 0) {
                jsonObject.put("blockWords", new JSONArray(blockWords));
            }
            return jsonObject.toString();
        } catch (JSONException e) {
            return e.toString();
        }
    }

    public String toBase64Linker() {
        String linker = Base64.encodeToString(toJsonString().getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);
        linker = "linker://" + linker;
        return linker.replaceAll("\n", "");
    }

    private void addParam(JSONObject jsonObject, String key, String value) {
        try {
            if (!TextUtils.isEmpty(value)) {
                jsonObject.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getParam(JSONObject jsonObject, String key) {
        String result = "";
        try {
            if (jsonObject.has(key)) {
                result = jsonObject.getString(key);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }

    public BaseRuleModel() {
    }

    public BaseRuleModel(String linker) {
        try {
            linker = linker.replace("linker://", "");
            linker = new String(Base64.decode(linker.getBytes(), Base64.DEFAULT), StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(linker);
            this.name = getParam(jsonObject, "name");
            this.version = getParam(jsonObject, "version");
            this.reqCharset = getParam(jsonObject, "reqCharset");
            this.htmlCharset = getParam(jsonObject, "htmlCharset");
            this.userAgent = getParam(jsonObject, "userAgent");
            this.baseUrl = getParam(jsonObject, "baseUrl");
            this.searchUrl = getParam(jsonObject, "searchUrl");
            this.ruleResultList = getParam(jsonObject, "ruleResultList");
            this.ruleResultLinkHeader = getParam(jsonObject, "ruleResultLinkHeader");
            this.ruleResultLink = getParam(jsonObject, "ruleResultLink");
            this.ruleResultTitle = getParam(jsonObject, "ruleResultTitle");
            this.ruleResultType = getParam(jsonObject, "ruleResultType");
            this.ruleResultTime = getParam(jsonObject, "ruleResultTime");
            if (jsonObject.has("hasNextPage")) {
                this.hasNextPage = jsonObject.getBoolean("hasNextPage");
            }
            this.ruleDetailCoverHeader = getParam(jsonObject, "ruleDetailCoverHeader");
            this.ruleDetailCover = getParam(jsonObject, "ruleDetailCover");
            this.ruleDetailDesc = getParam(jsonObject, "ruleDetailDesc");
            this.ruleDetailListM3u8 = getParam(jsonObject, "ruleDetailListM3u8");
            this.ruleDetailListShare = getParam(jsonObject, "ruleDetailListShare");
            this.ruleDetailDownList = getParam(jsonObject, "ruleDetailDownList");
            this.ruleDetailListSniff = getParam(jsonObject, "ruleDetailListSniff");
            this.ruleSniffPattern = getParam(jsonObject, "ruleSniffPattern");
            this.ruleDetailMain = getParam(jsonObject, "ruleDetailMain");
            this.ruleDetailTitle = getParam(jsonObject, "ruleDetailTitle");
            this.ruleDetailLink = getParam(jsonObject, "ruleDetailLink");
            this.ruleDetailLinkHeader = getParam(jsonObject, "ruleDetailLinkHeader");
            if (jsonObject.has("blockWords")) {
                JSONArray jsonArray = jsonObject.getJSONArray("blockWords");
                for (int i = 0; i < jsonArray.length(); i++) {
                    this.blockWords.add(jsonArray.getString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
