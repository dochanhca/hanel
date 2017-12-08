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

public class AccountFragment extends BaseFragment {

    private FragmentTabHost mTabHost;

    public static AccountFragment newInstance() {

        Bundle args = new Bundle();
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_account;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        setHeaderTitle(getString(R.string.account));
        showRightAcButton();

        mTabHost = rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(this.getActivity(), getChildFragmentManager(), android.R.id.tabcontent);
        mTabHost.addTab(
                mTabHost.newTabSpec(MyDiscountFragment.class.getSimpleName()).setIndicator(getTabIndicator(R.string.discount)),
                MyDiscountFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(CodeFragment.class.getSimpleName()).setIndicator(getTabIndicator(R.string.code)),
                CodeFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec(MyInfoFragment.class.getSimpleName()).setIndicator(getTabIndicator(R.string.my_info)),
                MyInfoFragment.class, null);
    }

    private View getTabIndicator(int title) {
        View view = LayoutInflater.from(mTabHost.getContext()).inflate(R.layout.tab_layout, null);
        TextView txtTitle =  view.findViewById(R.id.txt_title);
        txtTitle.setText(title);
        return view;
    }
}
