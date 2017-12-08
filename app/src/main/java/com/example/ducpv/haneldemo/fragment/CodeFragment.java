package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.adapter.CodeAdapter;
import com.example.ducpv.haneldemo.model.CodeItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by ducpv on 12/7/17.
 */

public class CodeFragment extends BaseFragment {

    @BindView(R.id.img_user)
    ImageView imgUser;
    @BindView(R.id.txt_user_name)
    TextView txtUserName;
    @BindView(R.id.img_edit)
    ImageView imgEdit;
    @BindView(R.id.recycler_code)
    RecyclerView recyclerCode;
    Unbinder unbinder;

    private CodeAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_code;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, rootView);
        initRecyclerCode();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.img_edit)
    public void onViewClicked() {
    }

    private void initRecyclerCode() {
        adapter = new CodeAdapter(getActivity().getApplicationContext(), getMockDatas());
        recyclerCode.setAdapter(adapter);
        recyclerCode.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        recyclerCode.addItemDecoration(dividerItemDecoration);
    }

    private List<CodeItem> getMockDatas() {
        List<CodeItem> nearByItems = new ArrayList<>();

        CodeItem item = new CodeItem();
        item.setResourceId(R.drawable.img_promotion_1);
        item.setCodeName("Gift code miễn phí");
        item.setCodeDetail("CODE: 194G-6SH-542M (đã hết hạn)");

        CodeItem item2 = item;
        item2.setCodeName("Gift code 100k");

        nearByItems.add(item);
        nearByItems.add(item2);

        return nearByItems;
    }
}
