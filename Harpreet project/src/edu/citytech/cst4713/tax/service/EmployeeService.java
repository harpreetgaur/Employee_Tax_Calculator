package edu.citytech.cst4713.tax.service;

import java.util.List;
import java.util.function.Predicate;

import com.jbbwebsolutions.dao.IQuery;

import edu.citytech.cst4713.tax.dao.EmployeeDAO;
import edu.citytech.cst4713.tax.model.Employee;
import edu.citytech.sp2020.marginal.tax.EStatus;

@SuppressWarnings("unused")
public class EmployeeService {
	
	private static final Predicate<Employee> salaryLess5k = e -> e.salary < 9_000;
	private static final Predicate<Employee> showNewYork = e -> e.state.contentEquals("NY");
	private static final Predicate<Employee> showSingle = e -> e.code == EStatus.SINGLE;
	private static final Predicate<Employee> showMarried = e -> e.code == EStatus.MARRIED_FILING_JOINTLY;
	private static final Predicate<Employee> showHead = e -> e.code == EStatus.HEAD_OF_HOUSEHOLD;
	
	IQuery<Employee> query = new EmployeeDAO();
	
	public List<Employee> getSingle() {
		return query.findBy(showSingle);
	}
	
	public List<Employee> getMarried() {
		return query.findBy(showMarried);
	}
	
	public List<Employee> getHeadofHouseHold() {
		return query.findBy(showHead);
	}

}