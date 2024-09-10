package com.main.dtos;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.main.entities.Product;

public class DTOMapping {

	public static Product getProduct(ProductDTO productDTO) {
		long id = productDTO.getId() != null ? productDTO.getId() : 0L;
		return new Product(id, productDTO.getModelName(), productDTO.getCompanyName(),
				productDTO.getCategoryId(), productDTO.getCategory(), productDTO.getPrice());
	}

	public static ProductDTO getProductDTO(Product product) {
		return new ProductDTO(product.getId(),product.getModelName(), product.getCompanyName(), product.getPrice(),
				product.getCategory().getId(), product.getCategory().getName());
	}
	
	public static List<ProductDTO> getProductDTOList(List<Product> productList) {
		return productList.stream().map(product -> getProductDTO(product)).collect(Collectors.toList());
	}
//
}
