package com.walixiwa.easy.machine;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.walixiwa.easy.machine.model.BaseResultModel;
import com.walixiwa.easy.machine.model.BaseRuleModel;
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

import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 搜索引擎
 */
public class Searcher {
    private BaseRuleModel ruleModel;
    private String keyWords;
    private int page = 1;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Callback callback;
    private List<BaseResultModel> resultModels = new ArrayList<>();
    private List<String> blockWords = new ArrayList<>();
    private static final String TAG = "Searcher";

    public Searcher(BaseRuleModel ruleModel) {
        this.ruleModel = ruleModel;
    }

    public Searcher with(String keyWords, int page) {
        //设置请求编码
        String reqCharset = TextUtils.isEmpty(ruleModel.getReqCharset()) ? "utf-8" : ruleModel.getReqCharset();
        this.keyWords = urlEncode(keyWords.trim(), reqCharset);
        this.page = page;
        return this;
    }

    public Searcher setCallback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public Searcher addBlockWords(List<String> blockWords) {
        this.blockWords.addAll(blockWords);
        return this;
    }

    public Searcher addBlockWord(String blockWord) {
        this.blockWords.add(blockWord);
        return this;
    }

    public void start() {
        String url = this.ruleModel.getSearchUrl().replace("%keyWords", this.keyWords).replace("%page", Integer.toString(this.page));

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
                Log.e(TAG, "onStart: " + ruleModel.getName());
                if (callback != null) {
                    callback.onStart();
                }
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
                    if (callback != null) {
                        callback.onFail("请求失败");
                    }
                    Log.e(TAG, "onFail: " + ruleModel.getName() + " -> " + response.failed());
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
                Log.e(TAG, "onException: " + ruleModel.getName() + " -> " + message);
                if (callback != null) {
                    callback.onFail(message);
                }
            }


            @Override
            public void onEnd() {
                super.onEnd();
                Log.e(TAG, "onEnd: " + ruleModel.getName());
                if (callback != null) {
                    callback.onEnd();
                }
            }
        });
    }

    /**
     * 开始匹配资源
     *
     * @param html
     */
    private void parseSource(String html) {
        Pattern pattern = Pattern.compile(this.ruleModel.getRuleResultList(), Pattern.CASE_INSENSITIVE);//匹配整条链接
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            BaseResultModel resultModel = new BaseResultModel();
            resultModel.setBaseRuleModel(this.ruleModel);
            String resultList = matcher.group(); //匹配整条链接结果
            List<String> blockList = this.ruleModel.getBlockWords();//过滤排除掉的分类
            boolean blocked = false;
            //屏蔽指定引擎的block关键词
            if (blockList != null) {
                for (String name : blockList) {
                    if (resultList.contains(name)) {
                        blocked = true;
                    }
                }
            }
            //屏蔽总block关键词
            for (String name : blockWords) {
                if (resultList.contains(name)) {
                    blocked = true;
                }
            }
            if (!blocked) {
                resultModel.setResultTitle(matchString(resultList, this.ruleModel.getRuleResultTitle()));
                String linkHeader = this.ruleModel.getRuleResultLinkHeader();
                String link = matchString(resultList, this.ruleModel.getRuleResultLink());
                link = TextUtils.isEmpty(linkHeader) ? link : linkHeader + link;
                resultModel.setResultLink(link);
                resultModel.setResultTime(matchString(resultList, this.ruleModel.getRuleResultTime()));
                resultModel.setResultType(matchString(resultList, this.ruleModel.getRuleResultType()));
                resultModels.add(resultModel);
            }
        }
        if (callback != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onResult(resultModels);
                }
            });
        }
    }


    public interface Callback {
        void onStart();

        void onResult(List<BaseResultModel> results);

        void onFail(String message);

        void onEnd();
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

    /**
     * url文本编码，解决空格编码异常问题
     *
     * @param str
     * @return
     */
    private static String urlEncode(String str, String enc) {
        String wd = null;
        try {
            wd = URLEncoder.encode(str, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return wd == null ? str : wd.replace("+", "%20");
    }
}
