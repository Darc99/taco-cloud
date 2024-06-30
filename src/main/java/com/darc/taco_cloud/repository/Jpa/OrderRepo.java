package com.darc.taco_cloud.repository.Jpa;

// import java.util.Date;
// import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.darc.taco_cloud.model.TacoOrder;

public interface OrderRepo extends CrudRepository<TacoOrder, Long> {

  // List<TacoOrder> findByDeliveryZip(String deliveryZip);

  // List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
  //   String deliveryZip, Date startDate, Date endDate
  // );

}
