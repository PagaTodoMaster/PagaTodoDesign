package com.pagatodo.pagatododesign.progress.steps;

public interface StepBarLauncher {

    void nextStep();

    void backStep();

    void jumpStep(int step);

    void setSizeSteps(int size);

    void setStepInitial(int initial);
}
