/**
 * 
 */
package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hiral.panchal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Employee> eList = Arrays.asList(
			new Employee(1,"Hiral","IT",50000.0),
			new Employee(2,"Vaibhav","IT",11000.0),
			new Employee(3,"Malay","Computer",30000.0),
			new Employee(4,"Rajan","Mechanical",23000.0),
			new Employee(5,"Rajesh","IT",30000.0)
		);
		
		Main m = new Main();
		List<String> empNameList = m.getTop2ITEmpNamesBySalary(eList);
		empNameList.stream().forEach(System.out::println);

	}

	private List<String> getTop2ITEmpNamesBySalary(List<Employee> eList) {
		
		return eList.stream()
		.filter(emp -> emp.getDepartment().equals("IT"))
		.sorted((e1,e2) -> new Double(e2.getSalary()).compareTo(e1.getSalary()))
		.limit(2)
		.map(emp -> emp.getName())
		.collect(Collectors.toList());
	}
	

}
