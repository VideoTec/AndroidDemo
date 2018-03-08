package work.wangxiang.localvideo.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import work.wangxiang.androiddemo.R;

public class VideoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment videoListFrag = fragmentManager.findFragmentById(R.id.fragment_container);

        if (videoListFrag == null) {
            videoListFrag = new VideoListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, videoListFrag)
                    .commit();
        }
    }
}
