package com.example.ducpv.haneldemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ducpv.haneldemo.R;
import com.example.ducpv.haneldemo.customuis.SquareImageView;
import com.example.ducpv.haneldemo.model.CodeItem;

import java.util.List;

/**
 * Created by ducpv on 12/7/17.
 */

public class CodeAdapter extends RecyclerView.Adapter<CodeAdapter.ViewHolder> {

    private List<CodeItem> codeItems;
    private final Context context;

    public CodeAdapter(Context context, List<CodeItem> codeItems) {
        this.codeItems = codeItems;
        this.context = context;
    }

    @Override
    public CodeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_code, parent, false);
        return new CodeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CodeAdapter.ViewHolder holder, int position) {
        CodeItem item = codeItems.get(position);

        holder.imgCover.setImageResource(item.getResourceId());
        holder.txtCodeName.setText(item.getCodeName());
        holder.txtCodeDetail.setText(item.getCodeDetail());
    }

    @Override
    public int getItemCount() {
        return codeItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        SquareImageView imgCover;
        TextView txtCodeName;
        TextView txtCodeDetail;

        public ViewHolder(View root) {
            super(root);
            imgCover = root.findViewById(R.id.img_nearby_cover);
            txtCodeName = root.findViewById(R.id.txt_code_name);
            txtCodeDetail = root.findViewById(R.id.txt_code_detail);
        }
    }
}
