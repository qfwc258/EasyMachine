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
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
 * 多线程网络请求队列
 */
public class MultiRequest {
    private String url;
    private String userAgent;
    private String charset;
    private long timeOut = 10L;
    private CallBack callBack;

    private Map<String, String> params = new HashMap<>();
    private Handler handler = new Handler(Looper.getMainLooper());

    public MultiRequest setUrl(String url) {
        this.url = url;
        Log.e("info", "setUrl: " + url);
        return this;
    }

    public MultiRequest setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public MultiRequest setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public MultiRequest param(String key, String value) {
        try {
            value = URLEncoder.encode(value, "utf-8").replaceAll("\\+", "%20");
            this.params.put(key, value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MultiRequest setCallBack(CallBack callBack) {
        this.callBack = callBack;
        return this;
    }

    public MultiRequest setTimeOut(long timeOut) {
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
        OkHttpClient.Builder okHttpClient = getUnsafeOkHttpClient().newBuilder();
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
                            onFail(callBack, "返回内容为空");
                        }
                    } catch (IOException e) {
                        onFail(callBack, e.toString());
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


    //okHttp3添加信任所有证书

    private static OkHttpClient getUnsafeOkHttpClient() {

        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);

            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
