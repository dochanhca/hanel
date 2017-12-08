package com.example.ducpv.haneldemo.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.customuis.SquareImageView;
import com.example.ducpv.haneldemo.model.NewestItem;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by ducpv on 12/7/17.
 */

public class NewestAdapter extends RecyclerView.Adapter<NewestAdapter.ViewHolder> {

    private List<NewestItem> newestItems;
    private final Context context;

    private PromotionClickListener promotionClickListener;

    public NewestAdapter(Context context, List<NewestItem> newestItems) {
        this.newestItems = newestItems;
        this.context = context;
    }

    public void setPromotionClickListener(PromotionClickListener promotionClickListener) {
        this.promotionClickListener = promotionClickListener;
    }

    @Override
    public NewestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_newest, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final NewestItem item = newestItems.get(position);

        DecimalFormat priceFormat = new DecimalFormat("#,###,###");

        holder.imgCover.setImageResource(item.getResouceId());
        holder.txtTitle.setText(item.getTitle());
        holder.txtDes.setText(item.getDes());
        holder.txtOldPrice.setText(priceFormat.format(item.getPrice()).replace(",", ".")
        +"đ");
        holder.txtNewPrice.setText(priceFormat.format(item.getPromoPrice()).replace(",", "."));

        holder.txtOldPrice.setPaintFlags(holder.txtOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promotionClickListener.onPromotionItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newestItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        SquareImageView imgCover;
        TextView txtTitle;
        TextView txtDes;
        TextView txtOldPrice;
        TextView txtNewPrice;
        ViewGroup rootView;

        public ViewHolder(View root) {
            super(root);
            imgCover = root.findViewById(R.id.img_promotion_cover);
            txtTitle = root.findViewById(R.id.txt_promotion_title);
            txtDes = root.findViewById(R.id.txt_promotion_des);
            txtOldPrice = root.findViewById(R.id.txt_old_price);
            txtNewPrice = root.findViewById(R.id.txt_new_price);
            rootView = root.findViewById(R.id.root_view);
        }
    }

    public interface PromotionClickListener {
        void onPromotionItemClick(NewestItem item);
    }
}
