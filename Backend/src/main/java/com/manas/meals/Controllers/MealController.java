package com.manas.meals.Controllers;

import com.manas.meals.Services.MealService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meals")
@CrossOrigin
public class MealController {

    private final MealService service;

    public MealController(MealService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name) {
        return service.searchByName(name);
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable(name = "id") String id) {
        return service.getById(id);
    }

    @GetMapping("/categories")
    public String categories() {
        return service.getCategories();
    }

    @GetMapping("/category/{category}")
    public String byCategory(@PathVariable(name = "category") String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/random")
    public String random() {
        return service.getRandomMeal();
    }
}
