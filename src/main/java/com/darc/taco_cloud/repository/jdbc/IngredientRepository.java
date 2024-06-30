package com.darc.taco_cloud.repository.jdbc;

// import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

// import org.springframework.data.repository.Repository;

import com.darc.taco_cloud.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
  
  // Iterable<Ingredient> findAll();

  // Optional<Ingredient> findById(String id);

  // Ingredient save(Ingredient ingredient);
}
