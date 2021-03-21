package com.creditapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCreditDto {
    private Long id;
    private String creditName;
    private String customerFirstName;
    private String customerSurname;
    private String customerPesel;
    private String productName;
    private Long productValue;
}
