package com.volantgoat.onesentence.Base;

import com.volantgoat.onesentence.Bean.TelInterval;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Create by dong
 * Date on 2020/5/12  19:11
 */
public class BaseController {
    /**
     * 用户事件回调
     */
    public interface OnUserListener{
        void onTelIntervalData(List<TelInterval> list);
        void onCodeSuccess(int code);
    }
    /**
     * OkHttp回调
     */
    public interface ResultCallBack{
        void onResponse(Call call, String response) throws JSONException;
        void onError(Call call, IOException e);
    }
}
