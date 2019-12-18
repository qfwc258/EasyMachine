package com.walixiwa.easy.machine;

import android.text.TextUtils;

import com.walixiwa.easy.machine.model.BaseParseModel;
import com.walixiwa.easy.machine.util.MultiRequest;
import com.walixiwa.easy.machine.util.NativeDecoder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NeedParser {
    private OnParseFinishListener onParseFinishListener;
    private BaseParseModel parseModel;
    private String url;

    public NeedParser(BaseParseModel parseModel) {
        this.parseModel = parseModel;
    }

    public NeedParser with(String id) {
        this.url = parseModel.getParseHeader().replace("%id", id);
        return this;
    }

    public NeedParser setOnParseFinishListener(OnParseFinishListener onParseFinishListener) {
        this.onParseFinishListener = onParseFinishListener;
        return this;
    }

    public void start() {
        MultiRequest request = new MultiRequest();
        request.setUrl(url);
        request.setCallBack(new MultiRequest.CallBack() {
            @Override
            public void onSuccess(final String response) {
                String playUrl = matchString(response, parseModel.getRulePlayUrl());
                if (onParseFinishListener != null) {
                    if (!TextUtils.isEmpty(playUrl)) {
                        onParseFinishListener.onSuccess(playUrl);
                    } else {
                        onParseFinishListener.onFail("未匹配到播放地址");
                    }
                }
            }

            @Override
            public void onFail(String fail) {
                if (onParseFinishListener != null) {
                    onParseFinishListener.onFail(fail);
                }
            }
        });
        request.start();
    }


    public interface OnParseFinishListener {
        void onSuccess(String url);

        void onFail(String message);
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
        result = result == null ? "" : result.replaceAll("<.*?>", "").replaceAll("&nbsp;", "").trim();
        return NativeDecoder.decode(result);
    }
}
