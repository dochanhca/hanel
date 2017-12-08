package com.example.ducpv.haneldemo.fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.activity.PromotionDetailActivitty;
import com.example.ducpv.haneldemo.adapter.PromotionAdapter;
import com.example.ducpv.haneldemo.model.PromotionItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ducpv on 12/6/17.
 */

public class NewestFragment extends BaseFragment {

    @BindView(R.id.img_cover)
    ImageView imgCover;
    @BindView(R.id.txt_other_promotion)
    TextView txtOtherPromotion;
    @BindView(R.id.recycler_promotion)
    RecyclerView recyclerPromotion;
    @BindView(R.id.txt_chat_count)
    TextView txtChatCount;
    @BindView(R.id.img_chat)
    ImageView imgChat;

    Unbinder unbinder;

    public static NewestFragment newInstance() {
        Bundle args = new Bundle();
        NewestFragment fragment = new NewestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_newest;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, rootView);

        txtChatCount.setVisibility(View.GONE);
        imgChat.setVisibility(View.GONE);

        txtOtherPromotion.setPaintFlags(txtOtherPromotion.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

        PromotionAdapter promotionAdapter = new PromotionAdapter(getActivity().getApplicationContext(),
                getMockDatas());
        recyclerPromotion.setAdapter(promotionAdapter);
        recyclerPromotion.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.img_cover)
    public void onClick(View view) {
        if (view.getId() == R.id.img_cover) {
            Intent intent = new Intent(getActivity(), PromotionDetailActivitty.class);
            startActivity(intent);
        }
    }

    private List<PromotionItem> getMockDatas() {
        List<PromotionItem> promotionItems = new ArrayList<>();

        PromotionItem promotionItem = new PromotionItem();
        promotionItem.setTitle(getString(R.string.promotion_title));
        promotionItem.setDes(getString(R.string.promotion_des));
        promotionItem.setPrice(1058000);
        promotionItem.setPromoPrice(900000);
        promotionItem.setResouceId(R.drawable.img_promotion_1);

        promotionItems.add(promotionItem);
        promotionItems.add(promotionItem);
        return promotionItems;
    }
}
