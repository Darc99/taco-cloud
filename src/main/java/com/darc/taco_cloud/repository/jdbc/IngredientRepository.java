package com.darc.taco_cloud.repository.jdbc;

import java.util.Optional;

import com.darc.taco_cloud.model.Ingredient;

public interface IngredientRepository {
  
  Iterable<Ingredient> findAll();

  Optional<Ingredient> findById(String id);

  Ingredient save(Ingredient ingredient);
}
