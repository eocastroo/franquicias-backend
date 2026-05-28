package com.proyecto.franquicias.service;

import org.springframework.http.ResponseEntity;

import com.proyecto.franquicias.model.branch;
import com.proyecto.franquicias.response.BranchResponseREST;

public interface BranchService {

    public ResponseEntity<BranchResponseREST> search();

    public ResponseEntity<BranchResponseREST> searchById(Long id);

    public ResponseEntity<BranchResponseREST> save(branch branch);

    public ResponseEntity<BranchResponseREST> update(branch branch, Long id);

    public ResponseEntity<BranchResponseREST> deleteById(Long id);

}