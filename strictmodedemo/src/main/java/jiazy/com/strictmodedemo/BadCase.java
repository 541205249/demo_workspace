package jiazy.com.strictmodedemo;

import android.os.Environment;
import android.widget.PopupWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 作者： jiazy
 * 日期： 2017/3/24.
 * 公司： 步步高教育电子有限公司
 * 描述： 一些违规的案例
 */

public class BadCase {

    /**
     * 违例1：主线程中的文件写入
     * 违例2：当write执行出现异常时，会导致output不会被关闭
     * 1解决办法：放入子线程中执行
     * 2解决办法：在try-catch后面加上finally语句块
     */
    public static void writeToExternalStorage() {
        File externalStorage = Environment.getExternalStorageDirectory();
        File destFile = new File(externalStorage, "dest.txt");
        try {
            OutputStream output = new FileOutputStream(destFile, true);
            output.write("droidyue.com".getBytes());
            output.flush();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
