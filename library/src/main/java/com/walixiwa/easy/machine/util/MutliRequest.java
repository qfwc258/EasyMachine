package com.walixiwa.easy.machine.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * 多线程网络请求队列
 */
public class MutliRequest {
    private String url;
    private String userAgent;
    private String charset;
    private long timeOut = 10L;
    private CallBack callBack;

    private Map<String, String> params = new HashMap<>();
    private Handler handler = new Handler(Looper.getMainLooper());

    public MutliRequest setUrl(String url) {
        this.url = url;
        Log.e("info", "setUrl: " + url);
        return this;
    }

    public MutliRequest setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public MutliRequest setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public MutliRequest param(String key, String value) {
        try {
            value = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20");
            this.params.put(key, value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MutliRequest setCallBack(CallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    public MutliRequest setTimeOut(long timeOut) {
        this.timeOut = timeOut;
        return this;
    }

    public void start() {
        StringBuilder stringBuilder = new StringBuilder(url);
        for (String key : params.keySet()) {
            if (url.contains("?")) {
                stringBuilder.append("?").append(key).append(params.get(key));
            } else {
                stringBuilder.append("&").append(key).append(params.get(key));
            }
        }
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        Request.Builder builder = new Request.Builder();
        if (!TextUtils.isEmpty(userAgent)) {
            builder.removeHeader("User-Agent").addHeader("User-Agent", userAgent);
        }
        builder.url(stringBuilder.toString());
        okHttpClient.connectTimeout(timeOut, TimeUnit.SECONDS);
        okHttpClient.readTimeout(timeOut, TimeUnit.SECONDS);
        okHttpClient.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;//关闭ssl校验
            }
        });
        Call call = okHttpClient.build().newCall(builder.build());

        //1.异步请求，通过接口回调告知用户 http 的异步执行结果
        call.enqueue(new Callback() {

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                onFail(callBack, e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull okhttp3.Response response) {
                if (response.isSuccessful()) {
                    try {
                        ResponseBody responseBody = response.body();
                        if (responseBody != null) {
                            byte[] bytes = responseBody.bytes();
                            String result = new String(bytes, TextUtils.isEmpty(charset) ? "utf-8" : charset);
                            onSuccess(callBack, result);
                        } else {
                            onFail(callBack, "请求返回内容为空");
                        }
                    } catch (IOException e) {
                        onFail(callBack, "发生未知异常");
                    }
                } else {
                    onFail(callBack, "请求失败");
                }
            }

        });
    }

    private void onSuccess(final CallBack callBack, final String body) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onSuccess(body);
                }
            }
        });
    }

    private void onFail(final CallBack callBack, final String body) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack != null) {
                    callBack.onFail(body);
                }
            }
        });
    }

    public interface CallBack {
        void onSuccess(String response);

        void onFail(String fail);
    }
}
