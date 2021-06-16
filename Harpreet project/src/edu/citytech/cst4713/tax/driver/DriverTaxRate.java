package edu.citytech.cst4713.tax.driver;

import java.util.Arrays;

import edu.citytech.cst4713.tax.service.MarginalTaxService;
import edu.citytech.sp2020.marginal.tax.EStatus;
import edu.citytech.sp2020.marginal.tax.ITaxPaid;

public class DriverTaxRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ITaxPaid service = new MarginalTaxService();

		EStatus status = EStatus.MARRIED_FILING_JOINTLY;
		float salary = 50000;
		float[] taxRates = service.getTaxRates(status, salary);
		float test = service.getTaxPaid(status, salary);
		System.out.println(test);
		System.out.println(Arrays.toString(taxRates));
		
		
		
	}
 
}
