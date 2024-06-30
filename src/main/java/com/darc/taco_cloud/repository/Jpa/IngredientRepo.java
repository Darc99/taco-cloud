package com.darc.taco_cloud.repository.Jpa;

import org.springframework.data.repository.CrudRepository;

import com.darc.taco_cloud.model.Ingredient;

public interface IngredientRepo extends CrudRepository<Ingredient, String> {

}
