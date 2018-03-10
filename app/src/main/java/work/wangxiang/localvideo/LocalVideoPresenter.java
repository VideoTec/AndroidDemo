package work.wangxiang.localvideo;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import work.wangxiang.android.rxmvp.PresenterBase;

public class LocalVideoPresenter
        extends PresenterBase<LocalVideoContract.Model, LocalVideoContract.View>
        implements LocalVideoContract.Presenter {
    private final static String TAG = "LocalVideoPresenter";

    @Override
    public void getVideoList() {
        model.getVideoList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LocalVideoBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(List<LocalVideoBean> localVideoBeans) {
                        view.updateVideoList(localVideoBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "获取本地视频列表出错", e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}