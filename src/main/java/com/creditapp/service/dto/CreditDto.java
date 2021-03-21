package com.creditapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditDto {
    private Long id;
    private String creditName;
    private Long customerId;
    private Long productId;
}
