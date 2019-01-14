package com.casd.dao.uc;

import java.util.List;

import com.casd.entity.uc.Order;



/**
*
*DAO 账户信息  
*/
public interface IOrderDao {
	
	List<Order> findAll();
	
}
