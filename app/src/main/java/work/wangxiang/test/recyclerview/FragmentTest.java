package work.wangxiang.test.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import work.wangxiang.androiddemo.R;

/**
 * fragment test
 * Created by wangxiang on 2018/3/10.
 */

public class FragmentTest extends Fragment {
    private RecyclerView recyclerView;
    private AdapterTest adapterTest;

    private List<String> dataTest = new LinkedList<String>(){{
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
    }};

    private final static String TAG = "FragmentTest";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        recyclerView = rootView.findViewById(R.id.rv_test);
        adapterTest = new AdapterTest(getActivity(), v -> {
            int adapterPosition = recyclerView.getChildAdapterPosition(v);
            String text = adapterTest.getItemData(adapterPosition);
            Toast.makeText(getActivity(), "点击了 " + text, Toast.LENGTH_SHORT).show();
        });
        recyclerView.setAdapter(adapterTest);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapterTest.setDataSet(dataTest);
        return rootView;
    }
}
