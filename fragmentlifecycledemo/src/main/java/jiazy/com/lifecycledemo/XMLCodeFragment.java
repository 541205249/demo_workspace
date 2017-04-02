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
 * 描述： 布局静态嵌入方式
 */

public class XMLCodeFragment extends Fragment {

    /**
     * 布局静态嵌入方式调用
     * 代码动态嵌入方式不调这个方法
     */
    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i("jzy-XMLCode", "onInflate");
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        Log.i("jzy-XMLCode", "onAttach(Context context)");
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i("jzy-XMLCode", "onAttach(Activity activity)");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("jzy-XMLCode", "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("jzy-XMLCode", "onCreateView");
        return inflater.inflate(R.layout.fragment_xml_code, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i("jzy-XMLCode", "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("jzy-XMLCode", "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.i("jzy-XMLCode", "onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i("jzy-XMLCode", "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i("jzy-XMLCode", "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("jzy-XMLCode", "onPause");
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("jzy-XMLCode", "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        Log.i("jzy-XMLCode", "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i("jzy-XMLCode", "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i("jzy-XMLCode", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i("jzy-XMLCode", "onDetach");
        super.onDetach();
    }











    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("jzy-XMLCode", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.i("jzy-XMLCode", "onAttachFragment");
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.i("jzy-XMLCode", "onHiddenChanged");
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.i("jzy-XMLCode", "onRequestPermissionsResult");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Log.i("jzy-XMLCode", "onMultiWindowModeChanged");
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("jzy-XMLCode", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}
