package edu.citytech.cst4713.tax.model;

import edu.citytech.sp2020.marginal.tax.EStatus;

public class Employee {

	public final String id;
	public final EStatus code;
	public final float salary;
	public final String state;

//	public Employee() {
//		this.id = "";
//		this.code = null;
//		this.salary = 0;
//		this.state = "";
//	}

	public Employee(String id, EStatus code, float salary, String state) {
		this.id = id;
		this.code = code;
		this.salary = salary;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public EStatus getCode() {
		return code;
	}

	public float getSalary() {
		return salary;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", code=" + code + ", salary=" + salary + ", state=" + state + "]";
	}

}
