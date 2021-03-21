package com.creditapp.service.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCreditDto {
    private String creditName;

    @Builder.Default
    private CreateProductDto createProductDto = new CreateProductDto();

    @Builder.Default
    private CreateCustomerDto createCustomerDto = new CreateCustomerDto();
}
