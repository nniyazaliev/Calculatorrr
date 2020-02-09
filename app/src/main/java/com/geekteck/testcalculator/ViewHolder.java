package com.geekteck.testcalculator;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
TextView textView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.tv_holder);
    }
    public void setText(String text){
        textView.setText(text);
    }
}
