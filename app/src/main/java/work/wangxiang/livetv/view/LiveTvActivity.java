package work.wangxiang.livetv.view;

import android.support.v4.app.Fragment;

import work.wangxiang.android.view.SingleFragmentActivity;

/**
 * LiveTvActivity
 * Created by wangxiang on 2018/3/11.
 */

public class LiveTvActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new LiveTvFragment();
    }
}
