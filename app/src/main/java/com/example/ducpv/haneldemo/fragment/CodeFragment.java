package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.adapter.CodeAdapter;
import com.example.ducpv.haneldemo.model.CodeItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ducpv on 12/7/17.
 */

public class CodeFragment extends BaseFragment {

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

        CodeItem item2 = new CodeItem();
        item2.setCodeName("Gift code 100k");
        item2.setCodeDetail("CODE: 194G-6SH-542M (đã hết hạn)");
        item2.setResourceId(R.drawable.img_promotion_1);

        nearByItems.add(item);
        nearByItems.add(item2);

        return nearByItems;
    }
}
