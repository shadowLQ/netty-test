/**
 * @author LQ
 * @date 2019/01/24 22:16
 */
public class Student {
    private int id;
    private String name;
    private String classes;
    private String tell;
    private int age;

    public Student(int id, String name, String classes, String tell, int age) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.tell = tell;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", tell='" + tell + '\'' +
                ", age=" + age +
                '}';
    }
}
