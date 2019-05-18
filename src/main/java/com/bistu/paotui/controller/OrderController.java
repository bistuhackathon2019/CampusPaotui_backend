package com.bistu.paotui.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bistu.paotui.entity.NeedOrder;
import com.bistu.paotui.entity.TeachOrder;
import com.bistu.paotui.service.NeedOrderService;
import com.bistu.paotui.service.TeachOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
	private NeedOrderService needOrderService;
	private TeachOrderService teachOrderService;

	@Autowired
	public OrderController(NeedOrderService needOrderService, TeachOrderService teachOrderService) {
		this.needOrderService = needOrderService;
		this.teachOrderService = teachOrderService;
	}

	@PostMapping(value = "/need", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNeedOrder(@RequestBody NeedOrder needOrder) {
		needOrder = needOrderService.addOrder(needOrder);
		if (needOrder.getOrderId() == null)
			return ResponseEntity.ok("fail");
		return ResponseEntity.ok("ok");
	}

	@GetMapping(value = "/needinquire", produces = MediaType.APPLICATION_JSON_VALUE)
	public List inquireNeed() {
		return needOrderService.getOrders();
	}

	@PostMapping(value = "/needteach", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addTeachOrder(@RequestBody TeachOrder teachOrder) {
		teachOrder = teachOrderService.addOrder(teachOrder);
		if (teachOrder.getOrderId() == null)
			return ResponseEntity.ok("fail");
		return ResponseEntity.ok("ok");
	}

	@GetMapping(value = "teachinquire", produces = MediaType.APPLICATION_JSON_VALUE)
	public List inquireTeach() {
		return teachOrderService.getOrders();
	}

//	@PostMapping(value = "accept", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> acceptOrder(String jsonString) {
//		JSONObject json = JSON.parseObject(jsonString, JSONObject.class);
//
//	}
}
