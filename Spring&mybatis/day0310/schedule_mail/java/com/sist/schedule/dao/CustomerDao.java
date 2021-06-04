package com.sist.schedule.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.schedule.db.DBManager;
import com.sist.schedule.vo.Customer;



@Repository
public class CustomerDao {
	public List<Customer> findAll(){
		return DBManager.listCustomer();
	}
	
}
