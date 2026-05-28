package com.proyecto.franquicias.service;

import org.springframework.http.ResponseEntity;

import com.proyecto.franquicias.model.Franchise;
import com.proyecto.franquicias.response.FranchiseResponseREST;

public interface FranchiseService {

    public ResponseEntity<FranchiseResponseREST> search();

    public ResponseEntity<FranchiseResponseREST> searchById(Long id);

    public ResponseEntity<FranchiseResponseREST> save(Franchise franchise);

    public ResponseEntity<FranchiseResponseREST> update(Franchise franchise, Long id);

    public ResponseEntity<FranchiseResponseREST> deleteById(Long id);

}