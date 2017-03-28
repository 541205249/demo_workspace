package jiazy.com.strictmodedemo;

import android.os.Bundle;

import jiazy.com.strictmodedemo.base.BaseActivity;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //案例1
//        MyApplication.sLeakyActivities.add(this);

        //案例2
//        BadCase.writeToExternalStorage();
    }

}
