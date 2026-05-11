package com.hooney.lab.application.port.in;

import java.math.BigDecimal;

public interface CreateProductUseCase {
    void createProduct(Command command);

    record Command(String name, BigDecimal price) {}
}
