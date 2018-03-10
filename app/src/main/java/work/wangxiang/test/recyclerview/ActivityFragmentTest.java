package work.wangxiang.test.recyclerview;

import android.support.v4.app.Fragment;
import android.view.View;

import work.wangxiang.android.view.SingleFragmentActivity;

/**
 * ActivityFragmentTest
 * Created by wangxiang on 2018/3/10.
 */

public class ActivityFragmentTest extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new FragmentTest();
    }
}
