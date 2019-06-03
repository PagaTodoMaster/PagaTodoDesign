package com.pagatodo.pagatododesign.spinners;

import android.view.View;

public interface SpinnerListener {
    void onItemSelected(View view, int position);
    void setOnClickListener(View view);
    void setOnClickListenerArrow(View view);
    void setOnTouchListener(View view);
}
