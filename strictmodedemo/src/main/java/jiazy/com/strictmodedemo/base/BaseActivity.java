package jiazy.com.strictmodedemo.base;

import android.app.Activity;
import android.os.Bundle;

import jiazy.com.strictmodedemo.utils.BuildModeUtils;
import jiazy.com.strictmodedemo.utils.StrictModeUtil;

/**
 * 作者： jiazy
 * 日期： 2017/3/23.
 * 公司： 步步高教育电子有限公司
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        initStrictMode();

        super.onCreate(savedInstanceState);
    }

    private void initStrictMode() {
        //为了更好地分析应用中的问题，放在BaseActivity或者Application里的onCreate方法中
        if(BuildModeUtils.isApkInDebug(getApplicationContext())) {
            StrictModeUtil.setThreadPolicy();
            StrictModeUtil.setVmPolicy();
        }
    }

}