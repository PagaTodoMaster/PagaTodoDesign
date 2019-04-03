package com.pagatodo.pagatododesign.controllers;

import android.view.View;

public interface OnHolderListener<T> {
    void onClickView(T item, View view);
}
