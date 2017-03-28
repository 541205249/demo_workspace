package jiazy.com.recycleviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jiazy.com.recycleviewdemo.MyRecycleAdapter.OnItemClickListener;


/**
 * 参考博客：http://blog.csdn.net/lmj623565791/article/details/45059587
 */
public class MainActivity extends Activity implements OnItemClickListener {
    private List<String> mDatas;
    private MyRecycleAdapter mRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initData();
        mRecycleAdapter = new MyRecycleAdapter(getApplicationContext(), mDatas);
        mRecycleAdapter.setOnItemClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
        recyclerView.setAdapter(mRecycleAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));

//        recyclerView.setItemAnimator(new SlideInOutLeftItemAnimator(recyclerView));
        //一个好用的动画库
        //https://github.com/gabrielemariotti/RecyclerViewItemAnimators
    }

    private void initData() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        mRecycleAdapter.addData(0);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getApplicationContext(), "onItemClick=" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(getApplicationContext(), "onItemLongClick=" + position, Toast.LENGTH_SHORT).show();
    }
}
