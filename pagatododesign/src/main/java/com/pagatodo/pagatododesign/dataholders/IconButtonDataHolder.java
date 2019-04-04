package com.pagatodo.pagatododesign.dataholders;

import android.graphics.drawable.Drawable;
import android.os.Parcel;

import java.io.Serializable;

public class IconButtonDataHolder implements Serializable {
    private Drawable iconRes;
    private String name;
    private String namCom;
    private String imageUrl;
    private TYPE type;
    private Serializable object;

    public IconButtonDataHolder(Drawable iconRes, String name) {
        this.iconRes = iconRes;
        this.name = name;
    }

    public IconButtonDataHolder(Drawable iconRes, String name, String namCom, TYPE type) {
        this.iconRes = iconRes;
        this.name = name;
        this.namCom = namCom;
        this.type = type;
    }

    public IconButtonDataHolder(String imageUrl, String name, String namCom,  TYPE type) {
        this.name = name;
        this.namCom = namCom;
        this.imageUrl = imageUrl;
        this.type = type;

    }


    protected IconButtonDataHolder(Parcel in) {
        name = in.readString();
        namCom = in.readString();
        imageUrl = in.readString();
    }



    public Drawable getIconRes() {
        return iconRes;
    }

    public void setIconRes(Drawable iconRes) {
        this.iconRes = iconRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public String getNamCom() {
        return namCom;
    }

    public void setNamCom(String namCom) {
        this.namCom = namCom;
    }

    public Serializable getObject() {
        return object;
    }

    public void setObject(Serializable object) {
        this.object = object;
    }

    public enum TYPE{
        ITEM_RECHARGE, ITEM_RECHARGE_FAV, ADD_RECHARGE, ADD_PAY
    }
}
