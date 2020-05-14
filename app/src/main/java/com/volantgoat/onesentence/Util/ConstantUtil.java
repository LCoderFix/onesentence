package com.volantgoat.onesentence.Util;

/**
 * Create by dong
 * Date on 2020/5/12  16:43
 */
public class ConstantUtil {
    /**
     * 用户获取验证码
     * Route::get('api/v1/code/:time/:token/:username/:is_exist','api/v1.code/get_code');
     */
    public static final String getCodeUrl="https://volantgoat.cn/api/v1/code/";

    /**
     * 用户登录
     * Route::post('api/v1/user/login','api/v1.user/login')
     */
    public static final String pwdLoginUrl="https://volantgoat.cn/api/v1/user/login";
}
