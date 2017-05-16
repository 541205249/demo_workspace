package jiazy.com.applistloaderdemo;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import jiazy.com.applistloaderdemo.loader.AppEntry;
import jiazy.com.applistloaderdemo.loader.AppListLoader;

/**
 * 作者： jiazy
 * 日期： 2017/5/16.
 * 公司： 步步高教育电子有限公司
 * 描述：
 */
public class AppListFragment extends ListFragment implements
        LoaderManager.LoaderCallbacks<List<AppEntry>> {
    private static final String TAG = "ADP_AppListFragment";
    private static final boolean DEBUG = true;

    private AppListAdapter mAdapter;

    private static final int LOADER_ID = 1;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);

        mAdapter = new AppListAdapter(getActivity());
        setEmptyText("No applications");
        setListAdapter(mAdapter);
        setListShown(false);

        if (DEBUG) {
            Log.i(TAG, "+++ Calling initLoader()! +++");
            if (getLoaderManager().getLoader(LOADER_ID) == null) {
                Log.i(TAG, "+++ Initializing the new Loader... +++");
            } else {
                Log.i(TAG, "+++ Reconnecting with existing Loader (id '1')... +++");
            }
        }

        // Initialize a Loader with id '1'. If the Loader with this id already
        // exists, then the LoaderManager will reuse the existing Loader.
        getLoaderManager().initLoader(LOADER_ID, null, this);
    }

    @Override
    public Loader<List<AppEntry>> onCreateLoader(int id, Bundle args) {
        if (DEBUG) Log.i(TAG, "+++ onCreateLoader() called! +++");
        return new AppListLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<AppEntry>> loader, List<AppEntry> data) {
        if (DEBUG) Log.i(TAG, "+++ onLoadFinished() called! +++");
        mAdapter.setData(data);

        if (isResumed()) {
            setListShown(true);
        } else {
            setListShownNoAnimation(true);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<AppEntry>> loader) {
        if (DEBUG) Log.i(TAG, "+++ onLoadReset() called! +++");
        mAdapter.setData(null);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.activity_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_configure_locale:
                configureLocale();
                return true;
        }
        return false;
    }

    /**
     * Notifies the Loader that a configuration change has has occurred (i.e. by
     * calling {@link Loader#onContentChanged()}).
     * <p>
     * This feature was added so that it would be easy to see the sequence of
     * events that occurs when a content change is detected. Connect your
     * device via USB and analyze the logcat to see the sequence of methods that
     * are called as a result!
     */
    private void configureLocale() {
        Loader<AppEntry> loader = getLoaderManager().getLoader(LOADER_ID);
        if (loader != null) {
            startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
        }
    }
}
