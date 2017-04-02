package jiazy.com.lifecycledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Fragment嵌入到Activity有两种方式，分别为：布局静态嵌入方式和代码动态嵌入方式
 * 参考资料：http://yifeng.studio/2016/12/15/android-fragment-attentions/
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.java_code_fragment:
                intent.setClass(MainActivity.this, JavaCodeActivity.class);
                break;
            case R.id.xml_code_fragment:
                intent.setClass(MainActivity.this, XMLCodeActivity.class);
                break;
            case R.id.both_them_fragment:
                intent.setClass(MainActivity.this, BothThemActivity.class);
                break;
        }

        startActivity(intent);
    }
}
