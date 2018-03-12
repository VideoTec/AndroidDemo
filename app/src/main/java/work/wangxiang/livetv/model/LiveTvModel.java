package work.wangxiang.livetv.model;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import work.wangxiang.livetv.LiveTvBean;
import work.wangxiang.livetv.LiveTvContract;
import work.wangxiang.utils.Const;

public class LiveTvModel implements LiveTvContract.Model {
    private WorkService workService;

    public LiveTvModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.WORK_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        workService = retrofit.create(WorkService.class);
    }

    @Override
    public Observable<List<LiveTvBean>> getTvList() {
        return workService.getLiveTvList();
    }
}