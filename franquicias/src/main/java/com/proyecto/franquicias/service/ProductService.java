package com.proyecto.franquicias.service;

import org.springframework.http.ResponseEntity;

import com.proyecto.franquicias.model.Product;
import com.proyecto.franquicias.response.ProductResponseREST;

public interface ProductService {

    public ResponseEntity<ProductResponseREST> search();

    public ResponseEntity<ProductResponseREST> searchById(Long id);

    public ResponseEntity<ProductResponseREST> save(Product product);

    public ResponseEntity<ProductResponseREST> update(Product product, Long id);

    public ResponseEntity<ProductResponseREST> deleteById(Long id);

}



