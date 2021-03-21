package com.creditapp.service.mapper;

import com.creditapp.model.Credit;
import com.creditapp.service.dto.CreditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class CreditDtoMapper {
    @Transactional
    public CreditDto toDto(Credit credit) {
        return CreditDto.builder()
                .id(credit.getId())
                .creditName(credit.getCreditName())
                .customerId(credit.getCustomer().getId())
                .productId(credit.getProduct().getId())
                .build();
    }
}
