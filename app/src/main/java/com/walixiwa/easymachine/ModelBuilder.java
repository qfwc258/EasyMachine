package com.walixiwa.easymachine;

import com.walixiwa.easy.machine.model.BaseRuleModel;

import java.util.Arrays;

public class ModelBuilder {
    public static BaseRuleModel buildZuiDaModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("最大资源网");
        ruleModel.setVersion("2019.11.13");
        ruleModel.setBaseUrl("http://www.zuidazy1.net");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("https://www.zuidazy1.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li><span class=\"tt\">.*?xing_vb5.*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.zuidazy1.net");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\"");
        ruleModel.setRuleResultType("xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("xing_vb6\">(.*?)</span>");
        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("<div class=\"vodplayinfo\">(.*?)</div>");
        ruleModel.setRuleDetailListM3u8("<div id=\"play_1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<div id=\"play_2\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailDownList("<div id=\"down_1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<li>.*?checkbox.*?</li>");
        ruleModel.setRuleDetailTitle("checked=\"\" />(.*?)\\$");
        ruleModel.setRuleDetailLink("value=\"(.*?)\"");
        ruleModel.setBlockWords(Arrays.asList("福利片","伦理片"));
        return ruleModel;
    }
}
