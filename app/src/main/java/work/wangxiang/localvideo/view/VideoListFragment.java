package work.wangxiang.localvideo.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import work.wangxiang.android.rxmvp.RxMvpFragment;
import work.wangxiang.androiddemo.R;
import work.wangxiang.localvideo.LocalVideoBean;
import work.wangxiang.localvideo.LocalVideoContract;
import work.wangxiang.localvideo.LocalVideoModel;
import work.wangxiang.localvideo.LocalVideoPresenter;

/**
 * video list fragment
 * Created by wangxiang on 2018/3/7.
 */

public class VideoListFragment extends RxMvpFragment<LocalVideoModel, LocalVideoPresenter>
        implements LocalVideoContract.View {
    private final static String TAG = "VideoListFragment";
    private VideoListAdapter videoListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_list;
    }

    @Override
    protected void initView(View rootView) {
        RecyclerView videoRecyclerView = rootView.findViewById(R.id.rv_video_list);
        videoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        videoListAdapter = new VideoListAdapter(getActivity(), v -> {
            int pos = videoRecyclerView.getChildAdapterPosition(v);
            LocalVideoBean video = videoListAdapter.getItem(pos);
            Log.i(TAG, "点击了视频 " + video.getPath());
        });
        videoRecyclerView.setAdapter(videoListAdapter);
    }

    @Override
    protected void initData() {
        presenter.getVideoList();
    }

    @Override
    public void updateVideoList(List<LocalVideoBean> videoList) {
        videoListAdapter.setData(videoList);
        videoListAdapter.notifyDataSetChanged();
    }
}
