package com.devsuperior.compInjecaoDependencia.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Order {

    private Integer code;
    private Double basic;
    private Double discount;
}
