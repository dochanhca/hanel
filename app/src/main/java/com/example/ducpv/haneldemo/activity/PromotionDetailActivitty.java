package com.example.ducpv.haneldemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ducpv on 12/7/17.
 */

public class PromotionDetailActivitty extends AppCompatActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.img_right_ac_bar)
    ImageView imgRightAcBar;
    @BindView(R.id.txt_action_bar_title)
    AppCompatTextView txtActionBarTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.txt_promotion_summary)
    TextView txtPromotionSummary;
    @BindView(R.id.img_send)
    ImageView imgSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_detail);
        ButterKnife.bind(this);

        imgBack.setVisibility(View.VISIBLE);
        imgRightAcBar.setVisibility(View.VISIBLE);
        imgLogo.setVisibility(View.GONE);
        txtActionBarTitle.setVisibility(View.GONE);

    }

    @OnClick({R.id.img_back, R.id.img_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                this.finish();
                break;
            case R.id.img_send:
                break;
        }
    }
}
