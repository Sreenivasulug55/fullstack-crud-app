package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.main.dtos.DTOMapping;
import com.main.dtos.ProductDTO;
import com.main.entities.Category;
import com.main.entities.Product;
import com.main.exceptions.ResourceNotFoundException;
import com.main.repo.CategoriesRepo;
import com.main.repo.Productrepo;

import jakarta.transaction.Transactional;

@Service
public class ProductService{

	@Autowired
	private Productrepo productrepo;

	@Autowired
	private CategoriesRepo categoriesRepo;

	public ProductDTO saveProduct(Product entity) {
		return DTOMapping.getProductDTO(productrepo.save(entity));
	}

	public List<ProductDTO> getproductsByCategoryId(Long categoryId) {
		return DTOMapping.getProductDTOList(productrepo.findByCategoryId(categoryId));

	}

	public List<ProductDTO> getAllproducts() {
		return DTOMapping.getProductDTOList(productrepo.findAll());
	}

	public ProductDTO getProductById(Long productId) {
		Optional<Product> product = productrepo.findById(productId);
		if (product.isEmpty()) {
			return null;
		} else {

			return DTOMapping.getProductDTO(product.get());
		}

	}

	@Transactional
	public ProductDTO updateProduct(Product updatedProduct) {
		Optional<Product> optionalProduct = productrepo.findById(updatedProduct.getId());
		if (!optionalProduct.isPresent()) {
			throw new ResourceNotFoundException("Product With ID:" + updatedProduct.getId() + "Not Found");
		}
		Product existingProduct = optionalProduct.get();
		existingProduct.setModelName(updatedProduct.getModelName());
		existingProduct.setCompanyName(updatedProduct.getCompanyName());
		existingProduct.setPrice(updatedProduct.getPrice());

		if (updatedProduct.getCategory() != null && updatedProduct.getCategory().getId() != null) {
			Long categoryId = updatedProduct.getCategory().getId();
			Category optionalCategory = categoriesRepo.findById(categoryId)
					.orElseThrow(() -> new ResourceNotFoundException("Category With ID:" + categoryId + "Not Found"));
			existingProduct.setCategory(optionalCategory);

		}
		System.out.println("Existing Product:" + DTOMapping.getProductDTO(existingProduct));
		return DTOMapping.getProductDTO(productrepo.save(existingProduct));
	}

	@Transactional
	public void deleteById(long productId) {
		productrepo.deleteById(productId);
	}

}
