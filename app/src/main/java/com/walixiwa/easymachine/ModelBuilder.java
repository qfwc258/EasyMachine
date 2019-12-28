package com.walixiwa.easymachine;

import com.walixiwa.easy.machine.model.BaseRuleModel;

import java.util.Arrays;
import java.util.Collections;

public class ModelBuilder {
    public static BaseRuleModel buildZuiDaModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("最大资源网");
        ruleModel.setVersion("2019.12.01/20:21");
        ruleModel.setBaseUrl("http://www.zuidazy2.net");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.zuidazy2.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li><span class=\"tt\">.*?xing_vb5.*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.zuidazy2.net");
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

    public static BaseRuleModel buildBaJieModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("八戒资源网");
        ruleModel.setVersion("2019.11.23");
        ruleModel.setBaseUrl("http://bajieziyuan.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://bajieziyuan.com/?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<tr class=\"DianDian\"[\\s\\S]*?</tr>");
        ruleModel.setRuleResultTitle("<td class=\"l\">.*?target=\"_blank\">([\\s\\S]*?)<td>");
        ruleModel.setRuleResultLinkHeader("http://bajieziyuan.com");
        ruleModel.setRuleResultLink("<td class=\"l\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");
        ruleModel.setRuleDetailCover("<img src=\"(.*?)\"/>");
        ruleModel.setRuleDetailDesc("<!--简介开始-->(.*?)<!--简介结束-->");
        ruleModel.setRuleDetailListM3u8("<!--前bjm3u8-->[\\s\\S]*?<!--后bjm3u8-->");
        ruleModel.setRuleDetailListShare("<!--前bjyun-->[\\s\\S]*?<!--后bjyun-->");
        ruleModel.setRuleDetailMain("<li>.*?checkbox.*?</li>");
        ruleModel.setRuleDetailTitle("value=\"(.*?)\\$.*?\"");
        ruleModel.setRuleDetailLink("value=\".*?\\$(.*?)\"");
        ruleModel.setBlockWords(Arrays.asList("福利片","伦理片"));
        return ruleModel;
    }

    public static BaseRuleModel buildVodSeeModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("卧龙资源网");
        ruleModel.setVersion("2019.11.23");
        ruleModel.setBaseUrl("http://wolongzy.net");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://wolongzy.net/search.html?page=%page&searchword=%keyWords&searchtype=-1");
        ruleModel.setRuleResultList("<a class=\"videoName\"[\\s\\S]*?</li>");
        ruleModel.setRuleResultTitle("style=\"width:370px;\">([\\s\\S]*?)(&nbsp|</a>)");
        ruleModel.setRuleResultLinkHeader("http://wolongzy.net");
        ruleModel.setRuleResultLink("href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"category\" >(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");
        ruleModel.setRuleDetailCover("<img src=\"(http://.*?)\">");
        ruleModel.setRuleDetailDesc("<h4>剧情介绍</h4>([\\s\\S]*?)</div>");
        ruleModel.setRuleDetailListM3u8("<h4><div>WLm3u8</div></h4>[\\s\\S]*?>播放协议");
        ruleModel.setRuleDetailListShare("<h4><div>WLyun</div></h4>[\\s\\S]*?>播放协议");
        ruleModel.setRuleDetailMain("<input.*?value=.*?checked>");
        ruleModel.setRuleDetailTitle("value=\"(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)\"");
        return ruleModel;
    }

    public static BaseRuleModel buildKuYunModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("酷云资源网");
        ruleModel.setVersion("2019.11.25");
        ruleModel.setBaseUrl("http://www.kuyunzy1.com");
        ruleModel.setReqCharset("gb2312");
        ruleModel.setHtmlCharset("gb2312");
        ruleModel.setSearchUrl("http://www.kuyunzy1.com/search.asp?page=%page&searchword=%keyWords&searchtype=-1");
        ruleModel.setRuleResultList("<tr><td colspan=\"5\"[\\s\\S]*?<tr><td colspan=\"5\"");
        ruleModel.setRuleResultTitle("target=\"_blank\">([\\s\\S]*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.kuyunzy1.com");
        ruleModel.setRuleResultLink("href=\"(.*?)\"");
        ruleModel.setRuleResultType("<td align=\"center\">[\\s\\S]*?<td align=\"center\">(.*?)</td>[\\s\\S]*?<td align=\"center\">");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");
        ruleModel.setRuleDetailCover("<img src=\"(.*?)\" alt");
        ruleModel.setRuleDetailDesc("<!--影片介绍开始代码-->([\\s\\S]*?)<!--影片介绍结束代码-->");
        ruleModel.setRuleDetailListM3u8("<h1>来源:kkm3u8</h1>[\\s\\S]*?checkAll");
        ruleModel.setRuleDetailListShare("<h1>来源:kkyun</h1>[\\s\\S]*?checkAll");
        ruleModel.setRuleDetailDownList("<h1>来源:xunlei</h1>[\\s\\S]*?checkAll");
        ruleModel.setRuleDetailMain("<input type='checkbox'[\\s\\S]*?</a>");
        ruleModel.setRuleDetailTitle("<a>(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</a>");
        ruleModel.setBlockWords(Collections.singletonList("伦理片"));
        return ruleModel;
    }

    public static BaseRuleModel buildOkYunModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("Ok资源网");
        ruleModel.setVersion("2019.12.26");
        ruleModel.setBaseUrl("http://www.okzyw.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.okzyw.com/?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li><span class=\"tt\">[\\s\\S]*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">([\\s\\S]*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.okzyw.com");
        ruleModel.setRuleResultLink("href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("<span class=\"xing_vb6\">(.*?)</span>");
        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("<span class=\"more\" txt=\"[\\s\\S]*?\">([\\s\\S]*?)</span>");
        ruleModel.setRuleDetailListM3u8("<div id=\"2\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<div id=\"1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailDownList("<div id=\"down_1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<li><input type=\"checkbox\"[\\s\\S]*?</li>");
        ruleModel.setRuleDetailTitle("/>(.*?)\\$");
        ruleModel.setRuleDetailLink("value=\"(.*?)\"");
        ruleModel.setBlockWords(Arrays.asList("伦理片","福利片"));
        return ruleModel;
    }

    public static BaseRuleModel build605Model(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("605资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.605zy.net");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.605zy.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li><span class=\"tt\">[\\s\\S]*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">([\\s\\S]*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.605zy.net");
        ruleModel.setRuleResultLink("href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("<span class=\"xing_vb6\">(.*?)</span>");
        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        ruleModel.setRuleDetailListM3u8("<h3>来源：605m3u8</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>来源：605yun</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailDownList("<div id=\"down_1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<li><input type=\"checkbox\"[\\s\\S]*?</li>");
        ruleModel.setRuleDetailTitle("/>(.*?)\\$");
        ruleModel.setRuleDetailLink("value=\"(.*?)\"");
        ruleModel.setBlockWords(Arrays.asList("伦理片","福利片"));
        return ruleModel;
    }

    public static BaseRuleModel build1886Model(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("1886资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.1886zy.net");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.1886zy.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<tr class=\"DianDian\"[\\s\\S]*?</tr>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</font>");
        ruleModel.setRuleResultLinkHeader("http://www.1886zy.net");
        ruleModel.setRuleResultLink("<td class=\"l\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<!--图片开始--><img src=\"(.*?)\"/><!--图片结束-->");
        ruleModel.setRuleDetailDesc("<!--简介开始-->([\\s\\S]*?)<!--简介结束-->");
        ruleModel.setRuleDetailListM3u8("<!--前zkm3u8-->[\\s\\S]*?<!--后zkm3u8-->");
        ruleModel.setRuleDetailListShare("<!--前zkyun-->[\\s\\S]*?<!--后zkyun-->");
        ruleModel.setRuleDetailMain("<li><input type=\"checkbox\"[\\s\\S]*?</li>");
        ruleModel.setRuleDetailTitle("value=\"(.*?)\\$");
        ruleModel.setRuleDetailLink("value=\".*?\\$(.*?)\"");
        ruleModel.setBlockWords(Arrays.asList("伦理片","福利片","韩国"));
        return ruleModel;
    }

    public static BaseRuleModel buildReBoModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("热播资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("https://rebozy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("https://rebozy.com/index.php/vod/search/page/%page/wd/%keyWords.html");
        ruleModel.setRuleResultList("<li class=\"clearfix\">[\\s\\S]*?</li>");
        ruleModel.setRuleResultTitle("title=\".*?\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("https://rebozy.com");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\" title");
        ruleModel.setRuleResultType("<span class=\"type\">[\\s\\S]*?<a href=\".*?\">(.*?)</a>[\\s\\S]*?</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCoverHeader("https://rebozy.com");
        ruleModel.setRuleDetailCover("<img class=\"img-responsive\" src=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("<!-- 剧情 -->([\\s\\S]*?)<!-- end 剧情 -->");
        ruleModel.setRuleDetailListM3u8("播放类型：.*?rem3u8[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("播放类型：.*?reyun[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input type=\"checkbox\".*?value=\".*?\\$.*?\" checked>");
        ruleModel.setRuleDetailTitle("value=\"(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)\"");
        ruleModel.setBlockWords(Collections.singletonList("伦理片"));
        return ruleModel;
    }

    public static BaseRuleModel build123KuModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("123资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.123ku.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.123ku.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.123ku.com");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        ruleModel.setRuleDetailDesc("<\\!--介绍开始-->([\\s\\S]*?)<\\!--介绍结束-->");
        ruleModel.setRuleDetailListM3u8("<div id=\"play_1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<div id=\"play_2\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input .*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("_black\">(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</a>");
        ruleModel.setBlockWords(Collections.singletonList("伦理片"));
        return ruleModel;
    }

    public static BaseRuleModel build209Model(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("209资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.209zy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.209zy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.209ZY.com");
        ruleModel.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        ruleModel.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        ruleModel.setRuleDetailListM3u8("<h3>来源：33uuck</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>来源：33uu</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input .*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("/>(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</li>");
        ruleModel.setBlockWords(Collections.singletonList("伦理片"));
        return ruleModel;
    }

    public static BaseRuleModel buildBaiWanModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("百万资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.baiwanzy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.baiwanzy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)<a href");
        ruleModel.setRuleResultLinkHeader("http://www.baiwanzy.com");
        ruleModel.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCoverHeader("http://www.baiwanzy.com");
        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        ruleModel.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        ruleModel.setRuleDetailListM3u8("<h3>来源：bwm3u8</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>来源：bwyun</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input .*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("/>(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</li>");
        ruleModel.setBlockWords(Arrays.asList("伦理片", "美女视频","VIP视频秀"));
        return ruleModel;
    }

    public static BaseRuleModel buildChaoJiModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("超级资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://chaojizy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://chaojizy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</span></li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://chaojizy.com");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\"");
        ruleModel.setRuleResultType("xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        ruleModel.setRuleDetailDesc("剧情介绍：</strong></div><div class=\"vodplayinfo\">([\\s\\S]*?)</div>");
        ruleModel.setRuleDetailListM3u8("<h3>播放类型：cjm3u8</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>播放类型：cjyun</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input.*?value=.*?checked.*?</li>");
        ruleModel.setRuleDetailTitle("target=\"_blank\">(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</a></li>");
        ruleModel.setBlockWords(Arrays.asList("伦理片","福利视频"));
        return ruleModel;
    }

    public static BaseRuleModel buildDouBanModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("豆瓣资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://douban666.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://douban666.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li><a class=\"videoName\"[\\s\\S]*?category[\\s\\S]*?</li>");
        ruleModel.setRuleResultTitle("src=[\\s\\S]*?/>(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://douban666.com");
        ruleModel.setRuleResultLink("href=\"(.*?)\"");
        ruleModel.setRuleResultType("category\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img src=\"(.*?)\">");
        ruleModel.setRuleDetailDesc("剧情介绍</h3>.*?>([\\s\\S]*?)</div>");
        ruleModel.setRuleDetailListM3u8("<a>来源：dbm3u8.*?\"playlist wbox\">[\\s\\S]*?</div>");
        ruleModel.setRuleDetailListShare("<a>来源：dbyun.*?\"playlist wbox\">[\\s\\S]*?</div>");
        ruleModel.setRuleDetailMain("<li><a title=.*?</a></li>");
        ruleModel.setRuleDetailTitle("_blank\">(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</a>");
        ruleModel.setBlockWords(Arrays.asList("伦理类", "视频秀"));
        return ruleModel;
    }

    public static BaseRuleModel buildGaoQingModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("高清资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.gaoqingzy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.gaoqingzy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<ul class=\"nr\">[\\s\\S]*?</ul>");
        ruleModel.setRuleResultTitle("class=\"name\"> &nbsp;&nbsp;&nbsp;&nbsp;(.*?)<img src");
        ruleModel.setRuleResultLinkHeader("http://www.gaoqingzy.com");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\"");
        ruleModel.setRuleResultType("btn_span\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=[\\s\\S]*?/>");
        ruleModel.setRuleDetailDesc("vodplayinfo\">([\\s\\S]*?)</div>[\\s\\S]*?心情结束");
        ruleModel.setRuleDetailListM3u8("<h3>播放类型：gqm3u8</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>播放类型：gqyun</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<li>.*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle(">(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</li>");
        ruleModel.setBlockWords(Arrays.asList("伦理片","美女写真"));
        return ruleModel;
    }

    public static BaseRuleModel buildHaKuModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("哈酷资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://666zy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://666zy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://666zy.com");
        ruleModel.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        ruleModel.setRuleDetailDesc("介绍：[\\s\\S]*?<div class=\"vodplayinfo\">([\\s\\S]*?)</div>");
        ruleModel.setRuleDetailListM3u8("<h3>来源：hkm3u8</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>来源：hkzy</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<li><a href=\".*?\" target=\"_blank\">.*?\\$.*?</a></li>");
        ruleModel.setRuleDetailTitle("target=\"_blank\">(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</a>");
        ruleModel.setBlockWords(Arrays.asList("写真","伦理"));
        return ruleModel;
    }

    public static BaseRuleModel buildSouLeModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("搜乐资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("https://www.solezy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("https://www.solezy.com/index.php/vod/search/page/%page/wd/%keyWords.html");
        ruleModel.setRuleResultList("<li class=\"clearfix\">[\\s\\S]*?</li>");
        ruleModel.setRuleResultTitle("title=\".*?\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("https://www.solezy.com");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\" title");
        ruleModel.setRuleResultType("<span class=\"type\">[\\s\\S]*?<a href=\".*?\">(.*?)</a>[\\s\\S]*?</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCoverHeader("https://www.solezy.com");
        ruleModel.setRuleDetailCover("<img class=\"img-responsive\" src=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("<div class=\"stui-content__desc col-pd clearfix\">([\\s\\S]*?)</div>");
        ruleModel.setRuleDetailListM3u8("播放类型：.*?som3u8[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("播放类型：.*?soyun[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input type=\"checkbox\".*?value=\".*?\\$.*?\" checked>");
        ruleModel.setRuleDetailTitle("value=\"(.*?)\\$");
        ruleModel.setRuleDetailLink("value=\".*?\\$(.*?)\"");
        ruleModel.setBlockWords(Collections.singletonList("伦理片"));
        return ruleModel;
    }

    public static BaseRuleModel buildSuBoModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("速播资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.subo988.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.subo988.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.subo988.com");
        ruleModel.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        ruleModel.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        ruleModel.setRuleDetailListM3u8("<h3>播放类型：subom3u8</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>播放类型：suboyun</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input .*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("/>(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</li>");
        ruleModel.setBlockWords(Arrays.asList("理论片", "福利片"));
        return ruleModel;
    }

    public static BaseRuleModel buildMaHuaModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("麻花资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://mahuazy.net");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://mahuazy.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://mahuazy.net");
        ruleModel.setRuleResultLink("xing_vb4\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=\".*?\" />");
        ruleModel.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        ruleModel.setRuleDetailListM3u8("<h3>播放类型：mahua</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>播放类型：kuyun</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input .*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("/>(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</li>");
        ruleModel.setBlockWords(Arrays.asList("伦理片","理论片", "福利片"));
        return ruleModel;
    }

    public static BaseRuleModel buildMiaoBoModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("秒播资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.mbkkk.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.mbkkk.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li><span class=\"tt\">.*?xing.*?</span></li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.mbkkk.com");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\"");
        ruleModel.setRuleResultType("<span class=\"xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCoverHeader("http://www.mbkkk.com");
        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\" alt=.*?/>");
        ruleModel.setRuleDetailDesc("<span class=\"more\" txt=\"([\\s\\S]*?)</span>");
        ruleModel.setRuleDetailListM3u8("<h3>来源：mbckm3u8</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<h3>来源：mbyun</h3>[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input.*?value=.*?checked.*?</li>");
        ruleModel.setRuleDetailTitle("target=\"_blank\" />(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</li>");
        ruleModel.setBlockWords(Arrays.asList("伦理片","福利视频"));
        return ruleModel;
    }

    public static BaseRuleModel buildKuBoModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("酷播资源网");
        ruleModel.setVersion("2019.12.08");
        ruleModel.setBaseUrl("http://www.kubozy.net");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.kubozy.net/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.kubozy.net");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\"");
        ruleModel.setRuleResultType("xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCoverHeader("http://www.mbkkk.com");
        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("剧情介绍：[\\s\\S]*?vodplayinfo\">([\\s\\S]*?)</div>");
        ruleModel.setRuleDetailListM3u8("<div id=\"2\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<div id=\"1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<input .*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("/>(.*?)\\$");
        ruleModel.setRuleDetailLink("\\$(.*?)</li>");
        ruleModel.setBlockWords(Arrays.asList("伦理片","福利片"));
        return ruleModel;
    }

    public static BaseRuleModel buildNiuNiuMeiJuModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("牛牛美剧");
        ruleModel.setVersion("2019.12.09");
        ruleModel.setBaseUrl("http://niuniuzy.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://niuniuzy.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<tr class=\"DianDian\"[\\s\\S]*?</tr>");
        ruleModel.setRuleResultTitle("<td class=\"l\"><a href=\".*?\" target=\"_blank\">(.*?)<td>");
        ruleModel.setRuleResultLinkHeader("http://niuniuzy.com");
        ruleModel.setRuleResultLink("<td class=\"l\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("<td><a href=\".*?\" target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img src=\"(.*?)\"/>");
        ruleModel.setRuleDetailDesc("<div class=\"movievod\">([\\s\\S]*?)</div>");
        ruleModel.setRuleDetailListM3u8("<li>nnm3u8</li>[\\s\\S]*?直接复制链接");
        ruleModel.setRuleDetailListShare("<li>nnyun</li>[\\s\\S]*?<li>nnm3u8</li>");
        ruleModel.setRuleDetailMain("<li><input type=\"checkbox\".*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("value=\"(.*?)\\$");
        ruleModel.setRuleDetailLink("value=\".*?\\$(.*?)\"");
        ruleModel.setBlockWords(Arrays.asList("伦理片","福利片"));
        return ruleModel;
    }

    public static BaseRuleModel buildYongJiuModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("永久资源网");
        ruleModel.setVersion("2019.12.09");
        ruleModel.setBaseUrl("http://www.yongjiuzy.vip");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.yongjiuzy.vip/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<tr class=\"DianDian\"[\\s\\S]*?</tr>");
        ruleModel.setRuleResultTitle("<td class=\"l\"><a href=\".*?\" target=\"_blank\">(.*?)</font>");
        ruleModel.setRuleResultLinkHeader("http://www.yongjiuzy.vip");
        ruleModel.setRuleResultLink("<td class=\"l\"><a href=\"(.*?)\"");
        ruleModel.setRuleResultType("<td><a href=\".*?\" target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultTime("(\\d{4}-\\d{2}-\\d{2})");

        ruleModel.setRuleDetailCover("<img src=\"(.*?)\"/>");
        ruleModel.setRuleDetailDesc("<!--简介开始-->(.*?)<!--简介结束-->");
        ruleModel.setRuleDetailListM3u8("<!--前yjm3u8-->[\\s\\S]*?<!--后yjm3u8-->");
        ruleModel.setRuleDetailListShare("<!--前yjyun-->[\\s\\S]*?<!--后yjyun-->");
        ruleModel.setRuleDetailMain("<li><input type=\"checkbox\".*?\\$.*?</li>");
        ruleModel.setRuleDetailTitle("value=\"(.*?)\\$");
        ruleModel.setRuleDetailLink("value=\".*?\\$(.*?)\"");
        ruleModel.setBlockWords(Arrays.asList("伦理片","嫩妹写真"));
        return ruleModel;
    }

    public static BaseRuleModel build158Model(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("158资源网");
        ruleModel.setVersion("2019.12.09");
        ruleModel.setBaseUrl("http://www.158zyz.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://www.158zyz.com/index.php?m=vod-search-pg-%page-wd-%keyWords.html");
        ruleModel.setRuleResultList("<li>.*?xing_vb4.*?</li>");
        ruleModel.setRuleResultTitle("target=\"_blank\">(.*?)</a>");
        ruleModel.setRuleResultLinkHeader("http://www.158zyz.com");
        ruleModel.setRuleResultLink("<a href=\"(.*?)\"");
        ruleModel.setRuleResultType("xing_vb5\">(.*?)</span>");
        ruleModel.setRuleResultTime("xing_vb6\">(.*?)</span>");

        ruleModel.setRuleDetailCover("<img class=\"lazy\" src=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("<!--介绍开始-->(.*?)<!--介绍结束-->");
        ruleModel.setRuleDetailListM3u8("<div id=\"play_1\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailListShare("<div id=\"play_2\">[\\s\\S]*?</ul>");
        ruleModel.setRuleDetailMain("<li><input type=\"checkbox\"[\\s\\S]*?</li>");
        ruleModel.setRuleDetailTitle("<a title='(.*?)'");
        ruleModel.setRuleDetailLink("href='(.*?)'");
        ruleModel.setBlockWords(Arrays.asList("伦理片","嫩妹写真"));
        return ruleModel;
    }



    public static BaseRuleModel buildAiMeiJuModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("爱美剧");
        ruleModel.setVersion("2019.12.26");
        ruleModel.setBaseUrl("http://mjapp.mjomj.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("http://mjapp.mjomj.com/index.php/app/ios/vod/index?size=20&page=%page&key=%keyWords");
        ruleModel.setRuleResultList("\\{\"id\"[\\s\\S]*?\\}");
        ruleModel.setRuleResultTitle("\"name\":\"([\\s\\S]*?)\"");
        ruleModel.setRuleResultLinkHeader("http://mjapp.mjomj.com/index.php/app/ios/vod/show?token=&id=");
        ruleModel.setRuleResultLink("\"id\":\"(.*?)\"");
        ruleModel.setRuleResultType("\"type\":\"(.*?)\"");
        ruleModel.setRuleResultTime("\"info\":\"(.*?)\"");
        ruleModel.setRuleDetailCover("\"name\":\".*?\",\"pic\":\"(.*?)\"");
        ruleModel.setRuleDetailDesc("\"text\":\"([\\s\\S]*?)\"");
        ruleModel.setRuleDetailListM3u8("\"ji\":\\[[\\s\\S]*?\\]\\}\\]");
        ruleModel.setRuleDetailMain("\\{\"id\":.*?\"\\}");
        ruleModel.setRuleDetailTitle("\"name\":\"(.*?)\"");
        ruleModel.setRuleDetailLink("\"purl\":\"(.*?)\"");

        ruleModel.setBlockWords(Arrays.asList("伦理","情色","会员"));
        return ruleModel;
    }


    public static BaseRuleModel buildWaiJuWangModel(){
        BaseRuleModel ruleModel = new BaseRuleModel();
        ruleModel.setName("外剧网");
        ruleModel.setVersion("2019.12.28");
        ruleModel.setBaseUrl("https://www.waijutv.com");
        ruleModel.setReqCharset("utf-8");
        ruleModel.setHtmlCharset("utf-8");
        ruleModel.setSearchUrl("https://www.waijutv.com/index.php/vod/search/page/%page/wd/%keyWords/");
        ruleModel.setRuleResultList("<li class=\"bottom-line active clearfix\">[\\s\\S]*?</li>");
        ruleModel.setRuleResultTitle("title=\"(.*?)\"");
        ruleModel.setRuleResultLinkHeader("https://www.waijutv.com");
        ruleModel.setRuleResultLink("href=\"(.*?)\"");
        ruleModel.setRuleResultType("类型：(.*?)<span");
        ruleModel.setRuleResultTime("年份：(.*?)<span");
        ruleModel.setRuleDetailCover("<img class=\"lazyload\".*?data-original=\"(.*?)\"");
        ruleModel.setRuleDetailDesc("<span id=\"cText\" class=\"macplus-cText\">(.*?)</span>");
        ruleModel.setRuleDetailListSniff("<ul class=\"macplus-content__playlist[\\s\\S]*?</ul>");
        ruleModel.setRuleSniffPattern("https://www.fenglinqiao.com/.*?index.m3u8?sign=.*?");
        ruleModel.setRuleDetailMain("<li><a href=\".*?\">.*?</a></li>");
        ruleModel.setRuleDetailTitle(">(.*?)</a>");
        ruleModel.setRuleDetailLink("<a href=\"(.*?)\">");
        ruleModel.setRuleDetailLinkHeader("https://www.waijutv.com");
        return ruleModel;
    }

}
