package com.devsuperior.compInjecaoDependencia;

import com.devsuperior.compInjecaoDependencia.entities.Order;
import com.devsuperior.compInjecaoDependencia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class CompInjecaoDependenciaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CompInjecaoDependenciaApplication.class, args);
	}

	@Autowired
	private Order order;

	@Autowired
	private OrderService orderService;


	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o número do pedido:");
		Integer orderCode = scanner.nextInt();
		order.setCode(orderCode);

		System.out.println("Digite o valor do pedido ");
		Double orderBasic = scanner.nextDouble();
		order.setBasic(orderBasic);

		System.out.println("Digite a porcentagem de desconto do pedido:");
		Double orderDiscount = scanner.nextDouble();
		order.setDiscount(orderDiscount);

		System.out.println("O valor total do pedido " + order.getCode() + " é R$ " + orderService.total(order));
	}
}
