package work.wangxiang.androiddemo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import work.wangxiang.livetv.view.LiveTvActivity;
import work.wangxiang.localvideo.view.VideoListActivity;
import work.wangxiang.test.recyclerview.ActivityFragmentTest;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoadLocalVideo(View view) {
        startActivity(new Intent(this, VideoListActivity.class));
    }

    public void onRecyclerViewTest(View view) {
        startActivity(new Intent(this, ActivityFragmentTest.class));
    }

    public void onLoadLiveTv(View view) {
        startActivity(new Intent(this, LiveTvActivity.class));
    }
}
