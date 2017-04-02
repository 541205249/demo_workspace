package jiazy.com.loadmanagerdemo.cursorloader;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import jiazy.com.loadmanagerdemo.R;

import static jiazy.com.loadmanagerdemo.customloader.Constant.CONTACTS_PROJECTION;

public class CursorLoaderActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ContactsCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor_loader);
        initWidgets();
        initLoaderManager();
    }

    private void initWidgets() {
        ListView mListView = (ListView) findViewById(R.id.lv_list);
        mAdapter = new ContactsCursorAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
    }

    private void initLoaderManager() {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getApplicationContext(), ContactsContract.Contacts.CONTENT_URI,
                CONTACTS_PROJECTION, null, null, ContactsContract.Contacts.SORT_KEY_PRIMARY);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader loader) {
        mAdapter.swapCursor(null);
    }

}