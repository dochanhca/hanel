package com.example.ducpv.haneldemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.customuis.SquareImageView;
import com.example.ducpv.haneldemo.model.NearByItem;

import java.util.List;

/**
 * Created by ducpv on 12/7/17.
 */

public class NearByAdapter extends RecyclerView.Adapter<NearByAdapter.ViewHolder> {

    private List<NearByItem> nearByItems;
    private final Context context;

    public NearByAdapter(Context context, List<NearByItem> nearByItems) {
        this.nearByItems = nearByItems;
        this.context = context;
    }

    @Override
    public NearByAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_near_by, parent, false);
        return new NearByAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NearByAdapter.ViewHolder holder, int position) {
        NearByItem item = nearByItems.get(position);

        holder.imgCover.setImageResource(item.getResourceId());
        holder.txtName.setText(item.getShopName());
        holder.txtAddress.setText(item.getAddress());
        holder.txtIp.setText(item.getIp());
        holder.txtDiscountNum.setText(item.getDiscount());
    }

    @Override
    public int getItemCount() {
        return nearByItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        SquareImageView imgCover;
        TextView txtName;
        TextView txtAddress;
        TextView txtIp;
        TextView txtDiscountNum;

        public ViewHolder(View root) {
            super(root);
            imgCover = root.findViewById(R.id.img_nearby_cover);
            txtName = root.findViewById(R.id.txt_name);
            txtAddress= root.findViewById(R.id.txt_address);
            txtIp = root.findViewById(R.id.txt_ip);
            txtDiscountNum = root.findViewById(R.id.txt_discount_num);
        }
    }
}
