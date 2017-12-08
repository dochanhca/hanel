package com.example.ducpv.haneldemo.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.customuis.SquareImageView;
import com.example.ducpv.haneldemo.model.PromotionItem;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by ducpv on 12/7/17.
 */

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {

    private List<PromotionItem> promotionItems;
    private final Context context;

    public PromotionAdapter(Context context, List<PromotionItem> promotionItems) {
        this.promotionItems = promotionItems;
        this.context = context;
    }

    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promotion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PromotionItem item = promotionItems.get(position);

        DecimalFormat priceFormat = new DecimalFormat("#,###,###");

        holder.imgCover.setImageResource(item.getResouceId());
        holder.txtTitle.setText(item.getTitle());
        holder.txtDes.setText(item.getDes());
        holder.txtOldPrice.setText(priceFormat.format(item.getPrice()).replace(",", ".")
        +"đ");
        holder.txtNewPrice.setText(priceFormat.format(item.getPromoPrice()).replace(",", "."));

        holder.txtOldPrice.setPaintFlags(holder.txtOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return promotionItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        SquareImageView imgCover;
        TextView txtTitle;
        TextView txtDes;
        TextView txtOldPrice;
        TextView txtNewPrice;

        public ViewHolder(View root) {
            super(root);
            imgCover = root.findViewById(R.id.img_promotion_cover);
            txtTitle = root.findViewById(R.id.txt_promotion_title);
            txtDes = root.findViewById(R.id.txt_promotion_des);
            txtOldPrice = root.findViewById(R.id.txt_old_price);
            txtNewPrice = root.findViewById(R.id.txt_new_price);
        }

        public void setCoverSize() {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imgCover.getLayoutParams();

            layoutParams.height = imgCover.getHeight();
            layoutParams.width = imgCover.getHeight();
            imgCover.setLayoutParams(layoutParams);
        }
    }
}
