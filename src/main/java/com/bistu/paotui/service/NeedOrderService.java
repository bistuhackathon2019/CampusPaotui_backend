package com.bistu.paotui.service;

import com.bistu.paotui.dao.NeedOrderRepository;
import com.bistu.paotui.entity.NeedOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeedOrderService {
	private NeedOrderRepository needOrderRepository;

	@Autowired
	public NeedOrderService(NeedOrderRepository needOrderRepository) {
		this.needOrderRepository = needOrderRepository;
	}

	public NeedOrder addOrder(NeedOrder order) {
		return needOrderRepository.save(order);
	}

	public List getOrders() {
		return needOrderRepository.findAll();
	}

}
