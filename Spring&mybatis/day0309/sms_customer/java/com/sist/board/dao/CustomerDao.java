package com.sist.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.board.db.DBManager;
import com.sist.board.vo.Customer;

@Repository
public class CustomerDao {
	public List<Customer> findAll(){
		return DBManager.listCustomer();
	}
	
}
