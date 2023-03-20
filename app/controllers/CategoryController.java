package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.CategoryDto;
import models.Category;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http;
import services.CategoryService;

import javax.inject.Inject;

import java.util.List;
import java.util.concurrent.CompletionStage;

import static play.libs.Json.fromJson;

public class CategoryController extends Controller {

    private final CategoryService categoryService;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public CategoryController(CategoryService categoryService, HttpExecutionContext httpExecutionContext) {
        this.categoryService = categoryService;
        this.httpExecutionContext = httpExecutionContext;
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        CategoryDto CategoryDto = fromJson(json, CategoryDto.class);

        return categoryService.createCategory(CategoryDto)
                .thenApplyAsync(category -> {
                    CategoryDto dto = new CategoryDto(category.getName());
                    return created(Json.toJson(dto));
                }, httpExecutionContext.current());
    }

    public Result findAll() {
        List<Category> categories = categoryService.findAllCategories();
        JsonNode json = Json.toJson(categories);
        return ok(json);
    }

}

