package com.darc.taco_cloud.model;

import java.util.List;

import lombok.Data;

@Data
public class Taco {
  
  private String name;

  private List<Ingredient> ingredients;
}
