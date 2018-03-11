package work.wangxiang.livetv;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import work.wangxiang.android.rxmvp.PresenterBase;

public class LiveTvPresenter
        extends PresenterBase<LiveTvContract.Model, LiveTvContract.View>
        implements LiveTvContract.Presenter {

    private final static String TAG = "LiveTvPresenter";

    @Override
    public void getTvList() {
        model.getTvList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LiveTvBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(List<LiveTvBean> liveTvBeans) {
                        view.updateTvList(liveTvBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "请求失败", e);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "请求完成");
                    }
                });
    }
}