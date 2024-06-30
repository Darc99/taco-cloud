package com.darc.taco_cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.darc.taco_cloud.model.TacoOrder;
import com.darc.taco_cloud.repository.jdbc.OrderRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

  private OrderRepository orderRepo;

  public OrderController(OrderRepository orderRepo) {
    this.orderRepo = orderRepo;
  }

  @GetMapping("/current")
  public String orderForm() {
    return "orderForm";
  }

  // this takes in the order
  @PostMapping
  public String processOrder(@Valid TacoOrder order, 
      SessionStatus sessionStatus, Errors errors) {

    if (errors.hasErrors()) {
      return "orderForm";
    }
    
    orderRepo.save(order);
    log.info("Order submitted: {}", order);
    sessionStatus.setComplete();

    return "redirect:/";
  }
}