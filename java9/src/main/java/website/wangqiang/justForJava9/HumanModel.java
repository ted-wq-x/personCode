package website.wangqiang.justForJava9;

/**
 * 项目名称：  testcode<br>
 * 类名称：  HumanModel<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/26 0026 14:23
 */
public class HumanModel {
    private String name;
    private Integer age;
    private String country;

    public HumanModel() {
    }

    public HumanModel(String name, Integer age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
