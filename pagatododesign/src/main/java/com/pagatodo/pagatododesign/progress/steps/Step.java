package com.pagatodo.pagatododesign.progress.steps;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pagatodo.pagatododesign.R;
import com.pagatodo.pagatododesign.controllers.LauncherView;

public class Step implements LauncherView {

    private Context context;
    private TextView stepText;
    private LinearLayout linearLayout;
    private View rootView;

    private Step(Context context) {
        this.context = context;
        init();
    }

    static Step getInstance(Context context){
        return new Step(context);
    }

    @Override
    public void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        rootView = inflater.inflate(R.layout.step,linearLayout,false);
        linearLayout = rootView.findViewById(R.id.content_step);
        stepText = rootView.findViewById(R.id.step);
    }

    @Override
    public void bind() {}

    @Override
    public void inflate(ViewGroup layout) {
        layout.addView(rootView);
    }

    @Override
    public View getView() {
        return rootView;
    }

    Step setNatural(String textStep){
        setLinearLayout(18,18,R.drawable.step_natural_backgraund);
        stepText.setText(textStep);
        stepText.setTextSize(TypedValue.COMPLEX_UNIT_PX, dp(12));
        stepText.setTextColor(Color.parseColor("#9e9e9e"));
        return this;
    }

    Step setCheck(String textStep){
        setLinearLayout(18,18,R.drawable.step_check_bakcgraund);
        stepText.setText(textStep);
        stepText.setTextSize(TypedValue.COMPLEX_UNIT_PX, dp(12));
        stepText.setTextColor(Color.parseColor("#FFFFFF"));
        return this;
    }

    Step setActive(String textStep){
        setLinearLayout(28,28,R.drawable.step_active_backgraund);
        stepText.setText(textStep);
        stepText.setTextSize(TypedValue.COMPLEX_UNIT_PX, dp(18));
        stepText.setTextColor(Color.parseColor("#FFFFFF"));
        return this;
    }

    private void setLinearLayout(int w, int h, int res){
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(
                dp(w),
                dp(h)));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setBackground(context.getResources().getDrawable(res));
    }

    private int dp(int px){
        float scale = linearLayout.getResources().getDisplayMetrics().density;
        return (int) (scale * px + 0.5f);
    }
}
