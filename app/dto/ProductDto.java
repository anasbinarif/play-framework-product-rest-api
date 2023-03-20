package dto;

import models.Product;

public class ProductDto {
    private String id;
    private String name;
    private float price;
    private String category;

    public ProductDto() {
    }

    public ProductDto(String id, String name, float price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public ProductDto(Product data) {
        this.id = data.getId().toString();
        this.name = data.getName();
        this.price = data.getPrice();
        this.category = data.getCategory().getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
