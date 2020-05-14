package com.volantgoat.onesentence.Util;

import android.content.Context;
import android.os.Handler;

import com.volantgoat.onesentence.Base.BaseController;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Create by dong
 * Date on 2020/5/14  21:26
 */
public class HttpEngine {
    private static volatile HttpEngine mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    public static HttpEngine getmInstance(Context context) {
        if (mInstance == null) {
            synchronized (HttpEngine.class) {
                if (mInstance == null) {
                    mInstance = new HttpEngine(context);
                }
            }
        }
        return mInstance;
    }

    private HttpEngine(Context context) {
        File sdcache = context.getExternalCacheDir();
        //设置最大缓存10M
        int cacheSize = 10 * 1024 * 1024;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize));
        mOkHttpClient = builder.build();
        mHandler = new Handler();
    }

    public void getAsynHttp(String url, BaseController.ResultCallBack callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        dealResult(call, callback);
    }

    private void dealResult(Call call, final BaseController.ResultCallBack callback) {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                sendFailedCallBack(call, e, callback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                sendSuccessCallBack(call, response, callback);
            }

            private void sendFailedCallBack(final Call call, final IOException e, final BaseController.ResultCallBack callback) {
                if(callback!=null){
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onError(call,e);
                        }
                    });
                }
            }

            private void sendSuccessCallBack(final Call call, final Response response, final BaseController.ResultCallBack callback) {
                if(callback!=null){
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                callback.onResponse(call,response.body().string());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
    }
}
