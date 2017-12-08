package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;

/**
 * Created by ducpv on 12/6/17.
 */

public class DiscountFragment extends BaseFragment {

    private FragmentTabHost mTabHost;

    public static DiscountFragment newInstance() {

        Bundle args = new Bundle();
        DiscountFragment fragment = new DiscountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_discount;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        mTabHost = rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(this.getActivity(), getChildFragmentManager(), android.R.id.tabcontent);

        mTabHost.addTab(
                mTabHost.newTabSpec(PromotionFragment.class.getSimpleName()).setIndicator(getTabIndicator(R.string.promotion)),
                PromotionFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(NewestFragment.class.getSimpleName()).setIndicator(getTabIndicator(R.string.newest)),
                NewestFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(NearByFragment.class.getSimpleName()).setIndicator(getTabIndicator(R.string.near_you)),
                NearByFragment.class, null);

        showLogoACB();
        showRightAcButton();
    }

    private View getTabIndicator(int title) {
        View view = LayoutInflater.from(mTabHost.getContext()).inflate(R.layout.tab_layout, null);
        TextView txtTitle =  view.findViewById(R.id.txt_title);
        txtTitle.setText(title);
        return view;
    }
}
