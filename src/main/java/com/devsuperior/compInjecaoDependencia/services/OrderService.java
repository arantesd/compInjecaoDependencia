package com.devsuperior.compInjecaoDependencia.services;

import com.devsuperior.compInjecaoDependencia.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    private Double updatedValue;

    public double total(Order order) {
        //retorna valor total do pedido, considerando desconto no valor do pedido e adiciona valor do frete

        if (order.getDiscount().compareTo(0.0) == 1){
            // se tiver desconto
            updatedValue = order.getBasic() - (order.getBasic() * (order.getDiscount() / 100));
        } else {
           updatedValue = order.getBasic();
        }

        return updatedValue + shippingService.shipment(order);
    }
}
