package com.bistu.paotui.service;

import com.bistu.paotui.dao.TeachOrderRepository;
import com.bistu.paotui.entity.TeachOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachOrderService {
	private TeachOrderRepository teachOrderRepository;

	@Autowired
	public TeachOrderService(TeachOrderRepository teachOrderRepository) {
		this.teachOrderRepository = teachOrderRepository;
	}

	public TeachOrder addOrder(TeachOrder teachOrder) {
		return teachOrderRepository.save(teachOrder);
	}

	public List getOrders() {
		return teachOrderRepository.findAll();
	}
}
