package jiazy.com.mvvmdemo;

/**
 * 作者： jiazy
 * 日期： 2017/3/24.
 * 公司： 步步高教育电子有限公司
 */

public class User {
    public String name;
    private int age;
    private String sex;

    public User(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
