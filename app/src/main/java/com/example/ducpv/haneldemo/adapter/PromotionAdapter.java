package com.example.ducpv.haneldemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.customuis.SquareImageView;
import com.example.ducpv.haneldemo.model.PromotionItem;

import java.util.List;

/**
 * Created by ducpv on 12/8/17.
 */

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {

    private List<PromotionItem> promotionItems;
    private final Context context;

    private PromotionClickListener promotionClickListener;

    public PromotionAdapter(Context context, List<PromotionItem> promotionItems) {
        this.promotionItems = promotionItems;
        this.context = context;
    }

    public void setPromotionClickListener(PromotionClickListener promotionClickListener) {
        this.promotionClickListener = promotionClickListener;
    }

    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promotion, parent, false);
        return new PromotionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PromotionAdapter.ViewHolder holder, int position) {
        final PromotionItem item = promotionItems.get(position);

        holder.imgCover.setImageResource(item.getResouceId());
        holder.txtTitle.setText(item.getTitle());
        holder.txtDes.setText(item.getDes());
        holder.txtDate.setText(context.getString(R.string.expiry_date) + ": " + item.getDate());

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promotionClickListener.onPromotionItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return promotionItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        SquareImageView imgCover;
        TextView txtTitle;
        TextView txtDes;
        TextView txtDate;
        ViewGroup rootView;

        public ViewHolder(View root) {
            super(root);
            imgCover = root.findViewById(R.id.img_promotion_cover);
            txtTitle = root.findViewById(R.id.txt_promotion_title);
            txtDes = root.findViewById(R.id.txt_promotion_des);
            txtDate = root.findViewById(R.id.txt_date);
            rootView = root.findViewById(R.id.root_view);
        }
    }

    public interface PromotionClickListener {
        void onPromotionItemClick(PromotionItem item);
    }
}
