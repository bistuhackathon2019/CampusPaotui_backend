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
import org.springframework.web.bind.annotation.*;

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

	@GetMapping(value = "/need", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addNeedOrder(@RequestParam String destination, @RequestParam String location, @RequestParam String note) {
		NeedOrder needOrder = new NeedOrder();
		needOrder.setDestination(destination);
		needOrder.setLocation(location);
		needOrder.setNote(note);
		needOrder = needOrderService.addOrder(needOrder);
		if (needOrder.getOrderId() == null)
			return ResponseEntity.ok("fail");
		return ResponseEntity.ok("ok");
	}

	@GetMapping(value = "/needinquire", produces = MediaType.APPLICATION_JSON_VALUE)
	public List inquireNeed() {
		return needOrderService.getOrders();
	}

	@GetMapping(value = "/needteach", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addTeachOrder(@RequestParam String subject, @RequestParam String content) {
		TeachOrder teachOrder = new TeachOrder();
		teachOrder.setSubject(subject);
		teachOrder.setContent(content);
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
