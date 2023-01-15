package entities;

public class Employee implements Comparable<Employee>{
	
	private String name;
	private Double salary;

	public Employee(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	//ORDENAR A LISTA DE FUNCIONARIOS POR NOME	
/*	@Override
	public int compareTo(Employee other) {
		return name.compareTo(other.getName());
	}
*/	
	//ORDENAR POR ORDEM DESC DE SALARIO
	@Override
	public int compareTo(Employee a) {
		return -salary.compareTo(a.getSalary());
	}
	
}
