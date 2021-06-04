package com.sist.exam05;

public class MySqlArticleDao implements ArticleDao {

	@Override
	public void insert() {
		System.out.println("dbms mysql을 이용하여 등록하였습니다.");
	}
}
