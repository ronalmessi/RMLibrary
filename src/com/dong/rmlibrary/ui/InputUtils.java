package com.dong.rmlibrary.ui;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class InputUtils {
	public static void showInput(EditText editText) {
		InputMethodManager inputManager = (InputMethodManager) editText
				.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.showSoftInput(editText, 0);
	}

	public static void hideInput(EditText editText) {
		InputMethodManager inputManager = (InputMethodManager) editText
				.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
	}

	public static void hideInput(Activity activity) {
		InputMethodManager inputManager = (InputMethodManager) activity
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		inputManager.hideSoftInputFromWindow(activity.getCurrentFocus()
				.getApplicationWindowToken(),
				InputMethodManager.HIDE_NOT_ALWAYS);
	}

}
