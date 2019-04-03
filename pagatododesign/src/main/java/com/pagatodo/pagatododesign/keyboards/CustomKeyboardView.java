package com.pagatodo.pagatododesign.keyboards;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import androidx.core.content.ContextCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.pagatodo.pagatododesign.R;

import java.util.List;

public class CustomKeyboardView extends KeyboardView {

    public static int codeKey;
    Keyboard keyboard;
    Activity activity;
    public OnKeyboardActionListener keyboardActionListener = new OnKeyboardActionListener() {
        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            /**
             * Guardamos el codigo de la tecla que usamos en el CustomKeyboard
             */
            CustomKeyboardView.setCodeKey(primaryCode);
            long eventTime = 0;
            KeyEvent event = new KeyEvent(eventTime, eventTime, KeyEvent.ACTION_DOWN, primaryCode, 0, 0, 0, 0, KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE);
            activity.dispatchKeyEvent(event);
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeRight() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void swipeUp() {
        }
    };

    public CustomKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static int getCodeKey() {
        return codeKey;
    }

    public static void setCodeKey(int codeKey) {
        CustomKeyboardView.codeKey = codeKey;
    }

    public void setKeyBoard(Activity activity, int xmlLayoutResId) {
        this.activity = activity;
        keyboard = new Keyboard(activity, xmlLayoutResId);

        this.setKeyboard(keyboard);
        this.setOnKeyboardActionListener(keyboardActionListener);


    }

    public void hideCustomKeyboard() {
        this.setVisibility(View.GONE);
        this.setEnabled(false);
    }

    public void showCustomKeyboard(View v) {
        this.setVisibility(View.VISIBLE);
        this.setEnabled(true);
        if (v != null) {
            ((InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if (Build.VERSION.SDK_INT >= 23) {
            List<Keyboard.Key> keys = getKeyboard().getKeys();
            for (Keyboard.Key key : keys) {
                if (key.codes[0] == 1021) {
                    //Drawable dr = ContextCompat.getDrawable(getContext(), R.drawable.custom_key_point_selector); //new ColorDrawable(ContextCompat.getColor(getContext(), R.color.grayColor));
                    //dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    //dr.setState(key.getCurrentDrawableState());
                    //dr.draw(canvas);
                }
                if (key.codes[0] == 29) {
                    Drawable dr = ContextCompat.getDrawable(getContext(), R.drawable.custom_key_point_selector); //new ColorDrawable(ContextCompat.getColor(getContext(), R.color.grayColor));
                    dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    dr.setState(key.getCurrentDrawableState());
                    dr.draw(canvas);
                } else if (key.codes[0] == 67) {
                    Drawable dr = ContextCompat.getDrawable(getContext(), R.drawable.custom_key_back_selector); //new ColorDrawable(ContextCompat.getColor(getContext(), R.color.grayColor));
                    dr.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                    dr.setState(key.getCurrentDrawableState());
                    dr.draw(canvas);
                }
            }
        }
    }
}