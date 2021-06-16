package edu.citytech.cst4713.tax.driver;

import com.jbbwebsolutions.dao.IQuery;

import edu.citytech.cst4713.tax.dao.TaxDAO;
import edu.citytech.cst4713.tax.model.Tax;

public class _03DriverDAO {

	public static void main(String[] args) {
		
		IQuery<Tax> query = new TaxDAO();
		
		query.findAll().forEach(System.out::println);

	}

}
