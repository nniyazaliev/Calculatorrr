package com.geekteck.testcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ForButton, ForRecycle {
    ButtonFragment buttonFragment;
    HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonFragment = new ButtonFragment();
        historyFragment = new HistoryFragment();
        changeFragment(buttonFragment);
    }
    @Override
    public void historyOpen_interface() {
        buttonFragment.sendAnswer();
    }

    @Override
    public void back() {
        changeFragment(buttonFragment);
    }
        public void changeFragment(Fragment fragment) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.commit();
        }
}
