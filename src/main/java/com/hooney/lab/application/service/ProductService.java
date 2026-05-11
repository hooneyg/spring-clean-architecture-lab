package com.hooney.lab.application.service;

import com.hooney.lab.application.port.in.CreateProductUseCase;
import com.hooney.lab.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService implements CreateProductUseCase {
    
    @Override
    public void createProduct(Command command) {
        // 비즈니스 로직 및 저장 로직 구현 (데모용)
        Product product = new Product(null, command.name(), command.price());
        System.out.println("Product Created: " + product.getName());
    }
}
