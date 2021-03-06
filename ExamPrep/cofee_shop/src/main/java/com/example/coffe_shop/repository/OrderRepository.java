package com.example.coffe_shop.repository;

import com.example.coffe_shop.models.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

    List<Orders> findAllByOrderByPriceDesc();
}
