package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.adapter.FollowingAdapter;
import com.example.ducpv.haneldemo.model.BrandItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducpv on 12/6/17.
 */

public class FollowingFragment extends BaseFragment {

    private FollowingAdapter adapter;
    private RecyclerView recyclerFollowing;

    public static FollowingFragment newInstance() {
        Bundle args = new Bundle();
        FollowingFragment fragment = new FollowingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_following;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        setHeaderTitle(getString(R.string.following));
        showRightAcButton();

        recyclerFollowing = rootView.findViewById(R.id.recycler_following);
        initRecyclerFollowing();
    }

    private void initRecyclerFollowing() {
        adapter = new FollowingAdapter(getActivity().getApplicationContext(), getMockDatas());

        recyclerFollowing.setAdapter(adapter);
        recyclerFollowing.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        recyclerFollowing.addItemDecoration(dividerItemDecoration);
    }

    private List<BrandItem> getMockDatas() {
        List<BrandItem> brandItems = new ArrayList<>();

        BrandItem favoriteBrand = new BrandItem();
        favoriteBrand.setBrandName("Thương hiệu yêu thích");
        favoriteBrand.setType(BrandItem.GROUP_TYPE);
        BrandItem samsung = new BrandItem("SAMSUNG", "2 ưu đãi",
                R.drawable.ss, true, BrandItem.CHILD_TYPE);
        BrandItem acb = new BrandItem("NH ACB", "2 ưu đãi",
                R.drawable.img_acb_logo, true, BrandItem.CHILD_TYPE);

        BrandItem otherBrand = new BrandItem();
        otherBrand.setBrandName("Thương hiệu khác");
        otherBrand.setType(BrandItem.GROUP_TYPE);
        BrandItem nike = new BrandItem("Nike", "2 ưu đãi",
                R.drawable.nike, false, BrandItem.CHILD_TYPE);
        BrandItem canifa = new BrandItem("Canifa", "2 ưu đãi",
                R.drawable.canifa, false, BrandItem.CHILD_TYPE);
        BrandItem mcDonals = new BrandItem("McDonald's", "2 ưu đãi",
                R.drawable.mcdonal, false, BrandItem.CHILD_TYPE);
        BrandItem kfc = new BrandItem("KFC", "2 ưu đãi",
                R.drawable.kfc, false, BrandItem.CHILD_TYPE);

        brandItems.add(favoriteBrand);
        brandItems.add(samsung);
        brandItems.add(acb);
        brandItems.add(otherBrand);
        brandItems.add(nike);
        brandItems.add(canifa);
        brandItems.add(mcDonals);
        brandItems.add(kfc);

        return brandItems;
    }
}
