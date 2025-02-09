package com.darc.taco_cloud.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.darc.taco_cloud.model.Ingredient;
import com.darc.taco_cloud.model.Taco;
import com.darc.taco_cloud.model.TacoOrder;
import com.darc.taco_cloud.model.Ingredient.Type;
// import com.darc.taco_cloud.repository.jdbc.IngredientRepository;
import com.darc.taco_cloud.repository.Jpa.IngredientRepo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

  private final IngredientRepo ingredientRepo;

  // @Autowired
  public DesignTacoController(IngredientRepo ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
  
  @ModelAttribute
  public void addIngredientsToModel(Model model) {

    Iterable<Ingredient> ingredients = ingredientRepo.findAll();
    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
        filterByType(ingredients, type));
    }
  }

  @ModelAttribute(name = "tacoOrder")
  public TacoOrder order() {
    return new TacoOrder();
  }

  @ModelAttribute(name= "taco")
  public Taco taco() {
    return new Taco();
  }

  @GetMapping
  public String showDesignForm() {
    return "design";
  }

  private Iterable<Ingredient> filterByType(
    List<Ingredient> ingredients, Type type) {
      return ingredients
      .stream()
      .filter(x -> x.getType().equals(type))
      .collect(Collectors.toList());
  }

  // @valid to perform validation on taco object
  @PostMapping
  public String processTaco (@Valid Taco taco, Errors errors,
    @ModelAttribute TacoOrder tacoOrder) {

      if (errors.hasErrors()) {
        return "design";
      }
      
      tacoOrder.addTaco(taco);
      log.info("Processing taco: {}", taco);

      return "redirect:/orders/current";
    }
}
