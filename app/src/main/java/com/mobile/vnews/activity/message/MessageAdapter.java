package com.mobile.vnews.activity.message;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobile.vnews.R;
import com.mobile.vnews.module.bean.Message;
import com.mobile.vnews.module.bean.News;
import com.mobile.vnews.util.TimeUtils;

import java.util.List;

/**
 * Created by xuantang on 12/20/17.
 */

public class MessageAdapter extends BaseItemDraggableAdapter<Message, BaseViewHolder> {

    public MessageAdapter(List<Message> data) {
        super(data);
    }

    public MessageAdapter(int layoutResId, List<Message> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Message item) {
        helper.setText(R.id.message_item_from, item.getFromUsername());
        // judge
        if (!TextUtils.isEmpty(item.getToID())) {
            helper.setText(R.id.message_item_action, "回复了");
            helper.setText(R.id.message_item_to, item.getToUsername());
        } else {
            helper.setText(R.id.message_item_action, "评论了");
            helper.setText(R.id.message_item_to, item.getTitle().length() > 10 ?
                    item.getTitle().substring(0, 10) : item.getTitle());
        }

        helper.setText(R.id.message_item_date, TimeUtils.millis2String(item.getTimestamp()));
        helper.setText(R.id.message_item_content, item.getContent());

        Glide.with(mContext).load(item.getFromImage()).into((ImageView) helper.getView(R.id.message_item_image));
    }
}