package jiazy.com.lifecycledemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        //添加Fragment的两种方式：
        //1、在activity布局文件里声明fragment；

        //2、通过java代码将fragment添加到已存的ViewGroup中.
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        RightFragment rightFragment = new RightFragment();
        transaction.add(R.id.right_fragment, rightFragment);
        transaction.commit();
    }

}
