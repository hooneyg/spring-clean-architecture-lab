package com.hooney.lab.presentation.controller;

import com.hooney.lab.application.port.in.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    public void create(@RequestBody CreateProductUseCase.Command command) {
        createProductUseCase.createProduct(command);
    }
}
