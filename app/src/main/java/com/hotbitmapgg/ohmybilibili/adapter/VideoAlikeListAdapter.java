package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.entity.user.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.network.auxiliary.UrlHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcc on 16/8/7 21:18
 * 100332338@qq.com
 * <p/>
 * 相关视频更多adapter
 */
public class VideoAlikeListAdapter extends AbsRecyclerViewAdapter
{

    private List<UserVideoItem> parts = new ArrayList<>();

    public VideoAlikeListAdapter(RecyclerView recyclerView, List<UserVideoItem> parts)
    {

        super(recyclerView);
        this.parts = parts;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.item_alike_video, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            UserVideoItem userVideoItem = parts.get(position);
            String pic = userVideoItem.pic;
            String play = userVideoItem.play;
            int video_review = userVideoItem.video_review;
            String title = userVideoItem.title;

            Picasso.with(getContext())
                    .load(UrlHelper.getClearVideoPreviewUrl(pic))
                    .placeholder(R.drawable.bili_default_image_tv)
                    .into(itemViewHolder.mVideoPic);

            itemViewHolder.mVideoTitle.setText(title);
            itemViewHolder.mVideoPlayNum.setText(play);
            itemViewHolder.mVideoReviewNum.setText(video_review + "");
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return parts.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        public ImageView mVideoPic;

        public TextView mVideoTitle;

        public TextView mVideoPlayNum;

        public TextView mVideoReviewNum;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.item_img);
            mVideoTitle = $(R.id.item_title);
            mVideoPlayNum = $(R.id.item_play);
            mVideoReviewNum = $(R.id.item_review);
        }
    }
}
