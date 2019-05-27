package com.pagatodo.pagatododesign.spinners;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.pagatodo.pagatododesign.R;

public class SpinerYg extends LinearLayout {

    private TextView textHint;
    private Spinner spinner;
    private ConstraintLayout layout;
    private int dimenMargin;

    public SpinerYg(Context context) {
        super(context);
        init(null);
    }

    public SpinerYg(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public SpinerYg(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View viewItem = inflater.inflate(R.layout.spinner_yg,this,false);
        textHint = viewItem.findViewById(R.id.texthint);
        spinner = viewItem.findViewById(R.id.spinner_yg);
        layout = viewItem.findViewById(R.id.root_layout);

        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.SpinerYg,
                    0, 0);
            try {

                String resTextHint = a.getString(R.styleable.SpinerYg_textHintSpinner);
                textHint.setText(resTextHint);
                textHint.setVisibility(VISIBLE);
                dimenMargin = a.getDimensionPixelSize(R.styleable.SpinerYg_marigTextHint, 5);
                setMarginText(dimenMargin);

            } finally {
                a.recycle();
            }
        }
        this.addView(viewItem);
    }

    public ConstraintLayout getLayout() {
        return layout;
    }

    public TextView getTextHint() {
        return textHint;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    private int dp(int px){
        float scale = textHint.getResources().getDisplayMetrics().density;
        return (int) (scale * px + 0.5f);
    }

    public void setMarginText(int dimenMargin){
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        llp.setMargins(dp(dimenMargin),0,0,0);
        textHint.setLayoutParams(llp);
    }
    /*
    * TextView forgot_pswrd = (TextView) findViewById(R.id.ForgotPasswordText);
forgot_pswrd.setOnTouchListener(this);
LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
llp.setMargins(50, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
forgot_pswrd.setLayoutParams(llp);*/
}
