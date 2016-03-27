package com.sg.popupslider.example;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple counterpart for tab1 layout...
 */
public class MyTabTwo extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View tab = inflater.inflate(R.layout.tab, container, false);
        tab.setBackground(new ColorDrawable(getResources().getColor(R.color.blue)));
        return tab;
    }


}