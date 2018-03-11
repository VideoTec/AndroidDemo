package work.wangxiang.livetv.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import work.wangxiang.livetv.LiveTvBean;

/**
 * WorkService
 * Created by wangxiang on 2018/3/11.
 */

public interface WorkService {
    @GET("/res/live-tv-uris")
    Observable<List<LiveTvBean>> getLiveTvList();
}
