package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ducpv.haneldemo.R;

/**
 * Created by ducpv on 12/6/17.
 */

public abstract class BaseFragment extends Fragment {

    protected String TAG;
    protected View rootView;
    protected ImageView imgLeftAcbar;
    protected AppCompatTextView txtTitle;
    protected ImageView imgRightAcbar;
    protected ImageView imgLogo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(layoutId(), null);
        init(rootView, savedInstanceState);
        return rootView;
    }

    protected abstract int layoutId();

    protected abstract void init(View rootView, Bundle savedInstanceState);

    protected void setHeaderTitle(String title) {
        txtTitle = rootView.findViewById(R.id.txt_action_bar_title);
        txtTitle.setText(title);
    }

    protected void showBackButton() {
        imgLeftAcbar = rootView.findViewById(R.id.img_back);
        imgLeftAcbar.setVisibility(View.VISIBLE);
        imgLeftAcbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
    }

    protected void showRightAcButton() {
        imgRightAcbar = rootView.findViewById(R.id.img_right_ac_bar);
        imgRightAcbar.setVisibility(View.VISIBLE);
    }

    protected void showLogoACB() {
        imgLogo = rootView.findViewById(R.id.img_logo);
        imgLogo.setVisibility(View.VISIBLE);
        setHeaderTitle("");
    }
}
