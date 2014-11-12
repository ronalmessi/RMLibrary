package com.dong.rmlibrary.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

public class UIHelper {

	/**
	 * 显示一个toast
	 * 
	 * @param msg
	 */
	public static void toast(int resId) {
		toast(ResourceUtils.getStringById(resId));
	}

	/**
	 * 显示一个toast
	 * 
	 * @param msg
	 */
	public static void toast(String msg) {
		try {
			toast(RMActivityManager.getInstance().currentActivity(), msg);
		} catch (Exception e) {
		}
	}

	/**
	 * 长时间显示一个toast
	 * 
	 * @param msg
	 */
	public static void longToast(String msg) {
		try {
			longToast(RMActivityManager.getInstance().currentActivity(), msg);
		} catch (Exception e) {
		}
	}

	/**
	 * 长时间显示一个toast
	 * 
	 * @param msg
	 */
	public static void longToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	/**
	 * 显示一个toast
	 * 
	 * @param msg
	 */
	public static void toast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 返回一个退出确认对话框
	 */
	public void getExitDialog(final Context context) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage("确定退出吗？");
		builder.setCancelable(false);
		builder.setNegativeButton("取消", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				RMActivityManager.getInstance().AppExit(context);
			}
		});
		builder.create();
		builder.show();
		builder = null;
	}

	/**
	 * 返回一个等待信息弹窗
	 * 
	 * @param aty
	 *            要显示弹出窗的Activity
	 * @param msg
	 *            弹出窗上要显示的文字
	 * @param cancel
	 *            dialog是否可以被取消
	 */
	public static ProgressDialog getprogress(Activity aty, String msg,
			boolean cancel) {
		// 实例化一个ProgressBarDialog
		ProgressDialog progressDialog = new ProgressDialog(aty);
		progressDialog.setMessage(msg);
		progressDialog.getWindow().setLayout(DensityUtils.getScreenW(aty),
				DensityUtils.getScreenH(aty));
		progressDialog.setCancelable(cancel);
		// 设置ProgressBarDialog的显示样式
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.show();
		return progressDialog;
	}

	/**
	 * 用于创建PopupWindow封装一些公用属性
	 */
	private PopupWindow createWindow(View view, int w, int h, int argb) {
		PopupWindow popupView = new PopupWindow(view, w, h);
		popupView.setFocusable(true);
		popupView.setBackgroundDrawable(new ColorDrawable(argb));
		popupView.setOutsideTouchable(true);
		return popupView;
	}
}
