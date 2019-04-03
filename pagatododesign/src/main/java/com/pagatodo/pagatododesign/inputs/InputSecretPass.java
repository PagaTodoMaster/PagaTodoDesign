package com.pagatodo.pagatododesign.inputs;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.pagatodo.pagatododesign.R;

import java.util.Objects;

import androidx.annotation.Nullable;

public class InputSecretPass extends InputLauncher implements View.OnClickListener{

    private int resD;

    public InputSecretPass(Context context) {
        super(context);
        initView(null);
    }

    public InputSecretPass(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public InputSecretPass(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    @Override
    public void initView(AttributeSet attrs) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        viewMain = inflater.inflate(R.layout.input_secret_pass,this,false   );
        inputEditText = viewMain.findViewById(R.id.edit_input_layout);
        rootView = viewMain.findViewById(R.id.root_view);
        textviewHint = viewMain.findViewById(R.id.textview_hint);
        textLabel = viewMain.findViewById(R.id.text_label);

        astOne = viewMain.findViewById(R.id.ast_one);
        astTwo = viewMain.findViewById(R.id.ast_two);
        astThree = viewMain.findViewById(R.id.ast_three);
        astFour = viewMain.findViewById(R.id.ast_four);
        astFive = viewMain.findViewById(R.id.ast_five);
        astSix = viewMain.findViewById(R.id.ast_six);

        textOne = viewMain.findViewById(R.id.num_text_one);
        textTwo = viewMain.findViewById(R.id.num_text_two);
        textThree = viewMain.findViewById(R.id.num_text_trhee);
        textFour = viewMain.findViewById(R.id.num_text_four);
        textFive = viewMain.findViewById(R.id.num_text_five);
        textSix = viewMain.findViewById(R.id.num_text_six);

        imageviewEye = viewMain.findViewById(R.id.imageview_eye);
        linearText = viewMain.findViewById(R.id.linear_text);
        linearAst = viewMain.findViewById(R.id.linear_ast);
        linearLines = viewMain.findViewById(R.id.layer_lines);
        linearImageViewEye = viewMain.findViewById(R.id.imageView_layout);

        bind();
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.InputSecretPass,
                    0, 0);
            try {
                String resText = a.getString(R.styleable.InputSecretPass_labelHint);
                setHint(resText);
                boolean with_eye = a.getBoolean(R.styleable.InputSecretPass_with_eye, false);
                with_eye(with_eye);

            } finally {
                a.recycle();
            }
        }
        rootView.setOnClickListener(this);
        this.addView(viewMain);
    }

    /*@Override
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
    }*/

    private void bind(){
        hidePass();
        imageviewEye.setOnClickListener(this);
        inputEditText.addTextChangedListener(this);
        inputEditText.setOnFocusChangeListener(this);
    }

    public String getTextEdit(){
        String text = textOne.getText().toString() + textTwo.getText().toString() +
                textThree.getText().toString() + textFour.getText().toString() + textFive.getText().toString() +
                textSix.getText().toString();
        return text.trim();
    }

    public void hidePass(){
        resD = R.drawable.ic_eye_close;
        imageviewEye.setBackgroundResource(resD);
        linearText.setVisibility(INVISIBLE);
        setShowAst();

    }

    public void showPass(){
        resD = R.drawable.ic_eye_open;
        imageviewEye.setBackgroundResource(resD);
        linearText.setVisibility(VISIBLE);
        astOne.setVisibility(View.INVISIBLE);
        astTwo.setVisibility(View.INVISIBLE);
        astThree.setVisibility(View.INVISIBLE);
        astFour.setVisibility(View.INVISIBLE);
        astFive.setVisibility(View.INVISIBLE);
        astSix.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.imageview_eye) {
            if (resD == R.drawable.ic_eye_close){
                showPass();
            } else if (resD == R.drawable.ic_eye_open){
                hidePass();
            }
        } else if (i == R.id.root_view){
            active();
        }

    }

    private void setShowAst(){

        switch (Objects.requireNonNull(inputEditText.getText()).toString().length()){
            case 1:
                astOne.setVisibility(View.VISIBLE);
                astTwo.setVisibility(View.INVISIBLE);
                astThree.setVisibility(View.INVISIBLE);
                astFour.setVisibility(View.INVISIBLE);
                astFive.setVisibility(View.INVISIBLE);
                astSix.setVisibility(View.INVISIBLE);
                break;
            case 2:
                astOne.setVisibility(View.VISIBLE);
                astTwo.setVisibility(View.VISIBLE);
                astThree.setVisibility(View.INVISIBLE);
                astFour.setVisibility(View.INVISIBLE);
                astFive.setVisibility(View.INVISIBLE);
                astSix.setVisibility(View.INVISIBLE);
                break;
            case 3:
                astOne.setVisibility(View.VISIBLE);
                astTwo.setVisibility(View.VISIBLE);
                astThree.setVisibility(View.VISIBLE);
                astFour.setVisibility(View.INVISIBLE);
                astFive.setVisibility(View.INVISIBLE);
                astSix.setVisibility(View.INVISIBLE);
                break;
            case 4:
                astOne.setVisibility(View.VISIBLE);
                astTwo.setVisibility(View.VISIBLE);
                astThree.setVisibility(View.VISIBLE);
                astFour.setVisibility(View.VISIBLE);
                astFive.setVisibility(View.INVISIBLE);
                astSix.setVisibility(View.INVISIBLE);
                break;
            case 5:
                astOne.setVisibility(View.VISIBLE);
                astTwo.setVisibility(View.VISIBLE);
                astThree.setVisibility(View.VISIBLE);
                astFour.setVisibility(View.VISIBLE);
                astFive.setVisibility(View.VISIBLE);
                astSix.setVisibility(View.INVISIBLE);
                break;
            case 6:
                astOne.setVisibility(View.VISIBLE);
                astTwo.setVisibility(View.VISIBLE);
                astThree.setVisibility(View.VISIBLE);
                astFour.setVisibility(View.VISIBLE);
                astFive.setVisibility(View.VISIBLE);
                astSix.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus){
            active();
            if (!Objects.requireNonNull(inputEditText.getText()).toString().isEmpty()) {
                inputEditText.setSelection(inputEditText.getText().length());
            }
        } else {
            desactive();
            if (Objects.requireNonNull(inputEditText.getText()).toString().length() < 6){
                isError();
                desactive();
            }
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (Objects.requireNonNull(inputEditText.getText()).toString().length() < 6) {
            if (this.listener != null) {
                this.listener.inputListenerBegin();
            }
        }

        switch (Objects.requireNonNull(inputEditText.getText()).toString().length()){
            case 1:
                if (resD == R.drawable.ic_eye_close){
                    astOne.setVisibility(View.VISIBLE);
                } else {
                    astOne.setVisibility(View.INVISIBLE);
                }
                astTwo.setVisibility(View.INVISIBLE);
                textTwo.setText("");
                textOne.setText(s.toString());
                break;
            case 2:

                if (resD == R.drawable.ic_eye_close){
                    astTwo.setVisibility(View.VISIBLE);
                } else {
                    astTwo.setVisibility(View.INVISIBLE);
                }
                astThree.setVisibility(View.INVISIBLE);
                textThree.setText("");
                textTwo.setText(s.toString().substring(1));
                break;
            case 3:

                if (resD == R.drawable.ic_eye_close){
                    astThree.setVisibility(View.VISIBLE);
                } else {
                    astThree.setVisibility(View.INVISIBLE);
                }
                astFour.setVisibility(View.INVISIBLE);
                textFour.setText("");
                textThree.setText(s.toString().substring(2));
                break;
            case 4:

                if (resD == R.drawable.ic_eye_close){
                    astFour.setVisibility(View.VISIBLE);
                } else {
                    astFour.setVisibility(View.INVISIBLE);
                }
                astFive.setVisibility(View.INVISIBLE);
                textFour.setText(s.toString().substring(3));
                textFive.setText("");
                break;
            case 5:
                astSix.setVisibility(View.INVISIBLE);
                if (resD == R.drawable.ic_eye_close){
                    astFive.setVisibility(View.VISIBLE);
                } else {
                    astFive.setVisibility(View.INVISIBLE);
                }
                textFive.setText(s.toString().substring(4));
                textSix.setText("");
                break;
            case 6:
                rootView.setBackgroundResource(R.drawable.input_text_active);
                if (resD == R.drawable.ic_eye_close){
                    astSix.setVisibility(View.VISIBLE);
                } else {
                    astSix.setVisibility(View.INVISIBLE);
                }
                textSix.setText(s.toString().substring(5));
                if (this.listener != null){
                    this.listener.inputListenerFinish(this);
                }
                break;
            default:
                astOne.setVisibility(View.INVISIBLE);
                textOne.setText("");
                active();

                break;
        }
    }

}
