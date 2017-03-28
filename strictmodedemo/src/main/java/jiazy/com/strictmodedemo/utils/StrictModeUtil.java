package jiazy.com.strictmodedemo.utils;

import android.os.StrictMode;

/**
 * 严苛模式工具类
 * 目前能有两大策略，线程策略（ThreadPolicy）和虚拟机策略（VmPolicy）
 * 当出现违例情况，会打印日志，通过StrictMode过滤即可查看到
 * 参考资料：http://www.tuicool.com/articles/ueeM7b6     http://www.tuicool.com/articles/ueeM7b6
 * 也可以在开发者选项中开启严格模式，开启之后，如果主线程中有执行时间长的操作，屏幕则会闪烁，这是一个更加直接的方法
 */
public class StrictModeUtil {

    public static void setVmPolicy(){
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectAll()  //检测所有潜在的违例
                .detectActivityLeaks()  //检测Activity的泄露
                .detectLeakedSqlLiteObjects()  //检测sqlite对象，如cursors
                .detectLeakedClosableObjects()  //检查为管理的Closable对象
                .penaltyLog()
                .penaltyDeath()
                .build());
    }

    public static void setThreadPolicy(){
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectAll()  //检测所有潜在的违例
                .detectCustomSlowCalls() //自定义耗时操作
                .detectDiskReads()  //读磁盘
                .detectDiskWrites()  //写磁盘
                .detectNetwork()  //检测网络
                .penaltyLog()
                .penaltyDialog()
                .build());
    }

}
