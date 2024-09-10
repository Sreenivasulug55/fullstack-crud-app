package com.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.main.dtos.DTOMapping;
import com.main.dtos.ProductDTO;
import com.main.service.ProductService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	// GET Methods
	@GetMapping("/products")
	public List<ProductDTO> getAllProducts() {
		return productService.getAllproducts();
	}

	@GetMapping("/get-product/{id}")
	public ProductDTO getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}

	@GetMapping("/get-productsbycategoryid/{id}")
	public List<ProductDTO> getProductByCategoryId(@PathVariable long id) {
		return productService.getproductsByCategoryId(id);
	}

	// POST Methods
	@PostMapping("/add-product")
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO entity) {
		productService.saveProduct(DTOMapping.getProduct(entity));
		return ResponseEntity.ok("Submitted");
	}

	// PUT Methods
	@PutMapping("/update-product")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDTO entity) {
		productService.updateProduct(DTOMapping.getProduct(entity));
		return ResponseEntity.ok("Updated");
	}

	// DELETE Methods
	@DeleteMapping("/delete-product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable long id) {
		productService.deleteById(id);
		return ResponseEntity.ok("deleted");
	}

}
