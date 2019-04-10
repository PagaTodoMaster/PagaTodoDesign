package com.pagatodo.pagatododesign.inputs;

import android.util.AttributeSet;

public interface Input {
    void initView(AttributeSet attrs);
    void active();
    void desactive();
    void setHint(String hintText);
    void isError();
    void setInputSecretListener(InputListener listener);
    void setText(String text);
    String getText();
    void with_eye(Boolean active);
}
