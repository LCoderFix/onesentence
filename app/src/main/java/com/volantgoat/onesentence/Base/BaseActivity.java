package com.volantgoat.onesentence.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Create by dong
 * Date on 2020/5/11  12:02
 */
public abstract class BaseActivity extends FragmentActivity {
    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }
}
