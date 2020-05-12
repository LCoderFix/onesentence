package com.volantgoat.onesentence.Base;

import com.volantgoat.onesentence.Bean.TelInterval;

import java.util.List;

/**
 * Create by dong
 * Date on 2020/5/12  19:11
 */
public class BaseController {
    public interface OnUserListener{
        void onTelIntervalData(List<TelInterval> list);
    }

}
