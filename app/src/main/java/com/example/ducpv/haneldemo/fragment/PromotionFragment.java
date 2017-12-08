package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.ducpv.haneldemo.R;

/**
 * Created by ducpv on 12/6/17.
 */

public class PromotionFragment extends BaseFragment {

    public static PromotionFragment newInstance() {
        Bundle args = new Bundle();

        PromotionFragment fragment = new PromotionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_promotion;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {

    }
}
