package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import repository.CategoryRepository;
import repository.SeedData;

import javax.inject.Inject;

public class SeedDataController extends Controller {

    private final SeedData seedData;
    private final CategoryRepository categoryRepository;

    @Inject
    public SeedDataController(SeedData seedData, CategoryRepository categoryRepository) {
        this.seedData = seedData;
        this.categoryRepository = categoryRepository;
    }

    public Result insertCategories() {
        if (categoryRepository.findAll().isEmpty()) {
            seedData.insertCategories();
            return ok("Seed Categories inserted.");
        } else {
            return ok("Seed Categories already inserted. ❌");
        }
    }
}

