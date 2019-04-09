package com.pagatodo.pagatododesign.progress.steps;

import android.graphics.drawable.Drawable;

public interface StepLauncher {
    void setSetResource(Drawable drawable);
    void setTextStep(int stepText);
    String getTextStep();
}
