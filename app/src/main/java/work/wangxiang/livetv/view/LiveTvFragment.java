package work.wangxiang.livetv.view;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import work.wangxiang.android.rxmvp.RxMvpFragment;
import work.wangxiang.androiddemo.R;
import work.wangxiang.ijktest.IjkPlayerActivity;
import work.wangxiang.livetv.LiveTvBean;
import work.wangxiang.livetv.LiveTvContract;
import work.wangxiang.livetv.model.LiveTvModel;
import work.wangxiang.livetv.LiveTvPresenter;

/**
 * LiveTvFragment
 * Created by wangxiang on 2018/3/11.
 */

public class LiveTvFragment extends RxMvpFragment<LiveTvModel, LiveTvPresenter>
        implements LiveTvContract.View {
    private LiveTvAdapter liveTvAdapter;

    @Override
    public void updateTvList(List<LiveTvBean> videoList) {
        liveTvAdapter.setDataSet(videoList);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live_tv;
    }

    @Override
    protected void initView(View rootView, ViewDataBinding binding) {
        RecyclerView rvLiveTv = rootView.findViewById(R.id.rv_live_tv_list);
        rvLiveTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        liveTvAdapter = new LiveTvAdapter(getActivity(), v -> {
            LiveTvBean tv = liveTvAdapter.getItemData(rvLiveTv.getChildAdapterPosition(v));
            IjkPlayerActivity.startIjkPlayerActivity(getActivity(), tv.getUri());
        });
        rvLiveTv.setAdapter(liveTvAdapter);
    }

    @Override
    protected void initData() {
        presenter.getTvList();
    }
}
