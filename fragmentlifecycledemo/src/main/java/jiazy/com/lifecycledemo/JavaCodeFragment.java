package jiazy.com.lifecycledemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者： jiazy
 * 日期： 2017/4/2.
 * 公司： 步步高教育电子有限公司
 */

public class JavaCodeFragment extends Fragment {

    /**
     * 重要！！！！！！！！！！！！！！！！！！！！！！！
     * 如果需要在创建 Fragment 实例时传递参数进行初始化的话，可以创建一个带参数的构造函数，
     * 并初始化 Fragment 成员变量等。这样做，看似没有问题，但在一些特殊状况下还是有问题的。
     * 我们知道，Activity 在一些特殊状况下会发生 destroy 并重新 create 的情形，
     * 比如屏幕旋转、内存吃紧时；对应的，依附于 Activity 存在的 Fragment 也会发生类似的状况。
     * 而一旦重新 create 时，Fragment 便会调用默认的无参构造函数，导致无法执行有参构造函数进行初始化工作。
     * 好在 Fragment 提供了相应的 API 帮助我们解决这个问题。利用 bundle 传递数据
     */
    public static JavaCodeFragment newInstance(int args){
        JavaCodeFragment oneFragment = new JavaCodeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("someArgs", args);
        oneFragment.setArguments(bundle);

        return oneFragment;
    }

    /**
     * 布局静态嵌入方式调用
     * 代码动态嵌入方式不调这个方法
     */
    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i("jzy-JavaCode", "onInflate");
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        Log.i("jzy-JavaCode", "onAttach(Context context)");
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i("jzy-JavaCode", "onAttach(Activity activity)");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("jzy-JavaCode", "onCreate");
        Bundle bundle = getArguments();
        int args = bundle.getInt("someArgs");
        Log.i("jzy-args", ""+args);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("jzy-JavaCode", "onCreateView");
        return inflater.inflate(R.layout.fragment_java_code, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i("jzy-JavaCode", "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("jzy-JavaCode", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.i("jzy-JavaCode", "onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("jzy-JavaCode", "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("jzy-JavaCode", "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("jzy-JavaCode", "onPause");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("jzy-JavaCode", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        Log.i("jzy-JavaCode", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("jzy-JavaCode", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("jzy-JavaCode", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("jzy-JavaCode", "onDetach");
        super.onDetach();
    }











    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("jzy-JavaCode", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    /*@Override
    public void onAttachFragment(Fragment childFragment) {
        Log.i("jzy-JavaCode", "onAttachFragment");
        super.onAttachFragment(childFragment);
    }*/

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.i("jzy-JavaCode", "onHiddenChanged");
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.i("jzy-JavaCode", "onRequestPermissionsResult");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /*@Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Log.i("jzy-JavaCode", "onMultiWindowModeChanged");
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }*/

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("jzy-JavaCode", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}