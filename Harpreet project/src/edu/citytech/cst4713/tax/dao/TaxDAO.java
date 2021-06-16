package edu.citytech.cst4713.tax.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jbbwebsolutions.dao.IQuery;

import edu.citytech.cst4713.tax.driver.TestReadFile;
import edu.citytech.cst4713.tax.model.Tax;
import edu.citytech.sp2020.marginal.tax.EStatus;

public class TaxDAO implements IQuery<Tax> {
	
	public static Tax convert(String row) {
		
		String[] columns = row.split("\\|");
		
		int ruleNo = Integer.parseInt(columns[0]);
		int year = Integer.parseInt(columns[1]);
		EStatus status = EStatus.getStatus(columns[2]);
		float percentage = Float.parseFloat(columns[3].replace("%", ""))
				/100;
		float range = Float.parseFloat(columns[4]);
		float range2 = Float.parseFloat(columns[5]);
		
		Tax tax = new Tax(ruleNo, year, status, percentage, range, range2);
		
		return tax;
		
	}


	@Override
	public List<Tax> findAll() {
		
		String fileName = "/Users/Luna23/Desktop/MarginalTax.txt";

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			List<Tax> list = stream.skip(1)
									.map( TestReadFile::convert)
									.collect(Collectors.toList());
			return list;

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>(); 
		
	}

}
