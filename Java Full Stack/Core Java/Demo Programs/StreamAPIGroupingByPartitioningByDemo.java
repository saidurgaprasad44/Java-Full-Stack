package javaPrograms;

import java.util.*;
import java.util.stream.Collectors;

// ============================================================================
// DOMAIN MODEL CLASS
// ============================================================================
class EmployeeDude {
    private String name;
    private String department;
    private double salary;
    private String city;

    public EmployeeDude(String name, String department, double salary, String city) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.city = city;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getCity() { return city; }

    // CRITICAL: Overriding toString() so we print actual data instead of raw HashCodes!
    @Override
    public String toString() {
        return "EmployeeDude{name='" + name + "', salary=" + salary + ", city='" + city + "'}";
    }
}

// ============================================================================
// MAIN APPLICATION FILE
// ============================================================================
public class StreamAPIGroupingByPartitioningByDemo {

    public static void main(String[] args) {
        // Sample Data Source
        List<EmployeeDude> employees = Arrays.asList(
            new EmployeeDude("Alice", "IT", 120000, "New York"),
            new EmployeeDude("Bob", "HR", 60000, "Chicago"),
            new EmployeeDude("Charlie", "IT", 95000, "New York"),
            new EmployeeDude("David", "HR", 65000, "New York"),
            new EmployeeDude("Eve", "IT", 80000, "Chicago")
        );

        System.out.println("========== 1. BASIC GROUPING (BY DEPT) ==========");
        Map<String, List<EmployeeDude>> employeesByDept = employees.stream()
            .collect(Collectors.groupingBy(EmployeeDude::getDepartment));
        
        employeesByDept.forEach((dept, list) -> System.out.println(dept + " -> " + list));


        System.out.println("\n========== 2. GROUPING & COUNTING ELEMENTS ==========");
        Map<String, Long> deptCounts = employees.stream()
            .collect(Collectors.groupingBy(EmployeeDude::getDepartment, Collectors.counting()));
        
        System.out.println("EmployeeDude counts: " + deptCounts);


        System.out.println("\n========== 3. GROUPING & TRANSFORMING DATA (NAMES ONLY) ==========");
        Map<String, List<String>> namesByDept = employees.stream()
            .collect(Collectors.groupingBy(
                EmployeeDude::getDepartment,
                Collectors.mapping(EmployeeDude::getName, Collectors.toList())
            ));
        
        System.out.println("Names by department: " + namesByDept);


        System.out.println("\n========== 4. NESTED TWO-LEVEL GROUPING (DEPT -> CITY) ==========");
        Map<String, Map<String, List<EmployeeDude>>> nestedMap = employees.stream()
            .collect(Collectors.groupingBy(
                EmployeeDude::getDepartment,
                Collectors.groupingBy(EmployeeDude::getCity)
            ));
        
        nestedMap.forEach((dept, cityMap) -> {
            System.out.println("Dept: " + dept);
            cityMap.forEach((city, list) -> System.out.println("  ↳ City: " + city + " -> " + list));
        });


        System.out.println("\n========== 5. GROUPING & AVERAGING SALARY ==========");
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                EmployeeDude::getDepartment,
                Collectors.averagingDouble(EmployeeDude::getSalary)
            ));
        
        System.out.println("Average salaries: " + avgSalaryByDept);


        System.out.println("\n========== 6. PARTITIONING (BINARY TRUE/FALSE SPLIT) ==========");
        // Splits employees cleanly into two groups: Salary > 85,000 (true) and <= 85,000 (false)
        Map<Boolean, List<EmployeeDude>> highPaidPartition = employees.stream()
            .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 85000));

        System.out.println("High Earners (Passed Condition [True]):");
        System.out.println(highPaidPartition.get(true));
        
        System.out.println("\nStandard Earners (Failed Condition [False]):");
        System.out.println(highPaidPartition.get(false));
    }
}
