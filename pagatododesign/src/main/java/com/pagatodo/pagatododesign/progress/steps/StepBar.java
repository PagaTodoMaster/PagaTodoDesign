package com.pagatodo.pagatododesign.progress.steps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pagatodo.pagatododesign.R;
import com.pagatodo.pagatododesign.controllers.LinearLayoutGeneric;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class StepBar extends LinearLayoutGeneric implements StepBarLauncher{

    private LinearLayout conteSteps;
    private ArrayList<LinearLayout> stepNaturals;
    private int whidthSeparation;
    private int currentStep;
    private int size;

    public StepBar(Context context) {
        super(context);
        init(null);
    }

    public StepBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public StepBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    public void init(AttributeSet attrs) {
        View rootView = this.inflater.inflate(R.layout.step_bar, this, false);
        stepNaturals = new ArrayList<>();
        conteSteps = rootView.findViewById(R.id.content_steps);
        currentStep = 0;
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.StepBar,
                    0, 0);
            try {
                size = a.getInteger(R.styleable.StepBar_sizeSteps,0);
                currentStep = a.getInteger(R.styleable.StepBar_initialStep,0);
                this.whidthSeparation = a.getDimensionPixelSize(R.styleable.StepBar_separationWidth, 50);
                setSizeSteps(size);
                setStepInitial(currentStep);
            } finally {
                a.recycle();
            }
        }
        this.addView(rootView);
    }


    @Override
    public void nextStep() {
        if (currentStep < size) {
            this.currentStep++;
            setStepInitial(this.currentStep);
        }
    }

    @Override
    public void backStep() {
        if (currentStep > 1){
            stepNaturals.get(currentStep-1).removeAllViews();
            Step.getInstance(getContext()).setNatural(String.valueOf(currentStep))
                    .inflate(stepNaturals.get(currentStep-1));
            this.currentStep--;
            setStepInitial(this.currentStep);
        }
    }

    @Override
    public void jumpStep(int step) {
        if (step > 1 && step < size && step != currentStep){
            currentStep = step;
            setStepInitial(currentStep++);
            backStep();
        }
    }

    @Override
    public void setSizeSteps(int size) {
        for (int i = 0; i < size; i++) {
            LinearLayout setpLayout = new LinearLayout(getContext());
            setpLayout.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            Step.getInstance(getContext()).setNatural(String.valueOf(i + 1)).inflate(setpLayout);
            stepNaturals.add(setpLayout);
            infalte();
        }
    }

    @Override
    public void setStepInitial(int initial) {
        if (initial > 0 && initial <=  stepNaturals.size()) {
            for (int i = 0; i < initial; i++){
                stepNaturals.get(i).removeAllViews();
                Step.getInstance(getContext())
                        .setCheck(String.valueOf(i + 1))
                        .inflate(stepNaturals.get(i));
            }
            stepNaturals.get(initial - 1).removeAllViews();
            Step.getInstance(getContext())
                        .setActive(String.valueOf(initial))
                        .inflate(stepNaturals.get(initial - 1));
        }
    }

    private void infalte(){
        conteSteps.removeAllViews();
        for (int i = 0; i < stepNaturals.size(); i++) {
            conteSteps.addView(stepNaturals.get(i));
            if (i < stepNaturals.size()-1)
                conteSteps.addView(getSeparation(this.whidthSeparation));
        }
    }

    private View getSeparation(int whidthSeparation){
        View separation = new View(getContext());
        separation.setLayoutParams(new LayoutParams(
                dp(whidthSeparation,separation),dp(1,separation)));
        separation.setBackgroundColor(Color.parseColor("#00a1e1"));
        return separation;
    }

    private int dp(int px, View view){
        float scale = view.getResources().getDisplayMetrics().density;
        return (int) (scale * px + 0.5f);
    }
}
