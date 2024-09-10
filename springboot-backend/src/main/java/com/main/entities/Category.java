package com.main.entities;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productcategories")
public class Category {
	@Id
	Long id;
	String categoryName;

	@OneToMany(mappedBy = "category")
	@JsonBackReference
	List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String name) {
		this.categoryName = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(Long id, String name, List<Product> products) {
		super();
		this.id = id;
		this.categoryName = name;
		this.products = products;
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.categoryName = name;

	}

	public Category() {
		super();
	}
}
