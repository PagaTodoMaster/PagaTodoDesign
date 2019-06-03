package com.pagatodo.pagatododesign.spinners;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pagatodo.pagatododesign.R;

import java.util.List;

public class SpinnerYgAdapter extends BaseAdapter {

    private List<String> list;
    private LayoutInflater inflter;
    private Context context;
    private int resView;

    public SpinnerYgAdapter(List<String> list,Context context){
        this.list = list;
        this.context = context;
        this.inflter = LayoutInflater.from(context);

    }


    /*@Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView != null){
            TextView textView = convertView.findViewById(R.id.text_spinner);
            textView.setText(list.get(position));
        }
        return convertView;
    }*/

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflter.inflate(R.layout.spinner_text,parent,false);
        TextView textView = convertView.findViewById(R.id.text_spinner);
        textView.setText(list.get(position));
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (position != 0) {
            convertView = inflter.inflate(R.layout.spinner_text, parent, false);
            TextView textView = convertView.findViewById(R.id.text_spinner);
            textView.setText(list.get(position));
            float scale = textView.getResources().getDisplayMetrics().density;
            int pdC = (int) (scale * 5 + 0.5f);
            textView.setPadding(pdC, pdC, 0, pdC);

            return convertView;
        } return new View(context);
    }
}
