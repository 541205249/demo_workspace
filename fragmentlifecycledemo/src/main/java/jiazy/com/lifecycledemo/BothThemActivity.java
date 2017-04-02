package jiazy.com.lifecycledemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Fragment嵌入到Activity有两种方式，分别为：布局静态嵌入方式和代码动态嵌入方式
 * 实践证明，布局静态嵌入先于代码动态嵌入执行,但是启动速度基本无差别
 * 参考资料：http://yifeng.studio/2016/12/15/android-fragment-attentions/
 *
 *
 * 以下是两种方式的Fragment从启动到熄屏再到亮屏的生命周期回调
 =============启动===============
 jzy-XMLCode: onInflate    （XMLCode方式首先调此方法，JavaCode方式不调）

 jzy-XMLCode: onAttach(Context context)
 jzy-XMLCode: onAttach(Activity activity)
 jzy-XMLCode: onCreate
 jzy-XMLCode: onCreateView
 jzy-XMLCode: onViewCreated
 jzy-XMLCode: onActivityCreated
 jzy-XMLCode: onViewStateRestored

 jzy-JavaCode: onAttach(Context context)
 jzy-JavaCode: onAttach(Activity activity)
 jzy-JavaCode: onCreate
 jzy-JavaCode: onCreateView
 jzy-JavaCode: onViewCreated
 jzy-JavaCode: onActivityCreated
 jzy-JavaCode: onViewStateRestored

 jzy-XMLCode: onStart
 jzy-JavaCode: onStart
 jzy-XMLCode: onResume
 jzy-JavaCode: onResume


 =================熄屏===============
 jzy-XMLCode: onPause
 jzy-JavaCode: onPause
 jzy-XMLCode: onSaveInstanceState
 jzy-JavaCode: onSaveInstanceState
 jzy-XMLCode: onStop
 jzy-JavaCode: onStop


 ================再次回到页面=========
 jzy-XMLCode: onStart
 jzy-JavaCode: onStart
 jzy-XMLCode: onResume
 jzy-JavaCode: onResume
 ================销毁Activity==============
 jzy-XMLCode: onPause
 jzy-JavaCode: onPause
 jzy-XMLCode: onStop
 jzy-JavaCode: onStop

 jzy-XMLCode: onDestroyView
 jzy-XMLCode: onDestroy
 jzy-XMLCode: onDetach

 jzy-JavaCode: onDestroyView
 jzy-JavaCode: onDestroy
 jzy-JavaCode: onDetach
 */
public class BothThemActivity extends AppCompatActivity {

    private JavaCodeFragment mJavaCodeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both_them);

        initViews();
    }

    private void initViews() {
        //添加Fragment的两种方式：
        //1、通过java代码将fragment添加到已存的ViewGroup中.
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.java_code_fragment, getJavaCodeFragment(), "JavaCodeFragment");
        transaction.commit();  // 提交事务，对 Fragment 的改动都必须通过调用 commit() 方法完成提交；

        //2、在activity布局文件里声明fragment；
    }

    /**
     * 解决Fragment 重叠的问题，方法一：
     *
     * 解释：应用长时间处于后台，但由于设备内存吃紧，导致 Activity 被销毁，
     * 而当用户再次打开应用时便会发生 Fragment 重叠的问题
     */
    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof  JavaCodeFragment){
            mJavaCodeFragment = (JavaCodeFragment) fragment;
        }
    }

    /**
     * 解决Fragment 重叠的问题，第二种方式:在创建 Fragment 前添加判断，判断是否已经存在：
     */
    private JavaCodeFragment getJavaCodeFragment() {
        Fragment tempFragment = getFragmentManager().findFragmentByTag("JavaCodeFragment");
        if (tempFragment == null) {
            mJavaCodeFragment = JavaCodeFragment.newInstance(111);
        }else {
            mJavaCodeFragment = (JavaCodeFragment) tempFragment;
        }

        return mJavaCodeFragment;
    }

    /**
     * 解决Fragment 重叠的问题，第三种方式，更为简单，直接利用 savedInstanceState 判断即可：
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState==null) {
            mJavaCodeFragment = JavaCodeFragment.newInstance(111);
        }else {
            mJavaCodeFragment = (JavaCodeFragment) getFragmentManager().findFragmentByTag("JavaCodeFragment");
        }
    }

}
