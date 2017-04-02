package jiazy.com.lifecycledemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class JavaCodeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_code);
        initViews();
    }

    private void initViews() {
        //通过java代码将fragment添加到已存的ViewGroup中.
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        JavaCodeFragment javaCodeFragment = JavaCodeFragment.newInstance(111);
        JavaCodeFragment javaCodeFragment2 = JavaCodeFragment.newInstance(222);
        transaction.add(R.id.java_code_fragment1, javaCodeFragment);
        transaction.add(R.id.java_code_fragment2, javaCodeFragment2);
        transaction.commit();
    }
}
