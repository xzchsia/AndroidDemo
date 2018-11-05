package com.example.androiddemo.pagerslidingtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddemo.R;

public class BlankFragment extends Fragment {

    private static final String ARG_PARAM1 = "title";
    private String mParam1;
    private View view;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String param) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param);
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

    public String getFragmentTitle(){
        return mParam1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_blank, container, false);
            //在这里做一些初始化处理
            TextView textView = (TextView) view.findViewById(R.id.tv_content);
            textView.setText(mParam1);
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null)
                viewGroup.removeView(view);
        }
        return view;
    }

}
