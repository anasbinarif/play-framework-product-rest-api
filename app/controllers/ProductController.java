package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.ProductDto;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import services.ProductService;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;


public class ProductController extends Controller {

    private final ProductService productService;
    private final HttpExecutionContext httpExecutionContext;

    @Inject
    public ProductController(ProductService productService, HttpExecutionContext httpExecutionContext) {
        this.productService = productService;
        this.httpExecutionContext = httpExecutionContext;
    }

    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        ProductDto ProductDto = Json.fromJson(json, ProductDto.class);
        return productService.create(ProductDto).thenApplyAsync(product -> {
            return created(Json.toJson(product));
        }, httpExecutionContext.current());
    }

    public CompletionStage<Result> findAll(int page, int pageSize, String sortBy) {
        return productService.getAllProducts(page, pageSize, sortBy).thenApplyAsync(products -> {
            return ok(Json.toJson(products));
        });
    }

    public CompletionStage<Result> getById(Long id) {
        return productService.findById(id).thenApplyAsync(productDTO -> {
            if (productDTO == null) {
                return notFound();
            } else {
                return ok(Json.toJson(productDTO));
            }
        }, httpExecutionContext.current());
    }

    public CompletionStage<Result> delete(Long id) {
        return productService.deleteProduct(id).thenApplyAsync(isDeleted -> {
            if (isDeleted) {
                return noContent();
            } else {
                return notFound();
            }
        }, httpExecutionContext.current());
    }

    public CompletionStage<Result> update(Long id, Http.Request request) {
        JsonNode json = request.body().asJson();
        ProductDto ProductDto = Json.fromJson(json, ProductDto.class);
        return productService.updateProduct(id, ProductDto).thenApplyAsync(product -> {
            if (product == null) {
                return notFound();
            } else {
                return ok(Json.toJson(product));
            }
        }, httpExecutionContext.current());
    }

}
