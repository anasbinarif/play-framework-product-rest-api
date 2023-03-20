package repository;

import models.Category;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class SeedData {

    private final JPAApi jpaApi;

    @Inject
    public SeedData(JPAApi jpaApi, CategoryRepository categoryRepository) {
        this.jpaApi = jpaApi;
    }

    public void insertCategories() {
        jpaApi.withTransaction((EntityManager em) -> {
            em.persist(new Category("Electronics"));
            em.persist(new Category("Clothing"));
            em.persist(new Category("Books"));
            em.persist(new Category("Sports"));
            return null;
        });

    }
}
