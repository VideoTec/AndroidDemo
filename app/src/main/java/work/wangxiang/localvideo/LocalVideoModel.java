package work.wangxiang.localvideo;

import android.database.Cursor;
import android.provider.MediaStore;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import work.wangxiang.android.common.App;

public class LocalVideoModel implements LocalVideoContract.Model {
    @Override
    public Observable<List<LocalVideoBean>> getVideoList() {
        return Observable.create(e -> {
            List<LocalVideoBean> videos = new LinkedList<>();
            Cursor cursor = App.getCtx().getContentResolver().query(
                    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                    new String[]{MediaStore.Video.Media.DATA},
                    null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        videos.add(new LocalVideoBean(cursor.getString(0)));
                    } while(cursor.moveToNext());
                }
                cursor.close();
            }
            e.onNext(videos);
            e.onComplete();
        });
    }
}