package jiazy.com.loadmanagerdemo;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import jiazy.com.loadmanagerdemo.cursorloader.CursorLoaderActivity;
import jiazy.com.loadmanagerdemo.cursorloader.ListFragmentCursorLoaderActivity;
import jiazy.com.loadmanagerdemo.customloader.CustomLoaderActivity;
import jiazy.com.loadmanagerdemo.recyclerviewcustomloader.RecyclerViewActivity;

/**
 * 作者： jiazy
 * 日期： 2017/3/25.
 * 公司： 步步高教育电子有限公司
 */

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String TAG = "tag_loadmanagerdemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_CONTACTS}, 0);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cursorLoaderBtn:
                startActivity(new Intent(this, CursorLoaderActivity.class));
                break;
            case R.id.cursorLoaderListFragmentBtn:
                startActivity(new Intent(this, ListFragmentCursorLoaderActivity.class));
                break;
            case R.id.customLoaderBtn:
                startActivity(new Intent(this, CustomLoaderActivity.class));
                break;
            case R.id.recyclerViewCustomLoaderBtn:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
        }
    }
}
