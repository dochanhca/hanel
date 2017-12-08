package com.example.ducpv.haneldemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ducpv.haneldemo.fragment.AccountFragment;
import com.example.ducpv.haneldemo.fragment.DiscountFragment;
import com.example.ducpv.haneldemo.fragment.FollowingFragment;
import com.example.ducpv.haneldemo.fragment.NotificationFragment;

/**
 * Created by ducpv on 12/6/17.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private static final int DISCOUNT_FRAGMENT = 0;
    private static final int FOLLOWING_FRAGMENT = 1;
    public static final int NOTIFICATION_FRAGMENT = 2;
    public static final int ACCOUNT_FRAGMENT = 3;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case DISCOUNT_FRAGMENT:
                return DiscountFragment.newInstance();
            case FOLLOWING_FRAGMENT:
                return FollowingFragment.newInstance();
            case NOTIFICATION_FRAGMENT:
                return NotificationFragment.newInstance();
            case ACCOUNT_FRAGMENT:
                return AccountFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
