package com.volantgoat.onesentence.Controller;

import android.content.Context;

import com.volantgoat.onesentence.Base.BaseController;
import com.volantgoat.onesentence.Bean.TelInterval;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by dong
 * Date on 2020/5/12  19:13
 */
public class UserController extends BaseController {
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
}
