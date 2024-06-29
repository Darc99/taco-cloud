package com.darc.taco_cloud.repository.jdbc;

import com.darc.taco_cloud.model.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);
}
