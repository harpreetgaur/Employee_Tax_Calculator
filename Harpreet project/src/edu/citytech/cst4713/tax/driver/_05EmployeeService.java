package edu.citytech.cst4713.tax.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import edu.citytech.cst4713.tax.model.Employee;
import edu.citytech.cst4713.tax.service.EmployeeService;

public class _05EmployeeService {

	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();
		
		Map<String, Supplier<List<Employee>>  > map = new HashMap<>();
		
		map.put("single", service::getSingle);
		map.put("head", service::getHeadofHouseHold);
		map.put("married", service::getMarried);
		
		Supplier<List<Employee>> empSupplier = map.get("head");
		
		empSupplier.get()
					.forEach(System.out::println);;
	}

}
