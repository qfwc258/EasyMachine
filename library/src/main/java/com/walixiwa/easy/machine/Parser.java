package com.walixiwa.easy.machine;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.walixiwa.easy.machine.model.BaseDetailModel;
import com.walixiwa.easy.machine.model.BaseRuleModel;
import com.walixiwa.easy.machine.model.BaseVodModel;
import com.walixiwa.easy.machine.util.MutliRequest;
import com.walixiwa.easy.machine.util.NativeDecoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 详情页信息解析
 */
public class Parser {
    private String url;
    private BaseRuleModel ruleModel;
    private BaseDetailModel resultModel = new BaseDetailModel();
    private Handler handler = new Handler(Looper.getMainLooper());
    private CallBack callBack;
    private static final String TAG = "Parser";

    public Parser(BaseRuleModel ruleModel) {
        this.ruleModel = ruleModel;
    }

    public Parser with(String url) {
        this.url = url;
        return this;
    }

    public Parser setCallBack(CallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    public void start() {
        //设置返回编码
        MutliRequest request = new MutliRequest();
        request.setUrl(url);
        if (!TextUtils.isEmpty(this.ruleModel.getHtmlCharset())) {
            request.setCharset(this.ruleModel.getHtmlCharset());
        }
        if (!TextUtils.isEmpty(this.ruleModel.getUserAgent())) {
            request.setUserAgent(this.ruleModel.getUserAgent());
        }
        request.setCallBack(new MutliRequest.CallBack() {
            @Override
            public void onSuccess(final String response) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        parseSource(response);
                    }
                }).start();
            }

            @Override
            public void onFail(String fail) {
                if(callBack!=null){
                    callBack.onFail(fail);
                }
            }
        });
        request.start();
    }

    private void parseSource(String html) {
        String cover = matchString(html, ruleModel.getRuleDetailCover());
        cover = TextUtils.isEmpty(ruleModel.getRuleDetailCoverHeader()) ? cover : ruleModel.getRuleDetailCoverHeader() + cover;
        resultModel.setCover(cover);
        resultModel.setDescription(matchString(html, ruleModel.getRuleDetailDesc()));
        //匹配m3u8的链接结果
        Pattern m3u8Pattern = Pattern.compile(ruleModel.getRuleDetailListM3u8(), Pattern.CASE_INSENSITIVE);
        Matcher m3u8Matcher = m3u8Pattern.matcher(html);
        while (m3u8Matcher.find()) {
            String m3u8 = m3u8Matcher.group();
            Pattern linkPattern = Pattern.compile(ruleModel.getRuleDetailMain(), Pattern.CASE_INSENSITIVE);
            Matcher linkMatcher = linkPattern.matcher(m3u8);
            while (linkMatcher.find()) {
                String find = linkMatcher.group();
                String title = matchString(find, ruleModel.getRuleDetailTitle());
                String link = matchString(find, ruleModel.getRuleDetailLink());
                resultModel.getM3u8List().add(new BaseVodModel(title, link));
            }
        }
        //匹配分享share的链接结果
        Pattern sharePattern = Pattern.compile(ruleModel.getRuleDetailListShare(), Pattern.CASE_INSENSITIVE);
        Matcher shareMatcher = sharePattern.matcher(html);
        while (shareMatcher.find()) {
            String share = shareMatcher.group();
            Pattern linkPattern = Pattern.compile(ruleModel.getRuleDetailMain(), Pattern.CASE_INSENSITIVE);
            Matcher linkMatcher = linkPattern.matcher(share);
            while (linkMatcher.find()) {
                String find = linkMatcher.group();
                String title = matchString(find, ruleModel.getRuleDetailTitle());
                String link = matchString(find, ruleModel.getRuleDetailLink());
                resultModel.getShareList().add(new BaseVodModel(title, link));
            }
        }
        //匹配下载down的链接结果
        Pattern downPattern = Pattern.compile(ruleModel.getRuleDetailDownList(), Pattern.CASE_INSENSITIVE);
        Matcher downMatcher = downPattern.matcher(html);
        while (downMatcher.find()) {
            String down = downMatcher.group();
            Pattern linkPattern = Pattern.compile(ruleModel.getRuleDetailMain(), Pattern.CASE_INSENSITIVE);
            Matcher linkMatcher = linkPattern.matcher(down);
            while (linkMatcher.find()) {
                String find = linkMatcher.group();
                String title = matchString(find, ruleModel.getRuleDetailTitle());
                String link = matchString(find, ruleModel.getRuleDetailLink());
                resultModel.getDownList().add(new BaseVodModel(title, link));
            }
        }
        if (callBack != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.onSuccess(resultModel);
                }
            });
        }

    }

    public interface CallBack {
        void onSuccess(BaseDetailModel resultModel);

        void onFail(String msg);
    }

    /**
     * 根据单个正则规则，默认返回第一个匹配项
     *
     * @param value
     * @param regex
     * @return
     */
    private String matchString(String value, String regex) {
        if (TextUtils.isEmpty(regex)) {
            return "";
        }
        String result = "";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            result = matcher.group(1);
        }
        result = result == null ? "" : result.replaceAll("<.*?>", "").trim();
        return NativeDecoder.decode(result);
    }


}
