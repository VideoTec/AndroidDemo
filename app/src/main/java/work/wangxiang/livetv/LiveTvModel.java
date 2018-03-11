package work.wangxiang.livetv;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class LiveTvModel implements LiveTvContract.Model {
    @Override
    public Observable<List<LiveTvBean>> getTvList() {
        ArrayList<LiveTvBean> videoList = new ArrayList<>();
        videoList.add(new LiveTvBean("CCTV-10", "http://223.82.250.72/ysten-business/live/cctv-10/1.m3u8"));
        return Observable.just(videoList);
    }
}