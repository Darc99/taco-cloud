package com.darc.taco_cloud.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
// import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Taco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Date createdAt = new Date();

  @NotNull
  @Size(min = 5, message = "Name must be at least 5 characters long")
  private String name;

  @Size(min = 1, message = "You must choose at least 1 ingredient")
  @ManyToMany
  private List<Ingredient> ingredients;

  public void addIngredient(Ingredient ingredient) {
    this.ingredients.add(ingredient);
  }
}
