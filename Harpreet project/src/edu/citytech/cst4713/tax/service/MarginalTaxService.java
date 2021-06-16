package edu.citytech.cst4713.tax.service;

import edu.citytech.sp2020.marginal.tax.EStatus;
import edu.citytech.sp2020.marginal.tax.ITaxPaid;

public class MarginalTaxService implements ITaxPaid {

	@Override
	public float[] getTaxRates(EStatus status, float salary) {
		float[] taxRates = {};
		
		/* SINGLE TAX RATE
		 *  
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		if (status.equals(EStatus.SINGLE) && salary <= 9_700) {
			taxRates = new float[] {.10f};
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 9_700 && salary <= 39_475) {
			taxRates = new float[] {.10f, .12f};
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 39_475 && salary <= 84_200) {
			taxRates = new float[] {.10f, .12f, .22f};
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 84_200 && salary <= 160_725) {
			taxRates = new float[] {.10f, .12f, .22f, .24f};
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 160_725 && salary <= 204_100) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f};
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 204_100 && salary <= 510_300) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f, .35f};
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 510_300) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f, .35f, .37f};
		}
		

		
		/* MARRIED TAX RATE
		 *  
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary <= 19_400) {
			taxRates = new float[] {.10f};
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 19_400 && salary <= 78_950) {
			taxRates = new float[] {.10f, .12f};
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 78_950 && salary <= 168_400) {
			taxRates = new float[] {.10f, .12f, .22f};
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 168_400 && salary <= 321_450) {
			taxRates = new float[] {.10f, .12f, .22f, .24f};
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 321_450 && salary <= 408_200) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f};
		}
		
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 408_200 && salary <= 612_350) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f, .35f};
		}
		
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 612_350) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f, .35f, .37f};
		}
		
		
		/* HEAD OF HOUSEHOLD
		 *  
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary <= 13_850) {
			taxRates = new float[] {.10f};
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 13_850 && salary <= 52_850) {
			taxRates = new float[] {.10f, .12f};
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 52_850 && salary <= 84_200) {
			taxRates = new float[] {.10f, .12f, .22f};
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 84_200 && salary <= 160_000) {
			taxRates = new float[] {.10f, .12f, .22f, .24f};
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 160_000 && salary <= 204_100) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f};
		}
		
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 204_100 && salary <= 510_300) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f, .35f};
		}
		
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 510_300) {
			taxRates = new float[] {.10f, .12f, .22f, .24f, .32f, .35f, .37f};
		}
		
		return taxRates;
	}


	@Override
	public float getTaxPaid(EStatus status, float salary) {
		
		float[] taxRate = getTaxRates(status, salary);
		float taxPaid = 0;
		float salaryDifference;

		/* SINGLE TAX PAID
		 *  
		 * 
		 * 
		 * 
		 * 
		 * */
		
		if (status.equals(EStatus.SINGLE) && salary <= 9_700) {
			taxPaid = salary * taxRate[0];
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 9_700 && salary <= 39_475) {
			salaryDifference = salary - 9_700;
			taxPaid = 970f + (salaryDifference * taxRate[1]);
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 39_475 && salary <= 84_200) {
			salaryDifference = salary - 39_475;
			taxPaid = 3_573.00f + 970f + (salaryDifference * taxRate[2]);
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 84_200 && salary <= 160_725) {
			salaryDifference = salary - 84_200;
			taxPaid = 9_839.50f + 3_573.00f + 970f + (salaryDifference * taxRate[3]);
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 160_725 && salary <= 204_100) {
			salaryDifference = salary - 160_725;
			taxPaid = 18_366.00f + 9_839.50f + 3_573.00f + 970f + (salaryDifference * taxRate[4]);
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 204_100 && salary <= 510_300) {
			salaryDifference = salary - 204_100;
			taxPaid = 13_880.00f + 18_366.00f + 9_839.50f + 3_573.00f + 970f + (salaryDifference * taxRate[5]);
		}
		
		if (status.equals(EStatus.SINGLE) && salary > 510_300) {
			salaryDifference = salary - 510_300;
			taxPaid = 107_170.00f + 13_880.00f + 18_366.00f + 9_839.50f + 3_573.00f + 970f + (salaryDifference * taxRate[6]);
		}
		
		/* MARRIED TAX PAID
		 *  
		 * 
		 * 
		 * 
		 * 
		 * */
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary <= 19_400) {
			taxPaid = salary * taxRate[0];
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 19_400 && salary <= 78_950) {
			salaryDifference = salary - 19_400;
			taxPaid = 1_940.00f + (salaryDifference * taxRate[1]);
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 78_950 && salary <= 168_400) {
			salaryDifference = salary - 78_950;
			taxPaid = 7_146.00f + 1_940.00f + (salaryDifference * taxRate[2]);
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 168_400 && salary <= 321_450) {
			salaryDifference = salary - 168_400;
			taxPaid = 19_679.00f + 7_146.00f + 1_940.00f + (salaryDifference * taxRate[3]);
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 321_450 && salary <= 408_200) {
			salaryDifference = salary - 321_450;
			taxPaid = 36_732.00f + 19_679.00f + 7_146.00f + 1_940.00f + (salaryDifference * taxRate[4]);
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 408_200 && salary <= 612_350) {
			salaryDifference = salary - 408_200;
			taxPaid = 27_760.00f + 36_732.00f + 19_679.00f + 7_146.00f + 1_940.00f + (salaryDifference * taxRate[5]);
		}
		
		if (status.equals(EStatus.MARRIED_FILING_JOINTLY) && salary > 612_350) {
			salaryDifference = salary - 612_350;
			taxPaid = 71_452.50f + 27_760.00f + 36_732.00f + 19_679.00f + 7_146.00f + 1_940.00f + (salaryDifference * taxRate[6]);
		}
		
		
		/* HEAD OF HOUSEHOLD TAX PAID
		 *  
		 * 
		 * 
		 * 
		 * 
		 * */
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary <= 13_850) {
			taxPaid = salary * taxRate[0];
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 13_850 && salary <= 52_850) {
			salaryDifference = salary - 13_850;
			taxPaid = 1_385.00f + (salaryDifference * taxRate[1]);
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 52_850 && salary <= 84_200) {
			salaryDifference = salary - 52_850;
			taxPaid = 4_680.00f + 1_385.00f + (salaryDifference * taxRate[2]);
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 84_200 && salary <= 160_000) {
			salaryDifference = salary - 84_200;
			taxPaid = 6_897.00f + 4_680.00f + 1_385.00f + (salaryDifference * taxRate[3]);
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 160_000 && salary <= 204_100) {
			salaryDifference = salary - 160_000;
			taxPaid = 18_192.00f + 6_897.00f + 4_680.00f + 1_385.00f + (salaryDifference * taxRate[4]);
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 204_100 && salary <= 510_300) {
			salaryDifference = salary - 204_100;
			taxPaid = 14_112.00f + 18_192.00f + 6_897.00f + 4_680.00f + 1_385.00f + (salaryDifference * taxRate[5]);
		}
		
		if (status.equals(EStatus.HEAD_OF_HOUSEHOLD) && salary > 510_300) {
			salaryDifference = salary - 510_300;
			taxPaid = 107_170.00f + 14_112.00f + 18_192.00f + 6_897.00f + 4_680.00f + 1_385.00f + (salaryDifference * taxRate[6]);
		}

		return taxPaid;
	}
	
}
