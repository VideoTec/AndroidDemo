package work.wangxiang.androiddemo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.alimuzaffar.lib.pin.PinEntryEditText;

import work.wangxiang.android.common.App;
import work.wangxiang.android.common.Utils;
import work.wangxiang.livetv.view.LiveTvActivity;
import work.wangxiang.localvideo.view.VideoListActivity;
import work.wangxiang.test.recyclerview.ActivityFragmentTest;

public class MainActivity extends AppCompatActivity {
    PinEntryEditText pinEntryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pinEntryEditText = findViewById(R.id.pinEntryEditText);
        //pinEntryEditText.setFocusable(true);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public void onLoadLocalVideo(View view) {
        //VideoListActivity.openVideoList(this);
        pinEntryEditText.requestFocus();
        App.getCtx().showSoftKeyboard(pinEntryEditText);
    }

    public void onRecyclerViewTest(View view) {
        startActivity(new Intent(this, ActivityFragmentTest.class));
    }

    public void onLoadLiveTv(View view) {
        //startActivity(new Intent(this, LiveTvActivity.class));
        App.getCtx().hideSoftKeyboard(pinEntryEditText);
    }
}
