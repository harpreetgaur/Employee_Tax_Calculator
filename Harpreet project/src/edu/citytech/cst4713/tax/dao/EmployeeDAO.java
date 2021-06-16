package edu.citytech.cst4713.tax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jbbwebsolutions.dao.IQuery;
import edu.citytech.cst4713.tax.model.Employee;
import edu.citytech.sp2020.marginal.tax.EStatus;

public class EmployeeDAO implements IQuery<Employee> {
	
	private static Employee convert(String row) {
		
		String[] columns = row.split(",");
		
		String id = columns[0];
		EStatus code = EStatus.getStatus(columns[1]);
		float salary = Float.parseFloat(columns[2]);
		String state = columns[3];

		
		Employee employee = new Employee(id, code, salary, state);
		
		return employee;
		
	}


	@Override
	public List<Employee> findAll() {
		
		String fileName = "/Users/Luna23/Desktop/Employee.csv";

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			List<Employee> list = stream.skip(1)
									.map( EmployeeDAO::convert)
									.collect(Collectors.toList());
			return list;

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>(); 
		
	}

}
