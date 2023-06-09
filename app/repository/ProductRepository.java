package repository;

import dto.ProductDto;
import models.Category;
import models.Product;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class ProductRepository {
    private final JPAApi jpaApi;

    @Inject
    public ProductRepository(JPAApi api) {
        this.jpaApi = api;
    }

    public CompletableFuture<Product> create(ProductDto productDto) {
        return CompletableFuture.supplyAsync(() -> {
            return jpaApi.withTransaction((EntityManager em) -> {
                Category category = getCategoryByName(em, productDto.getCategory());
                if (category == null) {
                    throw new IllegalArgumentException("Category Not Found");
                }
                Product product = new Product(productDto.getName(), productDto.getPrice(), category);
                em.persist(product);
                return product;
            });
        });
    }

    public CompletionStage<List<Product>> findAll(int page, int pageSize, String sortBy) {
        return CompletableFuture.supplyAsync(() -> {
            return jpaApi.withTransaction((EntityManager em) -> {
                CriteriaBuilder cb = em.getCriteriaBuilder();
                CriteriaQuery<Product> cq = cb.createQuery(Product.class);
                Root<Product> root = cq.from(Product.class);

                // sorting
                if(sortBy != null && !sortBy.isEmpty()) {
                    if(sortBy.equals("id")) {
                        cq.orderBy(cb.asc(root.get("id")));
                    } else {
                        cq.orderBy(cb.asc(root.get(sortBy)));
                    }
                }

                // pagination
                int offset = (page - 1) * pageSize;
                cq.select(root).orderBy(cb.asc(root.get("id")));
                TypedQuery<Product> query = em.createQuery(cq).setFirstResult(offset).setMaxResults(pageSize);
                List<Product> products = query.getResultList();

                return products;
            });
        }).thenApplyAsync(products -> new ArrayList<>(products));
    }

    public CompletionStage<Product> findById(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            return jpaApi.withTransaction((EntityManager em) -> {
                return em.find(Product.class, id);
            });
        });
    }


    public CompletionStage<Integer> delete(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            return jpaApi.withTransaction((EntityManager em) -> {
                Query query = em.createQuery("DELETE FROM Product p WHERE p.id = :id");
                query.setParameter("id", id);
                return query.executeUpdate();
            });
        });
    }

    public CompletionStage<Product> update(Long id, ProductDto productDTO) {
        return CompletableFuture.supplyAsync(() -> {
            return jpaApi.withTransaction((EntityManager em) -> {
                Product existingProduct = em.find(Product.class, id);
                if (existingProduct != null) {
                    Category category = getCategoryByName(em, productDTO.getCategory());
                    if (category == null) {
                        throw new IllegalArgumentException("Category not found");
                    }
                    existingProduct.setName(productDTO.getName());
                    existingProduct.setPrice(productDTO.getPrice());
                    existingProduct.setCategory(category);
                    em.merge(existingProduct);
                }
                return existingProduct;
            });
        });
    }

    private Category getCategoryByName(EntityManager em, String categoryName) {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.name = :name", Category.class);
        query.setParameter("name", categoryName);
        List<Category> categories = query.getResultList();
        return categories.isEmpty() ? null : categories.get(0);
    }
}
