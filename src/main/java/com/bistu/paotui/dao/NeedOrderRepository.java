package com.bistu.paotui.dao;

import com.bistu.paotui.entity.NeedOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeedOrderRepository extends JpaRepository<NeedOrder, Integer> {
}
