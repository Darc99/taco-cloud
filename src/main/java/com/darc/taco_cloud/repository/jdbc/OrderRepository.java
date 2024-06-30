package com.darc.taco_cloud.repository.jdbc;

import org.springframework.data.repository.CrudRepository;

import com.darc.taco_cloud.model.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    // TacoOrder save(TacoOrder order);
}
