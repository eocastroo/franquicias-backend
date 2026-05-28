package com.proyecto.franquicias.controller;

import com.proyecto.franquicias.model.Franchise;
import com.proyecto.franquicias.response.FranchiseResponseREST;
import com.proyecto.franquicias.service.FranchiseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/franchises")
public class franquiciasRestcontroller {

    @Autowired
    private FranchiseService service;

    /*
     * get all franchises
     */
    @GetMapping
    public ResponseEntity<FranchiseResponseREST> searchFranchises() {

        ResponseEntity<FranchiseResponseREST> response = service.search();

        return response;
    }

    /*
     * get franchise by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<FranchiseResponseREST> searchById(@PathVariable Long id) {

        ResponseEntity<FranchiseResponseREST> response = service.searchById(id);

        return response;
    }

    /*
     * save franchise
     */
    @PostMapping
    public ResponseEntity<FranchiseResponseREST> save(@RequestBody Franchise franchise) {

        ResponseEntity<FranchiseResponseREST> response = service.save(franchise);

        return response;
    }

    /*
     * update franchise
     */
    @PutMapping("/{id}")
    public ResponseEntity<FranchiseResponseREST> update(
            @RequestBody Franchise franchise,
            @PathVariable Long id) {

        ResponseEntity<FranchiseResponseREST> response =
                service.update(franchise, id);

        return response;
    }

    /*
     * delete franchise
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<FranchiseResponseREST> delete(@PathVariable Long id) {

        ResponseEntity<FranchiseResponseREST> response =
                service.deleteById(id);

        return response;
    }

}