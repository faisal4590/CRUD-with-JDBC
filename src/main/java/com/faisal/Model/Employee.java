package com.faisal.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@NonNull
	private int emp_id;
	@NonNull
	private String emp_name;
	@NonNull
	private double emp_salary ;
	@NonNull
	private String emp_country;
	@NonNull
	private String emp_city;
	@NonNull
	private String emp_zipCode;
}