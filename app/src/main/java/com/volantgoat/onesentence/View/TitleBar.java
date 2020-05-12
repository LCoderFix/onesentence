package com.volantgoat.onesentence.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.volantgoat.onesentence.R;

/**
 * Create by dong
 * Date on 2020/5/12  15:29
 */
public class TitleBar  extends RelativeLayout {

    private ImageView iv_tttlebar_left;
    private TextView tv_titlebar_title;
    private TextView tv_titlebar_right;
    private RelativeLayout layout_titlebar_rootlayout;

    private int mColor= Color.WHITE;
    private int mTextColor=Color.BLACK;
    private String titleName="";
    public TitleBar(Context context) {
        super(context);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypeArray=context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
        mColor=mTypeArray.getColor(R.styleable.TitleBar_title_bg,Color.WHITE);
        mTextColor=mTypeArray.getColor(R.styleable.TitleBar_title_text_color,Color.BLACK);
        titleName=mTypeArray.getString(R.styleable.TitleBar_title_text);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    public void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.common_header,this,true);
        iv_tttlebar_left=findViewById(R.id.iv_finish);
        tv_titlebar_title=findViewById(R.id.tv_title);
        tv_titlebar_right=findViewById(R.id.tv_edit);
        layout_titlebar_rootlayout=findViewById(R.id.layout_common_header_rootlayout);
        layout_titlebar_rootlayout.setBackgroundColor(mColor);//设置背景颜色
        tv_titlebar_title.setTextColor(mTextColor);//设置标题文字颜色
        tv_titlebar_title.setText(titleName);//设置标题文字
    }
    public void setTitle(String titleName){
        if(!TextUtils.isEmpty(titleName)){
            tv_titlebar_title.setText(titleName);
        }
    }
    public void setLeftListener(OnClickListener listener){
        iv_tttlebar_left.setOnClickListener(listener);
    }
    public void setRightListener(OnClickListener listener){
        tv_titlebar_right.setOnClickListener(listener);
    }
}
