package com.proyecto.franquicias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.franquicias.model.Product;
import com.proyecto.franquicias.response.ProductResponseREST;
import com.proyecto.franquicias.service.ProductService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

    @Autowired
    private ProductService service;

    /*
     * get all products
     */
    @GetMapping
    public ResponseEntity<ProductResponseREST> searchProducts() {

        ResponseEntity<ProductResponseREST> response = service.search();

        return response;
    }

    /*
     * get product by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseREST> searchById(@PathVariable Long id) {

        ResponseEntity<ProductResponseREST> response = service.searchById(id);

        return response;
    }

    /*
     * save product
     */
    @PostMapping
    public ResponseEntity<ProductResponseREST> save(@RequestBody Product product) {

        ResponseEntity<ProductResponseREST> response = service.save(product);

        return response;
    }

    /*
     * update product
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseREST> update(
            @RequestBody Product product,
            @PathVariable Long id) {

        ResponseEntity<ProductResponseREST> response =
                service.update(product, id);

        return response;
    }

    /*
     * delete product
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseREST> delete(@PathVariable Long id) {

        ResponseEntity<ProductResponseREST> response =
                service.deleteById(id);

        return response;
    }

}

