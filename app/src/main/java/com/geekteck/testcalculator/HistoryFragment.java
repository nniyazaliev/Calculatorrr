package com.geekteck.testcalculator;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

import static java.util.ResourceBundle.getBundle;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
    RecyclerView recyclerView;
    MainAdapter adapter;
    Button back, show;
        ArrayList<String> list = new ArrayList<>();
    public HistoryFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_history, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            show = view.findViewById(R.id.show);
            show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAll();
                }
            });
            recyclerView = view.findViewById(R.id.recycler_view);
            adapter = new MainAdapter();
            recyclerView.setAdapter(adapter);
            back = view.findViewById(R.id.back_btn);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ForRecycle listener = (ForRecycle) getActivity();
                    listener.back();
                }
            });
    }
    public void showAll() {
        list = getArguments().getStringArrayList("key");
        for (int i = 0; i < list.size(); i++) {
            adapter.addText(list.get(i));
            Log.d("get", "onClick: " + list);
        }
    }
}
