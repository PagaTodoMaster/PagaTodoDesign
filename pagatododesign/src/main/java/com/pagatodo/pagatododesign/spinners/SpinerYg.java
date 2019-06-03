package com.pagatodo.pagatododesign.spinners;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.pagatodo.pagatododesign.R;

public class SpinerYg extends LinearLayout implements AdapterView.OnItemSelectedListener, View.OnClickListener,
        View.OnTouchListener {

    private TextView texHintFilled;
    private Spinner spinner;
    private View rootView;
    private ConstraintLayout layout;
    private SpinnerListener listener;
    private BaseAdapter adapter;
    private ImageView arrow;


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

    @SuppressLint("ClickableViewAccessibility")
    private void init(AttributeSet attrs){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        rootView = inflater.inflate(R.layout.spinner_yg,this,false);
        texHintFilled = rootView.findViewById(R.id.text_hint_filled);
        spinner = rootView.findViewById(R.id.spinner);
        layout = rootView.findViewById(R.id.root_layout);
        arrow = rootView.findViewById(R.id.spiner_row_down);

        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.SpinerYg,
                    0, 0);
            try {

                String resTextHint = a.getString(R.styleable.SpinerYg_textHintSpinner);
                texHintFilled.setText(resTextHint);
                texHintFilled.setVisibility(GONE);

            } finally {
                a.recycle();
            }
        }

        spinner.setOnItemSelectedListener(this);
        spinner.setOnTouchListener(this);
        layout.setOnClickListener(this);
        arrow.setOnClickListener(this);
        this.addView(rootView);
    }


    public void setListener(SpinnerListener listener) {
        this.listener = listener;
    }


    public Object getSelectionItem(){

        return spinner.getSelectedItem();
    }

    public void setAdapter(BaseAdapter adapter){
        this.adapter = adapter;
        this.spinner.setAdapter(this.adapter);
    }

    public void setVisibiltyHint(int visibiltyHint){
        this.texHintFilled.setVisibility(visibiltyHint);
    }

    public void showDropDown(boolean delay){
        if (delay){
            new Handler().postDelayed(() -> {
                inActive();
                spinner.performClick();
            }, 1000);
        }
        else {
            inActive();
            spinner.performClick();

        }
    }



    public void inActive(){
        this.layout.setBackgroundResource(R.drawable.input_text_active);
    }

    public void inError(){
        this.layout.setBackgroundResource(R.drawable.input_text_error);
    }

    public void inNormal(){
        this.layout.setBackgroundResource(R.drawable.input_text_normal);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (listener != null){
            if (position != 0){
                setVisibiltyHint(View.VISIBLE);

            } else {
                setVisibiltyHint(View.GONE);
            }
            listener.onItemSelected(this,position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (listener != null) {
            if (i == R.id.root_layout) {
                listener.setOnClickListener(this);
            } else if (i == R.id.spiner_row_down) {
                listener.setOnClickListenerArrow(this);
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (listener != null){
            listener.setOnTouchListener(this);
        }
        return false;
    }


    /*
    * TextView forgot_pswrd = (TextView) findViewById(R.id.ForgotPasswordText);
forgot_pswrd.setOnTouchListener(this);
LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
llp.setMargins(50, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
forgot_pswrd.setLayoutParams(llp);*/
}
