package collections.comparables;

import java.util.Arrays;

class Employee implements Comparable {
    private String name;

    Employee(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Employee) obj).getName().equals(getName());
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee) o;
        return getName().compareTo(e.getName());
    }
}

public class Test {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("John"), new Employee("Steve")};
        Arrays.sort(employees);
    }
}
