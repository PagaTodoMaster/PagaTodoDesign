package com.pagatodo.pagatododesign.inputs;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;
import com.pagatodo.pagatododesign.R;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;


public abstract class InputLauncher extends LinearLayout implements Input, View.OnFocusChangeListener,
        TextWatcher {

    protected InputListener listener;
    protected TextInputEditText inputEditText;
    protected View viewMain;
    protected TextView textviewHint;
    protected TextView textLabel;
    protected ImageView astOne;
    protected ImageView astTwo;
    protected ImageView astThree;
    protected ImageView astFour;
    protected ImageView astFive;
    protected ImageView astSix;
    protected TextView textOne;
    protected TextView textTwo;
    protected TextView textThree;
    protected TextView textFour;
    protected TextView textFive;
    protected TextView textSix;
    protected ImageView imageviewEye;
    protected LinearLayout linearText;
    protected LinearLayout linearAst;
    protected LinearLayout linearLines;
    protected ConstraintLayout rootView;
    protected LinearLayout linearImageViewEye;

    public InputLauncher(Context context) {
        super(context);
    }

    public InputLauncher(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InputLauncher(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract void initView(AttributeSet attrs);

    @Override
    public void active() {
        rootView.setBackgroundResource(R.drawable.input_text_active);
        textviewHint.setVisibility(INVISIBLE);
        linearLines.setVisibility(VISIBLE);
        linearAst.setVisibility(VISIBLE);
        textLabel.setVisibility(VISIBLE);
    }

    @Override
    public void desactive() {
        rootView.setBackgroundResource(R.drawable.input_text_normal);
        if (Objects.requireNonNull(inputEditText.getText()).toString().isEmpty()){
            textLabel.setVisibility(INVISIBLE);
            textviewHint.setVisibility(VISIBLE);
            linearLines.setVisibility(INVISIBLE);
        } else {
            textLabel.setVisibility(VISIBLE);
            textviewHint.setVisibility(INVISIBLE);
        }
    }

    @Override
    public void isError(){
        rootView.setBackgroundResource(R.drawable.input_text_error);
    }

    @Override
    public void setHint(String hintText) {
        textLabel.setText(hintText);
        textviewHint.setText(hintText);
    }

    @Override
    public void setInputSecretListener(InputListener listener){
        this.listener = listener;
    }

    public void setActionListener(EditText.OnEditorActionListener listener){
        this.inputEditText.setOnEditorActionListener(listener);
    }

    public void setRequestFocus(){
        inputEditText.requestFocus();
    }

    public TextInputEditText getInputEditText(){
        return this.inputEditText;
    }


    @Override
    public void setText(String text) {

    }

    @Override
    public String getText() {
        return Objects.requireNonNull(inputEditText.getText()).toString();
    }
    
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void with_eye(Boolean active) {
        if (active){
            linearImageViewEye.setVisibility(VISIBLE);
        }else {
            linearImageViewEye.setVisibility(GONE);
        }
    }
}
