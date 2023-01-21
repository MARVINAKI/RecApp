package com.example.recapp.controllers;

import com.example.recapp.model.Ingredient;
import com.example.recapp.model.Recipe;
import com.example.recapp.services.IngredientService;
import com.example.recapp.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Tag(name = "Рецепты",
        description = "Создание и редактирование рецептов")
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recService;
    private final IngredientService ingService;


    public RecipeController(RecipeService recService, IngredientService ingService) {
        this.recService = recService;
        this.ingService = ingService;
    }

    @PostMapping
    @Operation(summary = "Создание нового рецепта",
            description = "Создается новый рецепт и добавляется в базу данных рецптов, " +
                    "также ингредиенты рецепта создаются автоматически и добавляются в базу данных ингредиентов")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        recService.addRecipe(recipe);
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingService.addIngredient(ingredient);
        }
        return recipe;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Поиск и вывод рецепта",
            description = "Ищет, интересующий Вас, рецепт по id и выводит его")
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Recipe recipe = recService.getRecipe(id);
        return recipe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipe);
    }

    @GetMapping("/find")
    @Operation(summary = "Поиск рецепта(ов) по ингредиентам",
            description = "По одному или более ингредиентам находит и выводит рецепт(ы) с содержанием данных ингредиентов")
    public ResponseEntity<Collection<Recipe>> findRecByIng(@RequestParam int... id) {
        return ResponseEntity.ok(recService.findRecByIng(id));
    }

    @GetMapping("/print")
    @Operation(summary = "Поиск рецептов",
            description = "Поиск и вывод полного списка рецептов")
    public Collection<Recipe> getAllRecipes() {
        return recService.getAllRecipes();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Изменение рецепта",
            description = "Возможность изменить частично или полностью рецепт " +
                    "(выбор объекта по id, обязательно создаем полностью объект для замены)")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id,
                                             @RequestBody Recipe newRecipe) {
        Recipe recipe = recService.editRecipe(id, newRecipe);
        return recipe == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление рецепта",
            description = "Полное удаление рецепта из базы (выбор объекта по id). Удаление ингредиентов рецепта из базы не производится")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        return recService.deleteRecipe(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
