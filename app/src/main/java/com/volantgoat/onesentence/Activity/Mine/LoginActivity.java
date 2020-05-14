package com.volantgoat.onesentence.Activity.Mine;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.volantgoat.onesentence.Adapter.TelIntervalAdapter;
import com.volantgoat.onesentence.Base.BaseActivity;
import com.volantgoat.onesentence.Base.BaseController;
import com.volantgoat.onesentence.Bean.TelInterval;
import com.volantgoat.onesentence.Controller.UserController;
import com.volantgoat.onesentence.R;

import java.util.List;

/**
 * Create by dong
 * Date on 2020/5/12  14:43
 */
public class LoginActivity extends BaseActivity {
    public static final String TAG = "LoginActivity";
    private Spinner spinner;
    private UserController userController;
    private TextView tvLoginName;
    private TextView etUserName;
    private TextView etPassword;
    private TextView tvGetCode;
    private Button btnLogin;
    private TextView tvLoginMode;
    private TextView tvForgotPwd;
    private TelIntervalAdapter adapter;
    private LinearLayout spinnerLayout;

    /**
     * 初始化布局
     *
     * @return 资源ID
     */
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    /**
     * 初始化资源控件
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initViews() {
        userController = UserController.getInstance();
        spinner = findViewById(R.id.spinner);
        tvLoginName = findViewById(R.id.tv_login_textname);
        etUserName = findViewById(R.id.edit_text_username);
        etPassword = findViewById(R.id.edit_text_pwd);
        tvGetCode = findViewById(R.id.text_view_get_code);
        btnLogin = findViewById(R.id.btn_login);
        tvLoginMode = findViewById(R.id.text_view_login_mode);
        tvForgotPwd = findViewById(R.id.text_view_forget_pwd);
        spinnerLayout = findViewById(R.id.spinner_layout);
        userController.getTelIntervalData(new BaseController.OnUserListener() {
            @Override
            public void onTelIntervalData(List<TelInterval> list) {
                adapter = new TelIntervalAdapter(LoginActivity.this, list);
                spinner.setDropDownWidth(400);
                spinner.setDropDownHorizontalOffset(30);
                spinner.setDropDownVerticalOffset(100);
                spinner.setAdapter(adapter);
            }

            @Override
            public void onCodeSuccess(int code) {

            }
        });

    }

    @Override
    public void initListener() {
        setOnClick(tvGetCode);
        setOnClick(btnLogin);
        setOnClick(tvLoginMode);
        setOnClick(tvForgotPwd);
    }

    @Override
    public void initData() {
        setTitleCanBack();
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()){
            case R.id.text_view_get_code:
                userController.getCode(this, new BaseController.OnUserListener() {
                    @Override
                    public void onTelIntervalData(List<TelInterval> list) {

                    }

                    @Override
                    public void onCodeSuccess(int code) {
                        Log.i(TAG, "onCodeSuccess: "+code);
                    }
                });
                break;
            case R.id.text_view_login_mode:
                if(tvLoginMode.getText().toString().equals("免密登录")){
                    tvLoginName.setText("手机号登录");
                    tvLoginMode.setText("账号登录");
                    spinnerLayout.setVisibility(View.VISIBLE);
                    tvGetCode.setVisibility(View.VISIBLE);
                    tvForgotPwd.setVisibility(View.GONE);
                    etUserName.setHint("请输入手机号码");
                    etPassword.setHint("请输入手机验证码");
                }else {
                    tvLoginName.setText("账号登录");
                    tvLoginMode.setText("免密登录");
                    spinnerLayout.setVisibility(View.GONE);
                    tvGetCode.setVisibility(View.GONE);
                    tvForgotPwd.setVisibility(View.VISIBLE);
                    etUserName.setHint("邮箱/手机号");
                    etPassword.setHint("密码");

                }
                break;

            case R.id.text_view_forget_pwd:

                break;
        }
    }
}
