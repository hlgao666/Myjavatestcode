package mytest0107;

/**
 * @author Allen
 * @date 2020/1/7 19:57
 * 在类中使用注解
 */

@Table(VALUE = "tb_student")
public class Student {

    @Field(columnname = "name", type = "varchar", length = 10)
    private String name;
    @Field(columnname = "id", type = "varchar", length = 10)
    private int id;
    @Field(columnname = "age", type = "int", length = 3)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
