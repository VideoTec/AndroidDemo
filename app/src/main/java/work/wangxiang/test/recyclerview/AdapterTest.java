package work.wangxiang.test.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import work.wangxiang.androiddemo.R;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

/**
 * AdapterTest
 * Created by wangxiang on 2018/3/10.
 */
public class AdapterTest extends
        RecyclerView.Adapter<AdapterTest.ItemViewHolder> {
    private final static String TAG = "AdapterTest";
    private Context context;
    private List<String> dataSet;
    private View.OnClickListener onItemClickListener;

    AdapterTest(Context context, View.OnClickListener onItemClickListener) {
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    String getItemData(int position) {
        return dataSet.get(position);
    }

    void setDataSet(List<String> dataSet) {
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
        String item = dataSet.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;
        Button btnAddNewLine;
        Button btnDelete;

        ItemViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_type, parent, false));
            tvItem = itemView.findViewById(R.id.tv_item);
            btnAddNewLine = itemView.findViewById(R.id.btn_add);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }

        void bind(String model) {
            tvItem.setText(model);
            itemView.setOnClickListener(onItemClickListener);
            btnAddNewLine.setOnClickListener(v -> {
                int adapterPosition = getAdapterPosition();
                dataSet.add(adapterPosition, "新加一行 " + adapterPosition);
                notifyItemInserted(adapterPosition);
                logPosition();
            });
            btnDelete.setOnClickListener(v -> {
                int adapterPosition = getAdapterPosition();
                dataSet.remove(adapterPosition);
                notifyItemRemoved(adapterPosition);
                logPosition();
            });
        }

        private void logPosition() {
            Log.i(TAG, "adapterPosition " + getAdapterPosition()
                    + "; layoutPosition: " + getLayoutPosition());
        }
    }
}