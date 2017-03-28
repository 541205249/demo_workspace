package jiazy.com.mvvmdemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import jiazy.com.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("testFirst", 22, "男");
        binding.setUser(user);
    }
}
