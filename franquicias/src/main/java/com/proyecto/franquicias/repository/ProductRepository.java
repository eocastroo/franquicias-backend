package com.proyecto.franquicias.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.franquicias.model.Product;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
	
	Optional<Product> findTopByBranchIdOrderByStockDesc(Long branchId);

}

