package com.example.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by wuguoqiang on 2017/3/2.
 */

public class WidgetTopBar extends RelativeLayout {

    private ImageView iv_Left;
    private ImageView iv_Right;
    private ImageView iv_Right2;
    private TextView tv_left;
    private TextView tv_title;
    private String leftText;
    private String title;
    private Drawable leftDrawable;
    private Drawable rightDrawable;
    private Drawable rightDrawable2;

    public WidgetTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化属性
        initAttrs(context, attrs);
        //填充视图
        View.inflate(context, R.layout.layout_topbar, this);
        iv_Left = (ImageView) findViewById(R.id.iv_Left);
        iv_Right = (ImageView) findViewById(R.id.iv_Right);
        iv_Right2 = (ImageView) findViewById(R.id.iv_Right2);
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_title = (TextView) findViewById(R.id.tv_title);

        //如果属性有值的话，那我们就需要给控件初始化数据了
        initData();
    }

    //初始化属性
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WidgetTopBar);
        //左边按钮的文字
        leftText = typedArray.getString(R.styleable.WidgetTopBar_m_left_text);
        //左边按钮的图片
        leftDrawable = typedArray.getDrawable(R.styleable.WidgetTopBar_m_left_image);
        //标题
        title = typedArray.getString(R.styleable.WidgetTopBar_m_title);
        //右边按钮的图片
        rightDrawable = typedArray.getDrawable(R.styleable.WidgetTopBar_m_right_image);
        //右边第二个按钮的图片
        rightDrawable2 = typedArray.getDrawable(R.styleable.WidgetTopBar_m_right_image2);
    }


    // 初始化数据,因为每个按钮，我都在布局文件中将其显示状态设置为GONE 了
    // 所以在填充数据的时候，要显示一下
    private void initData() {
        if (leftText != null) {
            tv_left.setVisibility(VISIBLE);
            tv_left.setText(leftText);
        }
        if (leftDrawable != null) {
            iv_Left.setVisibility(VISIBLE);
            iv_Left.setImageDrawable(leftDrawable);
        }
        if (title != null) {
            tv_title.setVisibility(VISIBLE);
            tv_title.setText(title);
        }
        if (rightDrawable != null) {
            iv_Right.setVisibility(VISIBLE);
            iv_Right.setImageDrawable(rightDrawable);
        }
        if (rightDrawable2 != null) {
            iv_Right2.setVisibility(VISIBLE);
            iv_Right2.setImageDrawable(rightDrawable2);
        }
    }

    //获取左边图片按钮
    public ImageView getLeftBtnImage() {
        return iv_Left;
    }

    //获取标题
    public TextView getTitile() {
        return tv_title;
    }

    //设置标题
    public void setTitle(String titie){
        tv_title.setText(titie);
    }

    //获取右边图片按钮
    public ImageView getRightBtnImage() {
        return iv_Right;
    }

    //获取右边第二个图片按钮
    public ImageView getRightBtnImage2() {
        return iv_Right2;
    }
}