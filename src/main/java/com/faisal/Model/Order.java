package com.faisal.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
	@NonNull
	private Integer order_id;
	@NonNull
	private Integer emp_id;
	@NonNull
	private String order_name;
	@NonNull
	private Integer order_quantity ;
	@NonNull
	private Integer order_price;
}
