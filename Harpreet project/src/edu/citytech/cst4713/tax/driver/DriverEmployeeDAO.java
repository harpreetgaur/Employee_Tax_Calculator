package edu.citytech.cst4713.tax.driver;

import java.util.List;
import java.util.function.Predicate;

import com.jbbwebsolutions.dao.IQuery;

import edu.citytech.cst4713.tax.dao.EmployeeDAO;
import edu.citytech.cst4713.tax.model.Employee;

public class DriverEmployeeDAO {
	
	public static boolean showNewYork(Employee emp) {
		return emp.state.equals("NY");
	}
	
	public static void main(String args[]) {

		IQuery<Employee> query = new EmployeeDAO();
		List<Employee> list = query.findAll();
		
		Predicate<Employee> predicate = e -> e.salary < 5_000;
		
		list.stream()
			.filter( DriverEmployeeDAO::showNewYork)
			.forEach(System.out::println);
 
	}

}



