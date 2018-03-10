package work.wangxiang.localvideo.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import work.wangxiang.android.view.SingleFragmentActivity;
import work.wangxiang.androiddemo.R;

public class VideoListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new VideoListFragment();
    }
}
