package com.mobile.vnews.util;

import android.content.Context;

import com.mobile.vnews.R;
import com.mobile.vnews.view.CustomProgressDialog;

/**
 * Created by xuantang on 11/30/17.
 */

public class CommonDialogUtils {

    //  加载进度的dialog
    private CustomProgressDialog mProgressDialog;

    /**
     * 显示ProgressDialog
     */
    public void showProgress(Context context, String msg) {
       /* if (context == null || context.isFinishing()) {
            return;
        }*/
        if(mProgressDialog==null){
            mProgressDialog= new CustomProgressDialog.Builder(context)
                    .setTheme(R.style.ProgressDialogStyle)
                    .setMessage(msg)
                    .build();
        }
        if(mProgressDialog!=null&&!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * 显示ProgressDialog
     */
    public void showProgress(Context context) {
        /*if (activity == null || activity.isFinishing()) {
            return;
        }*/
        if(mProgressDialog==null){
            mProgressDialog= new CustomProgressDialog.Builder(context)
                    .setTheme(R.style.ProgressDialogStyle)
                    .build();
        }
        if(mProgressDialog!=null&&!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * 取消ProgressDialog
     */
    public void dismissProgress() {
        if (mProgressDialog != null&&mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
