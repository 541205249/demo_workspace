package com.jiazy.refactordemo;

/**
 * 作者： jiazy
 * 日期： 2017/4/19.
 * 公司： 步步高教育电子有限公司
 * 描述：
 */

public class ReplaceConstructorWithBuilderEntry {
    private int num;
    private String name;

    public ReplaceConstructorWithBuilderEntry(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
