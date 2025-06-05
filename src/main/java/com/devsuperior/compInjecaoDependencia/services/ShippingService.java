package com.devsuperior.compInjecaoDependencia.services;

import com.devsuperior.compInjecaoDependencia.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private Double shippingValue;

    public double shipment(Order order) {
        //retorna valor do frete, pedidos abaixo de R$ 100 -> 20 - de R$ 100 até R$ 200 -> 12 - acima de R$ 200 -> grátis

        if (order.getBasic() < 100) {
            shippingValue = 20.00;
        } else if (order.getBasic() > 100 && order.getBasic() <= 200) {
            shippingValue = 12.00;
            order.setDiscount(12.00);
        } else {
            shippingValue = 0.00;
        }

        return shippingValue;
    }
}
