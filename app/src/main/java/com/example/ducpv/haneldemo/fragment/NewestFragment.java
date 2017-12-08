package com.example.ducpv.haneldemo.fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.activity.PromotionDetailActivitty;
import com.example.ducpv.haneldemo.adapter.NewestAdapter;
import com.example.ducpv.haneldemo.model.NewestItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ducpv on 12/6/17.
 */

public class NewestFragment extends BaseFragment implements NewestAdapter.PromotionClickListener {

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

        NewestAdapter newestAdapter = new NewestAdapter(getActivity().getApplicationContext(),
                getMockDatas());
        newestAdapter.setPromotionClickListener(this);

        recyclerPromotion.setAdapter(newestAdapter);
        recyclerPromotion.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        recyclerPromotion.addItemDecoration(dividerItemDecoration);
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

    private List<NewestItem> getMockDatas() {
        List<NewestItem> newestItems = new ArrayList<>();

        NewestItem newestItem = new NewestItem(getString(R.string.promotion_title),
                getString(R.string.promotion_des), R.drawable.img_promotion_1,1058000, 900000);

        NewestItem newestItem2 = new NewestItem("Buôn thả ga với Moca",
                "Giảm ngay 30k khi nạp tiền điện thoại và mua mã thẻ với" +
                        "Moca, Áp dụng cho chủ thẻ lần đầu tiên sử dụng Moca từ 16/01 - 16/08/2017", R.drawable.image_promotion_2,1058000, 900000);

        newestItems.add(newestItem2);
        newestItems.add(newestItem);
        return newestItems;
    }

    @Override
    public void onPromotionItemClick(NewestItem item) {
        Intent intent = new Intent(getActivity(), PromotionDetailActivitty.class);

        startActivity(intent);
    }
}
