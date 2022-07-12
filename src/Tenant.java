import java.util.Objects;

public class Tenant implements Person{
    private String name;
    private String secondName;
    private int age;

    public Tenant(String name, String secondName, int age) throws Exception {
        if(age<0){
            throw new Exception("Incorrect value for age");
        }
        this.name = name;
        this.secondName = secondName;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getSecondName() {
        return this.secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return age == tenant.age && name.equals(tenant.name) && secondName.equals(tenant.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, secondName, age);
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }
}
