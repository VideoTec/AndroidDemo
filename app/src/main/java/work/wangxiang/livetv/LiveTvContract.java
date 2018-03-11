package work.wangxiang.livetv;

import java.util.List;

import io.reactivex.Observable;

public interface LiveTvContract {
    interface Model {
        Observable<List<LiveTvBean>> getTvList();
    }

    interface View {
        void updateTvList(List<LiveTvBean> videoList);
    }

    interface Presenter {
        void getTvList();
    }
}