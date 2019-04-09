package com.pagatodo.pagatododesign.controllers.patterns;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CompositeLayout implements Component {

    private List<Component> components;

    private LinearLayout linearLayout;

    CompositeLayout(LinearLayout layout, int id){
        this.linearLayout = layout;
        components = new ArrayList<>();
        setContent(id);
    }


    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void setContent(int id) {
        //linearLayout.setBackgroundResource(id);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(LinearLayout.TEXT_ALIGNMENT_GRAVITY);
    }

    @Override
    public void inflate(ViewGroup layout) {
        layout.addView(linearLayout);

        for (Component c: components){
            c.inflate(linearLayout);
        }
    }
}
