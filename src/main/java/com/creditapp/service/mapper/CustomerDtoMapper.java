package com.creditapp.service.mapper;

import com.creditapp.model.Customer;
import com.creditapp.service.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Component
public class CustomerDtoMapper {
    @Transactional
    public CustomerDto toDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .surname(customer.getSurname())
                .pesel(customer.getPesel())
                .creditId(customer.getCredit().getId())
                .build();
    }
}
