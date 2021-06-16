package edu.citytech.cst4713.tax.model;

import edu.citytech.sp2020.marginal.tax.EStatus;

public class Tax {
	
	public final int ruleNo;
	public final int year;
	public final EStatus status;
	public final float percentage;
	public final float range;
	public final float range2;
	
	
	public Tax() {
		this.ruleNo = 0;
		this.year = 0;
		this.status = null;
		this.percentage = 0;
		this.range = 0;
		this.range2 = 0;
	}
	

	public Tax(int ruleNo, int year, EStatus status, float percentage, float range, float range2) {
		this.ruleNo = ruleNo;
		this.year = year;
		this.status = status;
		this.percentage = percentage;
		this.range = range;
		this.range2 = range2;
	}


	@Override
	public String toString() {
		return "Tax [ruleNo=" + ruleNo + ", year=" + year + ", status=" + status + ", percentage=" + percentage
				+ ", range=" + range + ", range2=" + range2 + "]";
	}
	
	
	
	
	
}
