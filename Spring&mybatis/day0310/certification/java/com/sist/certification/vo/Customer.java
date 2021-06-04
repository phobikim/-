package com.sist.certification.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private int no;
	private String name;
	private String email;
	private String phone;
	private int tot;
}
