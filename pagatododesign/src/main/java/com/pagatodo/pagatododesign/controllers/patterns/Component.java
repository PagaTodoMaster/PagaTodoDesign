package com.pagatodo.pagatododesign.controllers.patterns;

import android.view.ViewGroup;

public interface Component {

    void add(Component component);

    void setContent(int id);

    void inflate(ViewGroup layout);


}
