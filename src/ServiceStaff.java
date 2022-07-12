import java.util.List;
import java.util.Objects;

public class ServiceStaff implements Person{
    static private final List<String> titles = List.of("cleaner","electrecian","plumber");
    private String title;
    private String name;
    private String secondName;
    private int age;
    private int salary;

    public ServiceStaff(String title, String name, String secondName,int age,int salary) throws Exception {
        if (!(titles.contains(title.toLowerCase()))) {
            throw new Exception("Wrong value of title");
        }
        this.age = age;
        this.title = title;
        this.name = name;
        this.secondName = secondName;
        if(salary<0){
            throw new Exception("Wrong value for salary");
        }
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getTitle() {
        return this.title;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceStaff that = (ServiceStaff) o;
        return age == that.age && salary == that.salary && title.equals(that.title) && name.equals(that.name) && secondName.equals(that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, name, secondName, age, salary);
    }
}
