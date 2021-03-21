package com.creditapp.service;

import com.creditapp.model.Product;
import com.creditapp.repository.ProductRepository;
import com.creditapp.service.dto.CreateProductDto;
import com.creditapp.service.dto.ProductDto;
import com.creditapp.service.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;

    @Transactional
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDto createProduct(CreateProductDto createProductDto) {
        Product product = Product.builder()
                .productName(createProductDto.getProductName())
                .value(createProductDto.getValue())
                .build();

        Product savedProduct = productRepository.save(product);
        return productDtoMapper.toDto(savedProduct);
    }
}
