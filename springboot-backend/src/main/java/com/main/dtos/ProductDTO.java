package com.main.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;  

public class ProductDTO {
//    @JsonIgnore
    private Long id;
    private String modelName;
    private String companyName;
    private Double price;	
//    @JsonIgnore
    private Long categoryId;
    private String category;  // Use this field for category name

    
    
    // Constructor
    public ProductDTO(Long id ,String modelName, String companyName, Double price, Long categoryId, String category) {
    	this.id = id;
        this.modelName = modelName;
        this.companyName = companyName;
        this.price = price;
        this.categoryId = categoryId;
        this.category = category;
    }

    public ProductDTO() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", modelName=" + modelName + ", companyName=" + companyName + ", price=" + price
				+ ", categoryId=" + categoryId + ", category=" + category + "]";
	}
    
}
