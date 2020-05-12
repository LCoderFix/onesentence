package com.volantgoat.onesentence.Base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.volantgoat.onesentence.R;

/**
 * Create by dong
 * Date on 2020/5/11  12:02
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    public abstract int getLayoutId();
    public abstract void initViews();

    public abstract void initListener();
    public abstract void initData();
    public abstract void processClick(View v);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViews();
        initListener();
        initData();
    }

    /**
     * 封装setOnClickListener
     * @param v
     */
    public void setOnClick(View v){
        v.setOnClickListener(this);
    }
    /**
     * 设置标题栏标题
     * @param titleName
     */
    public void setTitle(String titleName){
        TextView tv_title= findViewById(R.id.tv_title);
        tv_title.setText(titleName);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.iv_finish)
            finish();
        else
            processClick(v);
    }

    /**
     * 开启界面
     * @param cls
     */
    public void startActivity(Class cls){
        Intent intent=new Intent(this,cls);
        startActivity(intent);
    }

    public void setTitleCanBack(){
        ImageView iv_finish=findViewById(R.id.iv_finish);
        iv_finish.setVisibility(View.VISIBLE);
        setOnClick(iv_finish);

    }
}
