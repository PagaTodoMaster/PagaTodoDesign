package com.pagatodo.pagatododesign.controllers;

import android.view.View;
import android.view.ViewGroup;

public interface LauncherHolder<T> {
    void init();

    void bind(T item, OnHolderListener<T> listener);

    void inflate(ViewGroup layout);

    View getView();
}
