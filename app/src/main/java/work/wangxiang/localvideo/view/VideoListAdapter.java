package work.wangxiang.localvideo.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import work.wangxiang.androiddemo.GlideApp;
import work.wangxiang.androiddemo.R;
import work.wangxiang.localvideo.LocalVideoBean;

/**
 * video list adapter
 * Created by wangxiang on 2018/3/8.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoItem> {
    private Context context;
    private List<LocalVideoBean> videoSet;
    private View.OnClickListener onItemClickListener;

    VideoListAdapter(Context context, View.OnClickListener l) {
        this.context = context;
        this.onItemClickListener = l;
    }

    public void setData(List<LocalVideoBean> videos) {
        videoSet = videos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoItem(LayoutInflater.from(context), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoItem holder, int position) {
        holder.bind(videoSet.get(position));
    }

    @Override
    public int getItemCount() {
        return videoSet == null ? 0 : videoSet.size();
    }

    LocalVideoBean getItem(int position) {
        return videoSet.get(position);
    }

    class VideoItem extends RecyclerView.ViewHolder {
        private ImageView ivThumb;

        VideoItem(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_local_video, parent, false));
            ivThumb = itemView.findViewById(R.id.iv_thumb);
        }

        void bind(LocalVideoBean video) {
            GlideApp.with(context)
                    .load(video.getPath())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .into(ivThumb);
            itemView.setOnClickListener(onItemClickListener);
        }
    }
}
