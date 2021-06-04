package com.sist.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchEmp {
	private int empno;
	private String ename;
	private int sal;
	private int deptno;
	private String dname;
	private String loc;
}
