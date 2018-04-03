package work.wangxiang.localvideo.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import work.wangxiang.android.view.SingleFragmentActivity;
import work.wangxiang.androiddemo.R;

public class VideoListActivity extends SingleFragmentActivity {
    public static void openVideoList(Activity act) {
        Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(act).toBundle();
        act.startActivity(new Intent(act, VideoListActivity.class), bundle);
    }

    @Override
    protected Fragment getFragment() {
        return new VideoListFragment();
    }
}
