package com.volantgoat.onesentence.Activity.Mine;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

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
    public static final String TAG="LoginActivity";
    private Spinner spinner;
    private UserController userController;
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initViews() {
        userController=UserController.getInstance();
        spinner=findViewById(R.id.spinner);

        userController.getTelIntervalData(new BaseController.OnUserListener() {
            @Override
            public void onTelIntervalData(List<TelInterval> list) {
                Log.i(TAG, "onTelIntervalData: "+list.size());
                TelIntervalAdapter adapter=new TelIntervalAdapter(LoginActivity.this,list);
                spinner.setDropDownWidth(400);
                spinner.setDropDownVerticalOffset(100);
                spinner.setAdapter(adapter);

            }
        });


    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        setTitleCanBack();
    }

    @Override
    public void processClick(View v) {

    }
}
