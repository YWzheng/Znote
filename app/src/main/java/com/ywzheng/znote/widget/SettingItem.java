package com.ywzheng.znote.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ywzheng.znote.R;


/**
 * Created by zhen on 2016/8/23.
 */
public class SettingItem extends RelativeLayout {

    //left icon
    private Drawable mImg;

    //text
    private String mText;

    //textcolor
    private int mTextColor;

    //textsize
    private float mTextSize;

    //itme background
    private int mBackgroud;

    //right
    private Drawable mArrowRes;
    //root
    private RelativeLayout mRootView;

    //img -icon
    private ImageView mImageView;

    //arrow
    private ImageView mArrow;

    //text-img
    private TextView mTextView;

    public SettingItem(Context context) {
        super(context);
    }

    public SettingItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRootView = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.setting_item_layout, this);
        initView(context);
        initAttrs(context, attrs);
    }

    /**
     * get Attrs
     *
     * @param context
     * @param attrs
     */
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SettingItem);

        int mImgResid = a.getResourceId(R.styleable.SettingItem_img_item, 0);
        int mArrowResid = a.getResourceId(R.styleable.SettingItem_arrow_item, 0);
        int mTextResid = a.getResourceId(R.styleable.SettingItem_text_item, 0);
        int mTextColorResid = a.getResourceId(R.styleable.SettingItem_textcolor_item, 0);
        int mTextSizeResid = a.getResourceId(R.styleable.SettingItem_textsize_item, 0);
        int mBackgroundResid = a.getResourceId(R.styleable.SettingItem_background_item, 0);

        if (mImgResid != 0) {
            mImg = context.getResources().getDrawable(mImgResid);
        }

        if (mTextResid != 0) {
            mText = context.getResources().getString(mTextResid);
        }

        if (mTextColorResid != 0) {
            mTextColor = context.getResources().getColor(mTextColorResid);
        }

        if (mTextSizeResid != 0) {
            mTextSize = context.getResources().getDimension(mTextSizeResid);
        }

        if (mArrowResid != 0) {
            mArrowRes = context.getResources().getDrawable(mArrowResid);
        }

        if (mBackgroundResid != 0) {
            mBackgroud = context.getResources().getColor(mBackgroundResid);
        }

        a.recycle();

        //设置文字(内容、颜色、大小)
        mTextView.setText(mText);
        mTextView.setTextColor(mTextColor);
        mTextView.setTextSize(mTextSize);

        //设置图片
        mImageView.setBackground(mImg);
        mArrow.setBackground(mArrowRes);
        setBackgroundColor(mBackgroud);
    }

    /**
     * init views
     *
     * @param context
     */
    private void initView(Context context) {
        mImageView = (ImageView) mRootView.findViewById(R.id.image);
        mArrow = (ImageView) mRootView.findViewById(R.id.icon);
        mTextView = (TextView) mRootView.findViewById(R.id.text);
    }
}
