package jiazy.com.loadmanagerdemo.customloader;

import android.provider.ContactsContract.Contacts;

/**
 * 作者： jiazy
 * 日期： 2017/3/25.
 * 公司： 步步高教育电子有限公司
 */

public class Contant {
    // 查询指定的条目
    public static final String[] CONTACTS_PROJECTION = new String[]{
            Contacts._ID,                           // 0
            Contacts.DISPLAY_NAME_PRIMARY,          // 1
            "first_phone_number",                   // 2
    };
}
