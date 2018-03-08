package work.wangxiang.localvideo.view;

import work.wangxiang.android.rxmvp.RxMvpFragment;
import work.wangxiang.androiddemo.R;
import work.wangxiang.localvideo.LocalVideoContract;
import work.wangxiang.localvideo.LocalVideoModel;
import work.wangxiang.localvideo.LocalVideoPresenter;

/**
 * video list frgament
 * Created by wangxiang on 2018/3/7.
 */

public class VideoListFragment extends RxMvpFragment<LocalVideoModel, LocalVideoPresenter>
        implements LocalVideoContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_list;
    }
}
