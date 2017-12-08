package com.example.ducpv.haneldemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.adapter.PromotionAdapter;
import com.example.ducpv.haneldemo.model.PromotionItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ducpv on 12/7/17.
 */

public class MyDiscountFragment extends BaseFragment {

    @BindView(R.id.recycler_promotion)
    RecyclerView recyclerPromotion;
    Unbinder unbinder;

    private PromotionAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_my_discount;
    }

    @Override
    protected void init(View rootView, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, rootView);

        initRecyclerView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initRecyclerView() {
        adapter = new PromotionAdapter(getActivity().getApplicationContext(), getMockDatas());
        recyclerPromotion.setAdapter(adapter);
        recyclerPromotion.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        recyclerPromotion.addItemDecoration(dividerItemDecoration);
    }

    private List<PromotionItem> getMockDatas() {
        List<PromotionItem> promotionItems = new ArrayList<>();

        PromotionItem item1 = new PromotionItem("Black Friday rộn ràng cùng ưu đãi lên đến 50% ",
                "Tận huởng black friday - cơ hội mua sắm đặc biệt cho chính bạn hoặc người thân yêu " +
                        "với ưu đãi lên đến 50% cho chủ thẻ tín dụng ACB tại những đối tác chọn lọc", R.drawable.img_black_friday, "31/12/2017");

        PromotionItem item2 = new PromotionItem("Ưu đãi đặc biệt giảm 30% tại nhà hàng rơm BBQ ",
                "Cùng thưởng thức các món ăn mang đậm hương vị Việt và tận hưởng không gian thoáng" +
                        "đãng từ trên cao tại nhà hàng rơm BBQ cùng thẻ Tín dụng ACB và nhận ưu đãi giảm 30%", R.drawable.img_rom_bbg, "13/12/2017");

        PromotionItem item3 = new PromotionItem("Ưu đãi đặc biệt giảm 30% tại Chili Thái",
                "Cùng thưởng thức các món ăn mang đậm hương vị Việt và tận hưởng không gian thanh " +
                        " nhã tại nhà hàng rơm BBQ cùng thẻ Tín dụng ACB và nhận ưu đãi giảm 30%", R.drawable.img_chili_thai, "31/12/2017");
        promotionItems.add(item1);
        promotionItems.add(item2);
        promotionItems.add(item3);

        return promotionItems;
    }
}
