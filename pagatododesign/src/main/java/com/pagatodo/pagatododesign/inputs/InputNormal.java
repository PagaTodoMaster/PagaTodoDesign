package com.pagatodo.pagatododesign.inputs;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pagatodo.pagatododesign.R;
import com.pagatodo.pagatododesign.controllers.LinearLayoutGeneric;

import java.util.Objects;

import androidx.annotation.Nullable;

public class InputNormal extends LinearLayoutGeneric implements View.OnFocusChangeListener{

    private TextInputLayout inputLayout;
    private TextInputEditText inputEditText;
    private InputListener listener;

    public InputNormal(Context context) {
        super(context);
        init(null);
    }

    public InputNormal(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public InputNormal(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    public void init(AttributeSet attrs) {
        View rootView = LayoutInflater.from(getContext())
                .inflate(R.layout.input_natural,this,false);
        inputLayout = rootView.findViewById(R.id.textInputLayout);
        inputEditText = rootView.findViewById(R.id.edit_input_layout);
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.InputNormal,
                    0, 0);
            try {
                int typeInput = a.getInt(R.styleable.InputNormal_inputType,0);
                setTypeInput(typeInput);
                String textHint = a.getString(R.styleable.InputNormal_textHint);
                setHint(textHint);
            } finally {
                a.recycle();
            }
        }
        bind();
        this.addView(rootView);
    }

    private void bind(){
        inputEditText.setOnFocusChangeListener(this);
    }

    private void setTypeInput(int typeInput){
        switch (typeInput){
            case 1:
                inputEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            default:
                inputEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            inputLayout.setBackground(getContext().getResources().getDrawable(R.drawable.input_text_active));
        } else {
            if (validate()){
                inputLayout.setBackground(getContext().getResources().getDrawable(R.drawable.input_text_normal));
            } else {
                inputLayout.setBackground(getContext().getResources().getDrawable(R.drawable.input_text_error));
            }

        }
    }

    private boolean validate(){
        return !Objects.requireNonNull(inputEditText.getText()).toString().isEmpty();
    }

    public String getText(){
        return Objects.requireNonNull(inputEditText.getText()).toString();
    }

    public void setHint(String textHint){
        inputLayout.setHint(textHint);
    }

    public void setRequest(){
        inputEditText.requestFocus();
    }

    public void setInputListener(InputListener listener){
        this.listener = listener;
        //this.inputEditText.addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (listener != null){
                listener.inputListenerFinish(inputEditText);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
