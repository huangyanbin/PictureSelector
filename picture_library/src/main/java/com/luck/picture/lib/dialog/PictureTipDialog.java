package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.luck.picture.lib.R;
import com.luck.picture.lib.tools.ScreenUtils;

public class PictureTipDialog extends FrameLayout {

    private Context mContext;
    private Dialog mDialog;
    private View mTvOk;
    private TextView mTvTip;

    public PictureTipDialog(@NonNull Context context) {
        this(context, null);
    }

    public PictureTipDialog(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PictureTipDialog(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }


    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.dialog_picture_tip, this);
        mDialog = new Dialog(mContext, R.style.Theme_dialog);
        mDialog.setContentView(this);
        mDialog.setCancelable(true);
        mTvOk = findViewById(R.id.tv_ok);
        mTvTip = findViewById(R.id.tv_tip);
        LinearLayout llRoot = findViewById(R.id.ll_root);
        int screenWidth = (int) (ScreenUtils.getScreenWidth(mContext) * 0.8f);
        llRoot.setLayoutParams(new LayoutParams(screenWidth, LayoutParams.WRAP_CONTENT));

        mTvOk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDialog.isShowing()) {
                    mDialog.dismiss();
                }
            }
        });

    }

    public PictureTipDialog setTip(String tip) {
        mTvTip.setText(tip);
        return this;
    }

    public void show() {
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }


}
