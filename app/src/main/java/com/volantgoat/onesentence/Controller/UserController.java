package com.volantgoat.onesentence.Controller;

import android.content.Context;
import android.util.Log;

import androidx.constraintlayout.widget.Constraints;

import com.google.gson.JsonObject;
import com.volantgoat.onesentence.Base.BaseController;
import com.volantgoat.onesentence.Bean.TelInterval;
import com.volantgoat.onesentence.Util.ConstantUtil;
import com.volantgoat.onesentence.Util.HttpEngine;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Create by dong
 * Date on 2020/5/12  19:13
 */
public class UserController extends BaseController {
    public static final String TAG=UserController.class.getSimpleName();
    private static volatile UserController instance;
    public static UserController getInstance() {
        if(instance==null){
            synchronized (UserController.class){
                if(instance==null){
                    instance=new UserController();
                }
            }
        }
        return instance;
    }


    public void getTelIntervalData(OnUserListener listener){
        List<TelInterval> list=new ArrayList<>();
        list.add(new TelInterval("86","中国大陆"));
        list.add(new TelInterval("1","美国"));
        list.add(new TelInterval("1","加拿大"));
        list.add(new TelInterval("852","中国香港"));
        list.add(new TelInterval("886","中国台湾"));
        list.add(new TelInterval("81","日本"));
        if(listener!=null)
            listener.onTelIntervalData(list);
    }
    public void getCode(Context context, final OnUserListener listener){
        String url=ConstantUtil.getCodeUrl+ new Date().getTime()+"/1/13849779372/0";
        HttpEngine.getmInstance(context).getAsynHttp(url, new ResultCallBack() {
            @Override
            public void onResponse(Call call, String response) throws JSONException {
                Log.i(TAG, "onResponse: "+response);
                JSONObject jsonObject=new JSONObject(response);
                Log.i(TAG, "onResponse: "+jsonObject);
                int code= (int) jsonObject.get("code");
                if(listener!=null){
                    listener.onCodeSuccess(code);
                }
            }

            @Override
            public void onError(Call call, IOException e) {

            }
        });
    }
}
