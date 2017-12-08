package com.example.ducpv.haneldemo.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ducpv on 12/8/17.
 */

public class MyInfoFragment extends BaseFragment {

    @BindView(R.id.img_user)
    ImageView imgUser;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.img_edit)
    ImageView imgEdit;

    Unbinder unbinder;

    @Override
    protected int layoutId() {
        return R.layout.fragment_my_info;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, rootView);

        SharedPreferences sharedPreferences = getActivity().
                getSharedPreferences(Constant.HANEL_PREFRENCES, MODE_PRIVATE);

        String userName = sharedPreferences.getString(Constant.USER_NAME, "Hanel Company");
        txtUserName.setText(userName);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.img_edit)
    public void onViewClicked() {
    }
}
