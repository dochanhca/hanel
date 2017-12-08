package com.example.ducpv.haneldemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.model.BrandItem;

import java.util.List;

/**
 * Created by ducpv on 12/7/17.
 */

public class FollowingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<BrandItem> brandItems;

    public FollowingAdapter(Context context, List<BrandItem> brandItems) {
        this.context = context;
        this.brandItems = brandItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if (viewType == BrandItem.GROUP_TYPE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_brand_group, parent, false);
            viewHolder = new GroupViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_brand_item, parent, false);
            viewHolder = new ChildViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BrandItem item = brandItems.get(position);
        if (holder.getItemViewType() == BrandItem.GROUP_TYPE) {
            GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
            groupViewHolder.txtBrandName.setText(item.getBrandName());
        } else {
            ChildViewHolder childViewHolder = (ChildViewHolder) holder;
            childViewHolder.imgLike.setImageResource(item.isLike() ? R.drawable.ic_star_selected
                    : R.drawable.ic_star);
            childViewHolder.imgLogo.setImageResource(item.getLogo());
            childViewHolder.brandName.setText(item.getBrandName());
            childViewHolder.txtDiscountNum.setText(item.getDiscountNum());
        }
    }

    @Override
    public int getItemCount() {
        return brandItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return brandItems.get(position).getType();
    }

    static class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView txtBrandName;

        public GroupViewHolder(View itemView) {
            super(itemView);
            txtBrandName = itemView.findViewById(R.id.txt_brand_name);
        }
    }

    static class ChildViewHolder extends RecyclerView.ViewHolder {

        ImageView imgLike;
        ImageView imgLogo;
        TextView brandName;
        TextView txtDiscountNum;


        public ChildViewHolder(View itemView) {
            super(itemView);
            imgLike = itemView.findViewById(R.id.img_like);
            imgLogo = itemView.findViewById(R.id.img_logo);
            brandName = itemView.findViewById(R.id.txt_brand_name);
            txtDiscountNum = itemView.findViewById(R.id.txt_discount_num);
        }
    }
}
