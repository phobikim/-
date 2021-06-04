package com.sist.exam03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public Book book() {
		Book book = new Book();
		book.setNo(100);
		book.setName("����ִ� ������");
		book.setPrice(35000);
		book.setPublisher("�ֿ뱳������");
		return book;
	}
	
	@Bean
	public BookDao bookDao() {
		BookDao dao = new BookDao();
		dao.setBook(book());
		dao.setCnt(10);
		return dao;
	}
}





