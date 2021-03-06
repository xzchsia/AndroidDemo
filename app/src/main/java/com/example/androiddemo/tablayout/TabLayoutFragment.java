package com.example.androiddemo.tablayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddemo.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabLayoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabLayoutFragment extends LazyLoadFragment {
private final static String TAG = "TabLayoutFragment";
    private TextView textView = null;
    private View mView = null;
    private static final String ARG_PARAM1 = "title";

    private String mParam1;


    public TabLayoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment TabLayoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabLayoutFragment newInstance(String param1) {
        TabLayoutFragment fragment = new TabLayoutFragment();
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

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        if (mView == null) {
//            mView = inflater.inflate(R.layout.fragment_tab_layout, container, false);
//            //在这里做一些初始化处理
//            textView = (TextView) mView.findViewById(R.id.tab_layout_textview);
//            textView.setText(mParam1);
//        } else {
//            ViewGroup viewGroup = (ViewGroup) mView.getParent();
//            if (viewGroup != null)
//                viewGroup.removeView(mView);
//        }
//
//        return mView;
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab_layout;
    }

    @Override
    protected void init(View view) {
        this.mView = view;
        initRes();
    }

    private void initRes() {
        //在这里做一些初始化处理
        textView = (TextView) mView.findViewById(R.id.tab_layout_textview);
        textView.setText(mParam1);
        Log.d(TAG, "------>current fragment "+mParam1);
    }

}
