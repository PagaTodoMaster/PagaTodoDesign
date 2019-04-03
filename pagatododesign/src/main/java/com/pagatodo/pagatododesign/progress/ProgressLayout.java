package com.pagatodo.pagatododesign.progress;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pagatodo.pagatododesign.R;

/* Componente de carga / espera en pantalla */
public class ProgressLayout extends LinearLayout {

    private ImageView imgBackground;
    private TextView txtMessage;
    private FrameLayout frameProgress;

    public ProgressLayout(Context context) {
        super(context);
        init();
    }

    public ProgressLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProgressLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.progress_layout, this, true);
        imgBackground = findViewById(R.id.img_blur_progress);
        txtMessage = findViewById(R.id.txt_message);
        frameProgress = findViewById(R.id.frame_progress);
    }

    public void setTextMessage(String message) {
        try {
            txtMessage.setText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVisivilityImage(int visibility) {
        frameProgress.setVisibility(visibility);
    }
}
