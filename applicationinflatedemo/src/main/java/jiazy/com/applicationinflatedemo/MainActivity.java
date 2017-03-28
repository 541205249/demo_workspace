package jiazy.com.applicationinflatedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(MyApplication.mInstance.getMainLayout());
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        getRootView(this).removeView(MyApplication.mInstance.getMainLayout());
    }

    private static ViewGroup getRootView(Activity activity) {
        return (ViewGroup) activity.findViewById(android.R.id.content);
    }
}
