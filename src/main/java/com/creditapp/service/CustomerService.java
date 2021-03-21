package com.creditapp.service;

import com.creditapp.model.Customer;
import com.creditapp.repository.CustomerRepository;
import com.creditapp.service.dto.CreateCustomerDto;
import com.creditapp.service.dto.CustomerDto;
import com.creditapp.service.mapper.CustomerDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoMapper customerDtoMapper;

    @Transactional
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        Customer customer = Customer.builder()
                .firstName(createCustomerDto.getFirstName())
                .surname(createCustomerDto.getSurname())
                .pesel(createCustomerDto.getPesel())
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        return customerDtoMapper.toDto(savedCustomer);
    }
}
