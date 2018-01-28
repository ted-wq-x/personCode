package wangqiang.website.createType;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ChainBuilder<br>
 * 描述：链式调用
 *
 * @author wangqiang
 * 创建时间：  2018/1/22 0022 17:24
 */
public class ChainBuilder {
    public static void main(String[] args) {
        Person wq = new Person.Builder().age(12).name("wq").build();
        Person dss = new Person.Builder().name("wwwsss").build();
        System.out.println(wq);
        System.out.println(dss);
    }

}


class Person {
    /**
     * 私有化构造器
     */
    private Person() {

    }

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * public 的静态内部类
     */
    public static class Builder {
        private Person person = new Person();

        public Builder name(String name){
            person.name = name;
            return this;
        }


        public Builder age(int age) {
            person.age = age;
            return this;
        }


        public Person build() {
            return person;
        }
    }
}
