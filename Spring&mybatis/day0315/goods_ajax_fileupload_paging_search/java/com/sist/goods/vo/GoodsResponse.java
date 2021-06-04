package com.sist.goods.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsResponse {
	private int totalPage;
	private List<GoodsVo> list;
}






