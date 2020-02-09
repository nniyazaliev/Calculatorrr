package com.geekteck.testcalculator;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment implements View.OnClickListener {
    Button  changeHFragment;
    String oneAnswer;
    TextView textView;
    Double firstValues;
    Double secondValues;
    String operation;
    Double result;
    ArrayList<String> list = new ArrayList<>();
    HistoryFragment historyFragment=historyFragment = new HistoryFragment();
    public ButtonFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =
                inflater.inflate(R.layout.fragment_button, container, false);

        Button zero =  rootView.findViewById(R.id.zero);
        Button two =  rootView.findViewById(R.id.two);
        Button one =  rootView.findViewById(R.id.one);
        Button three =  rootView.findViewById(R.id.three);
        Button four =  rootView.findViewById(R.id.four);
        Button five =  rootView.findViewById(R.id.five);
        Button six =  rootView.findViewById(R.id.six);
        Button seven =  rootView.findViewById(R.id.seven);
        Button eight = rootView.findViewById(R.id.eight);
        Button nine = rootView.findViewById(R.id.nine);
        Button clear = rootView.findViewById(R.id.clear);

        Button plus = rootView.findViewById(R.id.plus);
        Button minus = rootView.findViewById(R.id.minus);
        Button division =  rootView.findViewById(R.id.divide);
        Button multiply = rootView.findViewById(R.id.btn_multiply);
        Button equal =  rootView.findViewById(R.id.equal);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        division.setOnClickListener(this);
        multiply.setOnClickListener(this);
        equal.setOnClickListener(this);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.result_txt_view);

        changeHFragment = view.findViewById(R.id.ch_fr_his);
        changeHFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForButton listener = (ForButton) getActivity();
                listener.historyOpen_interface();
            }
        });
    }
    @Override
    public void onClick(View v) {
         translateIdToIndex(v.getId());
    }
    int translateIdToIndex(int id) {
        switch (id) {
            case R.id.zero:
                textView.append("0");
                break;
            case R.id.one:
                textView.append("1");
                break;
            case R.id.two:
                textView.append("2");
                break;
            case R.id.three:
                textView.append("3");
                break;
            case R.id.four:
                textView.append("4");
                break;
            case R.id.five:
                textView.append("5");
                break;
            case R.id.six:
                textView.append("6");
                break;
            case R.id.seven:
                textView.append("7");
                break;
            case R.id.eight:
                textView.append("8");
                break;
            case R.id.nine:
                textView.append("9");
                break;
            case R.id.clear:
                textView.setText("");
                break;
            case R.id.plus:
                operation(R.id.plus);
                break;
            case R.id.minus:
                operation(R.id.minus);
                break;
            case R.id.btn_multiply:
                operation(R.id.btn_multiply);
                break;
            case R.id.divide:
                operation(R.id.divide);
                break;
            case R.id.equal:
                operation(R.id.equal);
                break;
        }
        return id;
    }

    public void operation(int id) {
        switch (id) {
            case R.id.plus:
                operation = "+";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "+");
                break;
            case R.id.minus:
                operation = "-";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "-");
                break;
            case R.id.btn_multiply:
                operation = "*";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "*");
                break;
            case R.id.divide:
                operation = "/";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "/");
                break;
            case R.id.equal:
                if (operation != null) {
                    String second = textView.getText().toString().replace(firstValues + operation + "", "");
                    secondValues = Double.valueOf(second);
                    switch (operation) {
                        case "+":
                            result = firstValues + secondValues;
                            textView.setText(firstValues + "+" + secondValues + "=" + result);
                            break;
                        case "-":
                            result = firstValues - secondValues;
                            textView.setText(firstValues + "-" + secondValues + "=" + result);
                            break;
                        case "*":
                            result = firstValues * secondValues;
                            textView.setText(firstValues + "*" + secondValues + "=" + result);
                            break;
                        case "/":
                            result = firstValues / secondValues;
                            textView.setText(firstValues + "/" + secondValues + "=" + result);
                            break;
                    }
                }
            default:
                break;
        }
    }
    public void sendAnswer() {
        changeFragment(historyFragment);
        Bundle bundle = new Bundle();
        oneAnswer = textView.getText().toString();
        list.add(oneAnswer);
        bundle.putStringArrayList("key", list);
        historyFragment.setArguments(bundle);
    }
    public void changeFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
