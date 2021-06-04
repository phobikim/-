package com.sist.exam04;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Bean
	public Book book() {
		Book book = new Book();
		book.setNo(100);
		book.setName("재미있는 스프링");
		book.setPrice(35000);
		book.setPublisher("쌍용교육센터");
		return book;
	}
	
	@Bean(autowire = Autowire.BY_TYPE)
	public BookDao bookDao() {
		BookDao dao = new BookDao();
		//dao.setBook(book());
		dao.setCnt(10);
		return dao;
	}
}





