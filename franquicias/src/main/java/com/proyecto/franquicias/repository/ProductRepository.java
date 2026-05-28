package com.proyecto.franquicias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.franquicias.model.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

}

