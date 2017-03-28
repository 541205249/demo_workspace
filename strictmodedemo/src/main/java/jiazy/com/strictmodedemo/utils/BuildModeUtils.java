package jiazy.com.strictmodedemo.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/**
 * 作者： jiazy
 * 日期： 2017/3/23.
 * 公司： 步步高教育电子有限公司
 * 描述： 操作当前编译版本的工具类（Debug版本还是Release版本）
 */

public class BuildModeUtils {

    /**
     * 判断当前应用是否是debug状态
     */
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isApkInRelease(Context context) {
        return !isApkInDebug(context);
    }
}
