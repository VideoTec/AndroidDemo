package work.wangxiang.ijktest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import work.wangxiang.androiddemo.R;

/**
 * IjkPlayerFragment
 * Created by wangxiang on 2018/3/10.
 */

public class IjkPlayerFragment extends Fragment {
    private final static String TAG = "IjkPlayerFragment";
    public final static String EXTRA_VIDEO_PATH = "extra_video_path";

    private SurfaceView surfaceView;
    private String videoPath;
    private IjkMediaPlayer ijkPlayer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            videoPath = args.getString(EXTRA_VIDEO_PATH);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ijkplaer, container, false);
        surfaceView = rootView.findViewById(R.id.sv_ijkplayer);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                startPlay();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                stopPlay();
            }
        });

        rootView.findViewById(R.id.btn_start_play).setOnClickListener(v -> {
            startPlay();
        });
        rootView.findViewById(R.id.btn_stop_play).setOnClickListener(v -> {
            stopPlay();
        });
        return rootView;
    }

    private void stopPlay() {
        if (ijkPlayer != null) {
            ijkPlayer.release();
            ijkPlayer = null;
        }
    }

    private void startPlay() {
        stopPlay();
        ijkPlayer = new IjkMediaPlayer();
        try {
            ijkPlayer.setDataSource(videoPath);
            ijkPlayer.setSurface(surfaceView.getHolder().getSurface());
            ijkPlayer.prepareAsync();
            ijkPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(IMediaPlayer iMediaPlayer) {
                    iMediaPlayer.start();
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "播放异常", e);
        }
    }
}
