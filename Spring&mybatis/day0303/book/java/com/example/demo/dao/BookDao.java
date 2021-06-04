package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.BookManager;
import com.example.demo.vo.BookVo;

@Repository
public class BookDao {
	public List<BookVo> findAll(){
		return BookManager.findAll();
	}
	
	public BookVo selectBook(int no) {
		return BookManager.selectBook(no);
	}
}








