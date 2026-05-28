
package com.proyecto.franquicias.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.franquicias.model.branch;

public interface BranchRepository
        extends JpaRepository<branch, Long> {

}