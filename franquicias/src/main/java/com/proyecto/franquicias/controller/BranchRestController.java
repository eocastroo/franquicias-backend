package com.proyecto.franquicias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.franquicias.model.branch;
import com.proyecto.franquicias.response.BranchResponseREST;
import com.proyecto.franquicias.service.BranchService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/branches")
public class BranchRestController {

    @Autowired
    private BranchService service;

    /*
     * get all branches
     */
    @GetMapping
    public ResponseEntity<BranchResponseREST> searchBranches() {

        ResponseEntity<BranchResponseREST> response = service.search();

        return response;
    }

    /*
     * get branch by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<BranchResponseREST> searchById(@PathVariable Long id) {

        ResponseEntity<BranchResponseREST> response = service.searchById(id);

        return response;
    }

    /*
     * save branch
     */
    @PostMapping
    public ResponseEntity<BranchResponseREST> save(@RequestBody branch branch) {

        ResponseEntity<BranchResponseREST> response = service.save(branch);

        return response;
    }

    /*
     * update branch
     */
    @PutMapping("/{id}")
    public ResponseEntity<BranchResponseREST> update(
            @RequestBody branch branch,
            @PathVariable Long id) {

        ResponseEntity<BranchResponseREST> response =
                service.update(branch, id);

        return response;
    }

    /*
     * delete branch
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<BranchResponseREST> delete(@PathVariable Long id) {

        ResponseEntity<BranchResponseREST> response =
                service.deleteById(id);

        return response;
    }

}