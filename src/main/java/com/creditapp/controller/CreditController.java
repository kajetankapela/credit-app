package com.creditapp.controller;

import com.creditapp.controller.exception.NotFound;
import com.creditapp.service.CreditService;
import com.creditapp.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/credits")
public class CreditController {
    private final CreditService creditService;

    @GetMapping()
    public List<GetCreditDto> getCredits() {
        return creditService.getAllCredits();
    }

    @PostMapping()
    public Long createCredit(@RequestBody CreateCreditDto createCreditDto,
                                  @RequestBody CreateCustomerDto createCustomerDto,
                                  @RequestBody CreateProductDto createProductDto) throws NotFound {
        CreditDto creditDto = creditService.createCredit(createCreditDto, createCustomerDto, createProductDto);
        return creditDto.getId();
    }
}
