package javaPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee{
	int age;
	double salary;
	String name;
	String dep;
	public Employee(int age, double salary, String name, String dep) {
		this.age=age;
		this.salary=salary;
		this.name=name;
		this.dep=dep;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	
	@Override
    public String toString() { return name; }
}
public class StreamAPIUseCasesDemo {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(new Employee(28, 35000, "sai", "IT"), new Employee(35, 57000, "amit", "IT"), new Employee(26, 67000, "vaishu", "IT"), new Employee(32, 52000, "gopal", "IT"), new Employee(31, 70000, "kalyan", "BPS"));
		List<String> names = highEarners(employees);
		System.out.println(names);
		
		Optional<Double> highestITSalary = depSalaryCap(employees);
		System.out.println(highestITSalary.orElse(0.0));
		
		System.out.println(avgAge(employees));
		
		System.out.println(salSumByDep(employees));
		
		System.out.println(highestPaidVeteran(employees).orElse(null));
		
	}
	//1. Warm-up: High EarnersTask: Find the names of all employees who are older than 30 and earn more than 50,000. Return the result as a List<String>
	public static List<String> highEarners(List<Employee> employees){
		return employees.stream()
			.filter(employee -> (employee.getAge()>30 && employee.getSalary()>50000))
			.map(Employee::getName)
			.toList();
	}
	//2. Intermediate: Department Salary CapTask: Find the highest salary in the "IT" department. Return the result as an Optional<Double>
	public static Optional<Double> depSalaryCap(List<Employee> employees){
		return employees.stream()
				.filter(employee -> employee.getDep().equals("IT"))
				.map(Employee::getSalary)
				.max(Double::compare); //requires a Comparator for object comparison
	}
	//3. Intermediate: Average AgeTask: Calculate the average age of all employees in the company. Return the result as a double. (If the list is empty, return 0.0)
	public static double avgAge(List<Employee> employees) {
		return employees.stream()
				.mapToInt(Employee::getAge)
				.average()
				.orElse(0.0);
	}
	//4. Advanced: Salary Summary by DepartmentTask: Group the employees by department, but instead of mapping to a list of employees, map to the total sum of salaries in that department. Return a Map<String, Double>.
	public static Map<String, Double> salSumByDep(List<Employee> employees){
		return employees.stream()
				.collect(Collectors.groupingBy(Employee::getDep, Collectors.summingDouble(Employee::getSalary)));
	}
	//5. Expert: The Highest Paid VeteranTask: Find the single employee who has the highest salary. If there is a tie, pick the one who is older. Return an Optional<Employee>.
	public static Optional<Employee> highestPaidVeteran(List<Employee> employees){
		return employees.stream()
	            .max(Comparator.comparing(Employee::getSalary)
	                           .thenComparing(Employee::getAge));
	}
	
}
