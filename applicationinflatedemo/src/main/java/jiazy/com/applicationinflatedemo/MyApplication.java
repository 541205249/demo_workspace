package jiazy.com.applicationinflatedemo;

import android.app.Application;
import android.view.View;

/**
 * 作者： jiazy
 * 日期： 2017/3/23.
 * 公司： 步步高教育电子有限公司
 */

public class MyApplication extends Application {
    public static MyApplication mInstance;
    private View mMainLayout;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        mMainLayout = View.inflate(getApplicationContext(), R.layout.activity_main, null);
    }

    public View getMainLayout() {
        if(mMainLayout == null) {
            mMainLayout = View.inflate(getApplicationContext(), R.layout.activity_main, null);
        }

        return mMainLayout;
    }
}
