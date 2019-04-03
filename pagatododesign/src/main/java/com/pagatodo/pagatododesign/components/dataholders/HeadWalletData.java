package com.pagatodo.pagatododesign.components.dataholders;

import android.graphics.drawable.Drawable;

public class HeadWalletData {
    private Drawable resImage;
    private String title;
    private String amount;

    private HeadWalletData(Drawable resImage, String title, String amount) {
        this.resImage = resImage;
        this.title = title;
        this.amount = amount;
    }

    public static HeadWalletData createHead(Drawable resImage, String title, String amount){
        return new HeadWalletData(resImage,title,amount);
    }
/*
    public HeadWalletData(int resImage, String title, String amount) {
        this.resImage = resImage;
        this.title = title;
        this.amount = amount;
    }
*/
    public Drawable getResImage() {
        return resImage;
    }

    public void setResImage(Drawable resImage) {
        this.resImage = resImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
