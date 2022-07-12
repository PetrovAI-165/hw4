public interface Person {
    String name = new String();
    String secondName = new String();
    int age = 0;

    public String getName();
    public String getSecondName();
    public int getAge();
    public boolean equals(Object o);
    public int hashCode();
    public String toString();
}
