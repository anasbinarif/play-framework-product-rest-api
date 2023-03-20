package services;
import dto.ProductDto;
import models.Product;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import repository.ProductRepository;

import javax.inject.Inject;


import java.nio.charset.CharacterCodingException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {

    private final ProductRepository repository;

    @Inject
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public CompletionStage<ProductDto> create(ProductDto productDTO) {
        return repository.create(productDTO).thenApplyAsync(product -> new ProductDto(product));
    }

    public CompletionStage<List<Product>> getAllProducts(int page, int pageSize, String sortBy) {
        return repository.findAll(page, pageSize, sortBy);
    }

    public CompletionStage<ProductDto> findById(Long id) {
        return repository.findById(id).thenApplyAsync(product -> new ProductDto(product));
    }

    public CompletionStage<Boolean> deleteProduct(Long id) {
        return repository.delete(id).thenApplyAsync(rowsAffected -> {
            return rowsAffected > 0;
        });
    }

    public CompletionStage<Product> updateProduct(Long id, ProductDto product) {
        return repository.update(id, product);
    }

}

