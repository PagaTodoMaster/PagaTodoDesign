package com.pagatodo.pagatododesign.controllers;

import android.view.View;
import android.view.ViewGroup;

public interface LauncherView {

    void init();

    void bind();

    void inflate(ViewGroup layout);

    View getView();
}
