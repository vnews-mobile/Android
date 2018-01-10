package com.mobile.vnews.activity.me.comment;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobile.vnews.R;
import com.mobile.vnews.module.bean.Comment;
import com.mobile.vnews.util.DateUtils;
import com.mobile.vnews.util.TimeUtils;

import java.util.List;

/**
 * Created by xuantang on 12/20/17.
 */

public class MeCommentAdapter extends BaseItemDraggableAdapter<Comment, BaseViewHolder> {

    public MeCommentAdapter(List<Comment> data) {
        super(data);
    }

    public MeCommentAdapter(int layoutResId, List<Comment> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Comment item) {

        helper.setText(R.id.comment_item_username, item.getFromUsername())
                .addOnClickListener(R.id.comment_item_like)
                .addOnClickListener(R.id.comment_item_reply);
        // If the content length more than 30 chars, then show 30 chars
        helper.setText(R.id.comment_item_like_num, String.valueOf(item.getLikeCount()));
        // more than 0 then visible
        helper.setText(R.id.comment_item_date, DateUtils.getChatTime(item.getTimestamp()));

        helper.setText(R.id.message_item_content, item.getContent());
        // image
        RequestOptions myOptions = new RequestOptions()
                .fitCenter()
                .centerCrop()
                .placeholder(R.drawable.placeholder);
        Glide.with(mContext).load(item.getFromImage()).apply(myOptions).into((ImageView) helper.getView(R.id.comment_item_image));
    }
}