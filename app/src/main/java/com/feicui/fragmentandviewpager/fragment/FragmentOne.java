package com.feicui.fragmentandviewpager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feicui.fragmentandviewpager.R;
import com.feicui.fragmentandviewpager.Two_activity;

/**
 * Created by lenovo on 2016/9/1.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{
private TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textFone);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textFone:
                Intent intent = new Intent(getContext(), Two_activity.class);
                startActivity(intent);
                break;
        }
    }
}
