package work.wangxiang.livetv;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import work.wangxiang.android.rxmvp.PresenterBase;

public class LiveTvPresenter
        extends PresenterBase<LiveTvContract.Model, LiveTvContract.View>
        implements LiveTvContract.Presenter {
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

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}