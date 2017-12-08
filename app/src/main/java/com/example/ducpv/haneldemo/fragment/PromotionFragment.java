package com.example.ducpv.haneldemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.activity.PromotionDetailActivitty;
import com.example.ducpv.haneldemo.adapter.PromotionAdapter;
import com.example.ducpv.haneldemo.model.PromotionItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ducpv on 12/6/17.
 */

public class PromotionFragment extends BaseFragment implements PromotionAdapter.PromotionClickListener {

    @BindView(R.id.recycler_promotion)
    RecyclerView recyclerPromotion;
    Unbinder unbinder;

    private PromotionAdapter adapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_promotion;
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
        adapter.setPromotionClickListener(this);
        recyclerPromotion.setAdapter(adapter);
        recyclerPromotion.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        recyclerPromotion.addItemDecoration(dividerItemDecoration);
    }

    private List<PromotionItem> getMockDatas() {
        List<PromotionItem> promotionItems = new ArrayList<>();

        PromotionItem item1 = new PromotionItem("Bay miễn phí, tại sao không?",
                "Tặng ngay 2000 dặm bay khi mở thẻ ACB Visa Platinum - Vietnam Airlines và nhân đôi " +
                        "dặm thưởng khi chi tiêu tại Agoda", R.drawable.img_free_travel, "20/12/2017");

        PromotionItem item2 = new PromotionItem("Black Friday rộn ràng cùng ưu đãi lên đến 50% ",
                "Tận huởng black friday - cơ hội mua sắm đặc biệt cho chính bạn hoặc người thân yêu " +
                        "với ưu đãi lên đến 50% cho chủ thẻ tín dụng ACB tại những đối tác chọn lọc", R.drawable.img_black_friday, "31/12/2017");

        PromotionItem item3 = new PromotionItem("Ưu đãi đặc biệt giảm 30% tại nhà hàng Bò nướng tảng ",
                "Cùng thưởng thức các món ăn mang đậm hương vị Việt và tận hưởng không gian thoáng" +
                        "đãng từ trên cao tại nhà hàng bỏ nướng tảng cùng thẻ Tín dụng ACB và nhận ưu đãi giảm 30%", R.drawable.img_bo_nuong, "13/12/2017");

        PromotionItem item4 = new PromotionItem("Quẳng gánh lo đi mà vui sướng ",
                "Từ hôm nay khi mở thẻ tín dụng ACB Mastercard quý khách sẽ nhận ngay gói bảo hiểm " +
                        "và ưu đãi lên đến 4 triệu đồng", R.drawable.img_vui_suong, "31/12/2017");
        promotionItems.add(item1);
        promotionItems.add(item2);
        promotionItems.add(item3);
        promotionItems.add(item4);

        return promotionItems;
    }

    @Override
    public void onPromotionItemClick(PromotionItem item) {
        Intent intent = new Intent(getActivity(), PromotionDetailActivitty.class);

        startActivity(intent);
    }
}
