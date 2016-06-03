package com.yueshenginfo.jncc.modules.department.adapter;

import android.content.Context;
import android.net.Uri;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.yueshenginfo.jncc.R;
import com.yueshenginfo.jncc.modules.department.dto.Status;
import com.yueshenginfo.jncc.publics.utils.DataProvider;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class QuickAdapter extends BaseQuickAdapter<Status> {
    public QuickAdapter(Context context) {
        super(context, R.layout.tweet, DataProvider.getSampleData(100));
    }

    public QuickAdapter(Context context, int dataSize) {
        super(context, R.layout.tweet, DataProvider.getSampleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        helper.setText(R.id.tweetName, item.getUserName())
                .setText(R.id.tweetText, item.getText())
                .setText(R.id.tweetDate, item.getCreatedAt())
                .setVisible(R.id.tweetRT, item.isRetweet())
                .setOnClickListener(R.id.tweetAvatar, new OnItemChildClickListener())
                .setOnClickListener(R.id.tweetName, new OnItemChildClickListener())
                .linkify(R.id.tweetText);

        SimpleDraweeView tweetAvatar = helper.getView(R.id.tweetAvatar);
        Uri uri = Uri.parse("http://zhuangbi.idagou.com/i/2016-06-01-60f01b4f479b2b7d738c607a341451a5.jpg");
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                // other setters
                .build();
        tweetAvatar.setController(controller);
    }

}
