package com.pagatodo.pagatododesign.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.pagatodo.pagatododesign.R;
import com.pagatodo.pagatododesign.dataholders.HeadWalletData;
import com.pagatodo.pagatododesign.controllers.LauncherHolder;
import com.pagatodo.pagatododesign.controllers.OnHolderListener;

import java.text.NumberFormat;
import java.util.Locale;

import androidx.annotation.Nullable;

public class HeadWallet extends LinearLayout implements LauncherHolder<HeadWalletData> {

    private View rootView;
    private ImageView imgWallet;
    private TextView title;
    private TextView amount;

    public HeadWallet(Context context) {
        super(context);
        initMain(null);
    }

    public HeadWallet(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initMain(attrs);
    }

    public HeadWallet(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initMain(attrs);
    }

    public void initMain(AttributeSet attrs){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        rootView = inflater.inflate(R.layout.head_wallet,this,false);
        init();
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.HeadWallet,
                    0, 0);
            try {
                Drawable resImage = a.getDrawable(R.styleable.HeadWallet_walletResImage);
                if (resImage != null){
                    //resImage = getContext().getResources().getDrawable(R.drawable)
                }
                String resTitle = a.getString(R.styleable.HeadWallet_headTitle);
                String resAmount = a.getString(R.styleable.HeadWallet_headAmount);
                bind(HeadWalletData.createHead(resImage,resTitle,resAmount),null);
            } finally {
                a.recycle();
            }
        }
        this.addView(rootView);
    }

    @Override
    public void init() {
        this.imgWallet = rootView.findViewById(R.id.img_wallet);
        this.title = rootView.findViewById(R.id.text_title);
        this.amount = rootView.findViewById(R.id.text_amount);
    }


    @Override
    public void bind(HeadWalletData item, OnHolderListener<HeadWalletData> listener) {
        this.imgWallet.setImageDrawable(item.getResImage());
        this.title.setText(item.getTitle());
        this.amount.setText(formatMoney(item.getAmount()));

    }

    @Override
    public void inflate(ViewGroup layout) {
        this.addView(layout);
    }

    @Override
    public View getView() {
        return this;
    }

    public void setTitle(String title){
        this.title.setText(title);
    }

    public void setAmount(String amount){
        this.amount.setText(formatMoney(amount));
    }

    public void setResImage(Drawable res){
        this.imgWallet.setImageDrawable(res);
    }

    private String formatMoney(String money){
        double amount = 0d;
        try {
            amount = Double.parseDouble(money);
        } catch (NumberFormatException e){
            amount = 0d;
            return money;
        }
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }
}
