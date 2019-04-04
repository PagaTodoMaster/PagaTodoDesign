package com.pagatodo.pagatododesign.buttons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.pagatodo.pagatododesign.R;
import com.pagatodo.pagatododesign.dataholders.IconButtonDataHolder;
import com.pagatodo.pagatododesign.holders.IconButtonHolder;


public class IconButton extends LinearLayout {

    private IconButtonHolder holder;

    public IconButton(Context context) {
        super(context);
        init(null);
    }

    public IconButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public IconButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View viewItem = inflater.inflate(R.layout.item_icon_button,this,false);
        holder = new IconButtonHolder(viewItem);
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.IconButton,
                    0, 0);
            try {
                Drawable resImage = a.getDrawable(R.styleable.IconButton_iconResImage);
                String resText = a.getString(R.styleable.IconButton_iconNameText);
                holder.bind(new IconButtonDataHolder(resImage,resText),null);
            } finally {
                a.recycle();
            }
        }
        holder.inflate(this);
    }

    public void setIconButton(Drawable res, String textName){
        holder.setIconImage(res);
        holder.setTextName(textName);
    }
}
