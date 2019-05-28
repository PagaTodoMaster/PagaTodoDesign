package com.pagatodo.pagatododesign.spinners;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.pagatodo.pagatododesign.R;

public class SpinerYg extends LinearLayout implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    private TextView texHintFilled;
    private Spinner spinner;
    private ConstraintLayout layout;
    private SpinnerListener listener;
    private BaseAdapter adapter;


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
        texHintFilled = viewItem.findViewById(R.id.text_hint_filled);
        spinner = viewItem.findViewById(R.id.spinner);
        layout = viewItem.findViewById(R.id.root_layout);
        viewItem.findViewById(R.id.spiner_row_down).setOnClickListener(this);

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
        layout.setOnClickListener(this);

        spinner.setOnItemSelectedListener(this);
        this.addView(viewItem);
    }

    public void setListener(SpinnerListener listener) {
        this.listener = listener;
    }

    public void selectionItem(int position){
        this.spinner.setSelection(position);
    }

    public Object getSelectionItem(int position){
        if (this.adapter != null){
            return this.adapter.getItem(position);
        }
        return null;

    }

    public void setAdapter(BaseAdapter adapter){
        this.adapter = adapter;
        this.spinner.setAdapter(this.adapter);
    }

    public void setVisibiltyHint(int visibiltyHint){
        this.texHintFilled.setVisibility(visibiltyHint);
    }

    public void showDropDown(){
        new Handler().postDelayed(() -> {
                spinner.performClick();
                inActive();
        }, 1000);
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
            listener.onItemSelected(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        spinner.performClick();
        inActive();
    }

    /*
    * TextView forgot_pswrd = (TextView) findViewById(R.id.ForgotPasswordText);
forgot_pswrd.setOnTouchListener(this);
LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
llp.setMargins(50, 0, 0, 0); // llp.setMargins(left, top, right, bottom);
forgot_pswrd.setLayoutParams(llp);*/
}
