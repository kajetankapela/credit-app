package com.creditapp.service;

import com.creditapp.controller.exception.NotFound;
import com.creditapp.model.Credit;
import com.creditapp.model.Customer;
import com.creditapp.model.Product;
import com.creditapp.repository.CreditRepository;
import com.creditapp.repository.CustomerRepository;
import com.creditapp.repository.ProductRepository;
import com.creditapp.service.dto.*;
import com.creditapp.service.mapper.CreditDtoMapper;
import com.creditapp.service.mapper.GetCreditDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CreditService {
    private final CreditRepository creditRepository;
    private final CreditDtoMapper creditDtoMapper;
    private final GetCreditDtoMapper getCreditDtoMapper;
    private final CustomerService customerService;
    private final ProductService productService;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Transactional
    public List<GetCreditDto> getAllCredits() {
        return creditRepository.findAll()
                .stream()
                .map(getCreditDtoMapper::toGetDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CreditDto createCredit(CreateCreditDto createCreditDto,
                                  CreateCustomerDto createCustomerDto,
                                  CreateProductDto createProductDto) throws NotFound {

        ProductDto productDto = productService.createProduct(createProductDto);
        Product product = productRepository.findById(productDto.getId()).orElseThrow(NotFound::new);
        CustomerDto customerDto = customerService.createCustomer(createCustomerDto);
        Customer customer = customerRepository.findById(customerDto.getId()).orElseThrow();

        Credit credit = Credit.builder()
                .creditName(createCreditDto.getCreditName())
                .customer(customer)
                .product(product)
                .build();

        Credit savedCredit = creditRepository.save(credit);

        return creditDtoMapper.toDto(savedCredit);
    }
}
