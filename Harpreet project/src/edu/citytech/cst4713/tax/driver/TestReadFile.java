package edu.citytech.cst4713.tax.driver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import edu.citytech.cst4713.tax.model.Tax;
import edu.citytech.sp2020.marginal.tax.EStatus;

public class TestReadFile {

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
	public static void main(String args[]) {

		String fileName = "/Users/Luna23/Desktop/MarginalTax.txt";

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.skip(1)
				.map( TestReadFile::convert)
				.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}



