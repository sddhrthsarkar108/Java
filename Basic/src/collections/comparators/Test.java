package collections.comparators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private long salary;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    long getSalary() {
        return salary;
    }
}

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Employee("sid", 29);
        Employee e2 = new Employee("tuk", 29);

        List<Employee> l = new ArrayList<>();
        Comparator c = Comparator.comparing(Employee::getName)
                .reversed()
                .thenComparing(Employee::getAge)
                .thenComparingLong(Employee::getSalary);
        Comparator c1 = Comparator.nullsFirst(c);
        l.sort(c1);
    }
}
