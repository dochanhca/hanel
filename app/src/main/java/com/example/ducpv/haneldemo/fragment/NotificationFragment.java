package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.ducpv.haneldemo.R;

/**
 * Created by ducpv on 12/6/17.
 */

public class NotificationFragment extends BaseFragment {

    public static NotificationFragment newInstance() {

        Bundle args = new Bundle();
        NotificationFragment fragment = new NotificationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_notification;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        setHeaderTitle(getString(R.string.notification));
    }
}
