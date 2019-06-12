package design_pattern.monad;

public class User {
    private String name;
    private int age;
    private Sex sex;
    private String email;

    public User(String name, int age, Sex sex, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}
