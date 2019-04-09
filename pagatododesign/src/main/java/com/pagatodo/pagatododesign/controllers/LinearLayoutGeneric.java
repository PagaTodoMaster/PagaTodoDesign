package com.pagatodo.pagatododesign.controllers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public abstract class LinearLayoutGeneric extends LinearLayout {

    protected LayoutInflater inflater;

    public LinearLayoutGeneric(Context context) {
        super(context);
        inflater = LayoutInflater.from(getContext());
    }

    public LinearLayoutGeneric(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflater = LayoutInflater.from(getContext());
    }

    public LinearLayoutGeneric(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflater = LayoutInflater.from(getContext());
    }

    public abstract void init(AttributeSet attrs);
}
