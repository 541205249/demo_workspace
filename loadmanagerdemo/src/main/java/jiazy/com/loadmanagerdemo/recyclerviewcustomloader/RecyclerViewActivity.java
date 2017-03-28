package jiazy.com.loadmanagerdemo.recyclerviewcustomloader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import jiazy.com.loadmanagerdemo.R;
import jiazy.com.loadmanagerdemo.customloader.ContactEntry;
import jiazy.com.loadmanagerdemo.customloader.CustomContactLoader;


/**
 * 参考博客：http://blog.csdn.net/lmj623565791/article/details/45059587
 */
public class RecyclerViewActivity extends Activity  implements LoaderManager.LoaderCallbacks<List<ContactEntry>>, CursorRecycleAdapter.OnItemClickListener {
    private CursorRecycleAdapter mRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initViews();
        initLoaderManager();
    }

    private void initViews() {
        mRecycleAdapter = new CursorRecycleAdapter(getApplicationContext());
        mRecycleAdapter.setOnItemClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
        recyclerView.setAdapter(mRecycleAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
    }

    private void initLoaderManager() {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getApplicationContext(), "onItemClick=" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(getApplicationContext(), "onItemLongClick=" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<List<ContactEntry>> onCreateLoader(int id, Bundle args) {
        return new CustomContactLoader(getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<List<ContactEntry>> loader, List<ContactEntry> data) {
        mRecycleAdapter.setContactList(data);
    }

    @Override
    public void onLoaderReset(Loader<List<ContactEntry>> loader) {
        mRecycleAdapter.setContactList(null);
    }
}
