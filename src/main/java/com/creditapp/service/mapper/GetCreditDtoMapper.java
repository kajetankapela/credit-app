package com.creditapp.service.mapper;

import com.creditapp.model.Credit;
import com.creditapp.service.dto.GetCreditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class GetCreditDtoMapper {
    @Transactional
    public GetCreditDto toGetDto(Credit credit) {
        return GetCreditDto.builder()
                .id(credit.getId())
                .creditName(credit.getCreditName())
                .customerFirstName(credit.getCustomer().getFirstName())
                .customerSurname(credit.getCustomer().getSurname())
                .customerPesel(credit.getCustomer().getPesel())
                .productName(credit.getProduct().getProductName())
                .productValue(credit.getProduct().getValue())
                .build();
    }

}
