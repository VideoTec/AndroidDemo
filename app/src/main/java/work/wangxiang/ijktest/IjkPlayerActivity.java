package work.wangxiang.ijktest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import work.wangxiang.android.view.SingleFragmentActivity;
import work.wangxiang.utils.Const;

/**
 * IjkPlayerActivity
 * Created by wangxiang on 2018/3/10.
 */

public class IjkPlayerActivity extends SingleFragmentActivity {
    private final static String TAG = "IjkPlayerActivity";

    private String videoPath;

    public static void startIjkPlayerActivity(Context context, String path) {
        Intent intent = new Intent(context, IjkPlayerActivity.class);
        intent.putExtra(Const.EXTRA_VIDEO_PATH, path);
        context.startActivity(intent);
    }

    @Override
    protected void getIntentArgs() {
        Intent intent = getIntent();
        videoPath = intent.getStringExtra(Const.EXTRA_VIDEO_PATH);
    }

    @Override
    protected Fragment getFragment() {
        IjkPlayerFragment ijkPlayerFragment = new IjkPlayerFragment();
        Bundle arg = new Bundle();
        arg.putString(Const.EXTRA_VIDEO_PATH, videoPath);
        ijkPlayerFragment.setArguments(arg);
        return ijkPlayerFragment;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
