package edu.citytech.cst4713.tax.servlet.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.citytech.cst4713.tax.model.Employee;
import edu.citytech.cst4713.tax.service.EmployeeService;


@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeService service = new EmployeeService();
		
		String[] uri = request.getRequestURI().split("/");
		String pageName = uri[uri.length - 1];
		pageName = pageName.replace(".report", "");
		
		
		Map<String, Supplier<List<Employee>>  > map = new HashMap<>();
		
		map.put("single", service::getSingle);
		map.put("head", service::getHeadofHouseHold);
		map.put("married", service::getMarried);
		
		Supplier<List<Employee>> empSupplier = map.get(pageName);
		List<Employee> employees = empSupplier.get();
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/views/employee-report.jsp");
		
		request.setAttribute("pageName", pageName);
		request.setAttribute("employees", employees);
		
		dispatcher.forward(request, response);
		
		
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
