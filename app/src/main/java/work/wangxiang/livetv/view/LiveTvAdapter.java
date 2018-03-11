package work.wangxiang.livetv.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import work.wangxiang.androiddemo.R;
import work.wangxiang.livetv.LiveTvBean;

/**
 * LiveTvAdapter
 * Created by wangxiang on 2018/3/11.
 */
public class LiveTvAdapter extends
        RecyclerView.Adapter<LiveTvAdapter.ItemViewHolder> {

    private Context context;
    private List<LiveTvBean> dataSet;
    private View.OnClickListener onItemClickListener;

    LiveTvAdapter(Context context, View.OnClickListener onItemClickListener) {
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    LiveTvBean getItemData(int position) {
        return dataSet.get(position);
    }

    void setDataSet(List<LiveTvBean> dataSet) {
        this.dataSet = dataSet;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        LiveTvBean item = dataSet.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvUri;

        ItemViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_live_tv, parent, false));
            tvName = itemView.findViewById(R.id.tv_name);
            tvUri = itemView.findViewById(R.id.tv_uri);
        }

        void bind(LiveTvBean model) {
            itemView.setOnClickListener(onItemClickListener);
            tvUri.setText(model.getUri());
            tvName.setText(model.getName());
        }
    }
}