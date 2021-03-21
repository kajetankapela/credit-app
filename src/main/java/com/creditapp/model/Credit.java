package com.creditapp.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Credit {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String creditName;

    @OneToOne
    @Builder.Default
    private Customer customer = new Customer();

    @OneToOne
    @Builder.Default
    private Product product = new Product();
}
