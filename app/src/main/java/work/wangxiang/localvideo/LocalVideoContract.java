package work.wangxiang.localvideo;

import java.util.List;

import io.reactivex.Observable;

public interface LocalVideoContract {
    interface Model {
        Observable<List<LocalVideoBean>> getVideoList();
    }

    interface View {
        void updateVideoList(List<LocalVideoBean> videoList);
    }

    interface Presenter {
        void getVideoList();
    }
}