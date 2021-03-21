package com.creditapp.service.mapper;

import com.creditapp.model.Product;
import com.creditapp.service.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class ProductDtoMapper {
    @Transactional
    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .creditId(product.getCredit().getId())
                .value(product.getValue())
                .build();
    }
}
