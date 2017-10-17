package website.wangqiang;

import java.util.prefs.Preferences;

/**
 * windows上配置数据在注册表当中，linux上在用户的home目录下的隐藏文件中
 * @author BlueT
 * 2017/10/6 21:57
 */
public class PreferencesTest {
    public static void main(String[] args) {
        Preferences preferences = Preferences.userRoot();

        preferences = preferences.node("/wq/test");
        preferences.put("name", "wangqiang");
        preferences.putInt("age",25);
        preferences.put("create","2017-10-6 ");
    }
}
