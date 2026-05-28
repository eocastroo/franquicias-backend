package com.proyecto.franquicias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.franquicias.model.Franchise;

public interface FranchiseRepository
        extends JpaRepository<Franchise, Long> {

}