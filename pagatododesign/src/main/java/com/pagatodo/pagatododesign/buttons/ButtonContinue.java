package com.pagatodo.pagatododesign.buttons;

import android.content.Context;
import android.graphics.Color;
import androidx.appcompat.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.pagatodo.pagatododesign.R;

public class ButtonContinue extends AppCompatButton {

    public ButtonContinue(Context context) {
        super(context);
        init();
    }

    public ButtonContinue(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonContinue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.inactive();
        this.setTextColor(Color.parseColor("#FFFFFF"));
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        this.setAllCaps(false);
    }

    public void active(){
        this.setBackgroundResource(R.drawable.backgraund_button_active);
        this.setEnabled(true);
    }

    public void inactive(){
        this.setBackgroundResource(R.drawable.backgraund_button_inactive);
        this.setEnabled(false);
    }
}
