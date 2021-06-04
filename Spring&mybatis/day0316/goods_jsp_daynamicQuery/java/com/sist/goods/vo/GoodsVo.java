package com.sist.goods.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {
	private int no;
	private String name;
	private int qty;
	private int price;
	private String fname;
}
