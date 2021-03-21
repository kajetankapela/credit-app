package com.creditapp.service.dto;

import com.creditapp.model.Credit;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private Long value;
    private Long creditId;

}
