package jiazy.com.loadmanagerdemo.customloader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import jiazy.com.loadmanagerdemo.R;

public class CustomLoaderActivity extends Activity implements LoaderManager.LoaderCallbacks<List<ContactEntry>> {

    private ContactsCustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_loader);
        initViews();
        initLoaderManager();
    }

    private void initViews() {
        ListView mListView = (ListView) findViewById(R.id.lv_list);
        mAdapter = new ContactsCustomAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
    }

    private void initLoaderManager() {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<ContactEntry>> onCreateLoader(int id, Bundle args) {
        return new CustomContactLoader(getApplicationContext());
    }

    @Override
    public void onLoadFinished(Loader<List<ContactEntry>> loader, List<ContactEntry> data) {
        mAdapter.setContactList(data);
    }

    @Override
    public void onLoaderReset(Loader loader) {
        mAdapter.setContactList(null);
    }

}