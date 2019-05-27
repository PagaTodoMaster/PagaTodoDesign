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
}
