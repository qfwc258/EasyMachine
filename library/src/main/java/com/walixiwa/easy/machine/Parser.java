package com.walixiwa.easy.machine;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.walixiwa.easy.machine.model.BaseDetailModel;
import com.walixiwa.easy.machine.model.BaseResultModel;
import com.walixiwa.easy.machine.model.BaseRuleModel;
import com.walixiwa.easy.machine.model.BaseVodModel;
import com.walixiwa.easy.machine.util.NativeDecoder;
import com.yanzhenjie.kalle.Kalle;
import com.yanzhenjie.kalle.KalleConfig;
import com.yanzhenjie.kalle.exception.ConnectTimeoutError;
import com.yanzhenjie.kalle.exception.HostError;
import com.yanzhenjie.kalle.exception.NetworkError;
import com.yanzhenjie.kalle.exception.ParseError;
import com.yanzhenjie.kalle.exception.ReadTimeoutError;
import com.yanzhenjie.kalle.exception.URLError;
import com.yanzhenjie.kalle.exception.WriteException;
import com.yanzhenjie.kalle.simple.SimpleCallback;
import com.yanzhenjie.kalle.simple.SimpleResponse;
import com.yanzhenjie.kalle.simple.SimpleUrlRequest;

import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
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
        KalleConfig.Builder builder = KalleConfig.newBuilder();
        builder.proxy(Proxy.NO_PROXY);
        builder.connectionTimeout(5, TimeUnit.SECONDS);
        builder.readTimeout(5, TimeUnit.SECONDS);
        if (!TextUtils.isEmpty(this.ruleModel.getHtmlCharset())) {
            builder.charset(Charset.forName(this.ruleModel.getHtmlCharset()));
        }
        Kalle.setConfig(builder.build());

        SimpleUrlRequest.Api request = Kalle.get(url);
        if (!TextUtils.isEmpty(this.ruleModel.getUserAgent())) {
            request.removeHeader("User-Agent").addHeader("User-Agent", this.ruleModel.getUserAgent());
        }

        request.perform(new SimpleCallback<String>() {
            @Override
            public void onStart() {
                super.onStart();
                Log.e(TAG, "onStart: " + ruleModel.getName() + " -> " + url);
            }

            @Override
            public void onResponse(final SimpleResponse<String, String> response) {
                Log.e(TAG, "onResponse: " + ruleModel.getName());
                if (response.isSucceed()) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            parseSource(response.succeed());
                        }
                    }).start();
                } else {
                    Log.e(TAG, "onFail: " + ruleModel.getName() + " -> " + response.failed() + " -> " + url);
                }
            }

            @Override
            public void onException(Exception e) {
                super.onException(e);
                // 判断异常类型。
                String message;
                if (e instanceof NetworkError) {
                    message = "网络不可用";
                } else if (e instanceof URLError) {
                    message = "Url格式错误";
                } else if (e instanceof HostError) {
                    message = "没有找到Url指定服务器";
                } else if (e instanceof ConnectTimeoutError) {
                    message = "连接服务器超时，请重试";
                } else if (e instanceof WriteException) {
                    message = "发送数据错误，请检查网络";
                } else if (e instanceof ReadTimeoutError) {
                    message = "读取服务器数据超时，请检查网络";
                } else if (e instanceof ParseError) {
                    message = "解析数据时发生异常";
                } else {
                    message = "发生未知异常，请稍后重试";
                }
                Log.e(TAG, "onException: " + ruleModel.getName() + " -> " + message + " -> " + url);
            }


            @Override
            public void onEnd() {
                super.onEnd();
                Log.e(TAG, "onEnd: " + ruleModel.getName() + " -> " + url);
            }
        });
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
                resultModel.getShareList().add(new BaseVodModel(title, link));
            }
        }
        if (callBack != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.callBack(resultModel);
                }
            });
        }

    }

    public interface CallBack {
        void callBack(BaseDetailModel resultModel);
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
