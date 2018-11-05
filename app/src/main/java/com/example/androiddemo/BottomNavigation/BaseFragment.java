package com.example.androiddemo.BottomNavigation;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddemo.R;

public class BaseFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private View view;


    public BaseFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance(String param1) {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_base, container, false);
            //在这里做一些初始化处理
            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(mParam1);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Don't click me.please!.", Snackbar.LENGTH_SHORT).show();
                }
            });

        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null)
                viewGroup.removeView(view);
        }

        return view;
    }

}
