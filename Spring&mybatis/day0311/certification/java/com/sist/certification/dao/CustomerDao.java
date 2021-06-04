package com.sist.certification.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.certification.db.DBManager;
import com.sist.certification.vo.Customer;



@Repository
public class CustomerDao {
	public List<Customer> findAll(){
		return DBManager.listCustomer();
	}
	
	public int insert(Customer c) {
		return DBManager.insert(c);
	}
}
