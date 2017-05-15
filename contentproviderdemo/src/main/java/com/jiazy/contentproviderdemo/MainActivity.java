package com.jiazy.contentproviderdemo;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.jiazy.contentproviderdemo.customeProvider.StudentProfile;

public class MainActivity extends Activity implements View.OnClickListener, LoaderManager.LoaderCallbacks<Cursor> {
    private ContactsCursorAdapter mAdapter;
    private Uri studentsUri;
    private ContentResolver mContentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        initLoaderManager();

        studentsUri = Uri.parse(StudentProfile.AUTHORITY);
        mContentResolver = getContentResolver();
    }

    private void initWidgets() {
        ListView mListView = (ListView) findViewById(R.id.list_view);
        mAdapter = new ContactsCursorAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
    }

    private void initLoaderManager() {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_insert:
                ContentValues contentValues = new ContentValues();
                contentValues.put(StudentProfile.Students.COLUMN_NAME_NAME, "学生_" + System.currentTimeMillis());
                contentValues.put(StudentProfile.Students.COLUMN_NAME_AGE, "18");
                contentValues.put(StudentProfile.Students.COLUMN_NAME_NUMBER, "001");
                contentValues.put(StudentProfile.Students.COLUMN_NAME_CREATE_DATE, System.currentTimeMillis());
                contentValues.put(StudentProfile.Students.COLUMN_NAME_MODIFICATION_DATE, System.currentTimeMillis());
                mContentResolver.insert(StudentProfile.Students.CONTENT_ID_URI_BASE, contentValues);
                break;
            case R.id.btn_delete:
                mContentResolver.delete(StudentProfile.Students.CONTENT_URI, StudentProfile.Students.COLUMN_NAME_AGE, new String[]{"18"});

                break;
            case R.id.btn_update:
//                ContentValues contentValues = new ContentValues();
//                contentValues.put(StudentProfile.Students.COLUMN_NAME_NAME, "学生_" + System.currentTimeMillis());
//                contentValues.put(StudentProfile.Students.COLUMN_NAME_AGE, "18");
//                contentValues.put(StudentProfile.Students.COLUMN_NAME_NUMBER, "001");
//                contentValues.put(StudentProfile.Students.COLUMN_NAME_CREATE_DATE, System.currentTimeMillis());
//                contentValues.put(StudentProfile.Students.COLUMN_NAME_MODIFICATION_DATE, System.currentTimeMillis());
//                mContentResolver.update(StudentProfile.Students.CONTENT_URI, contentValues);
                break;
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getApplicationContext(), StudentProfile.Students.CONTENT_URI,
                null, null, null, StudentProfile.Students.DEFAULT_SORT_ORDER);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
