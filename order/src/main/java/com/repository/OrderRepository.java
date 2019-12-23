package com.repository;

import com.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @author: yangyingyang
 * @date: 2019/11/30.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
