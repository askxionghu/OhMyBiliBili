package com.hotbitmapgg.ohmybilibili.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.video.Sp;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 * <p/>
 * 专题视频Adapter
 */
public class SpecialVideoRecyclerAdapter extends AbsRecyclerViewAdapter
{

    private List<Sp.Item> spItems = new ArrayList<>();

    public SpecialVideoRecyclerAdapter(RecyclerView recyclerView, List<Sp.Item> spItems)
    {

        super(recyclerView);
        this.spItems = spItems;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_sp_video, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            Sp.Item item = spItems.get(position);
            itemViewHolder.mSpNum.setText("第" + item.episode + "话");
            String cover = item.cover;
            Picasso.with(getContext())
                    .load(Uri.parse(cover))
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mPreviewImage);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return spItems.size();
    }

    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mPreviewImage;

        public TextView mSpNum;

        public ItemViewHolder(View itemView)
        {

            super(itemView);
            mPreviewImage = $(R.id.item_img);
            mSpNum = $(R.id.item_title);
        }
    }
}
