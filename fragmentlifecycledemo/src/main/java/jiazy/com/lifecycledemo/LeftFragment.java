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

public class LeftFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i("jzy", "");
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onAttach(Context context) {
        Log.i("jzy", "");
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i("jzy", "");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i("jzy", "");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        Log.i("jzy", "");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i("jzy", "");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Log.i("jzy", "");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i("jzy", "");
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i("jzy", "");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.i("jzy", "");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("jzy", "");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.i("jzy", "");
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i("jzy", "");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        Log.i("jzy", "");
        super.onDetach();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.i("jzy", "");
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onStart() {
        Log.i("jzy", "");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.i("jzy", "");
        super.onStop();
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        Log.i("jzy", "");
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i("jzy", "");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.i("jzy", "");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Log.i("jzy", "");
        super.onMultiWindowModeChanged(isInMultiWindowMode);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i("jzy", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}
