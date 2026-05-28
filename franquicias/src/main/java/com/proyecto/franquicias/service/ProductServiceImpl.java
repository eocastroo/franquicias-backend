package com.proyecto.franquicias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.franquicias.model.Product;
import com.proyecto.franquicias.repository.ProductRepository;
import com.proyecto.franquicias.response.ProductResponseREST;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public ResponseEntity<ProductResponseREST> search() {

        ProductResponseREST response = new ProductResponseREST();

        List<Product> list = repository.findAll();

        response.setResponse(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponseREST> searchById(Long id) {

        ProductResponseREST response = new ProductResponseREST();

        Optional<Product> product = repository.findById(id);

        response.setResponse(product);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponseREST> save(Product product) {

        ProductResponseREST response = new ProductResponseREST();

        Product productSaved = repository.save(product);

        response.setResponse(productSaved);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponseREST> update(Product product, Long id) {

        ProductResponseREST response = new ProductResponseREST();

        Optional<Product> currentProduct = repository.findById(id);

        if(currentProduct.isPresent()) {

            currentProduct.get().setName(product.getName());

            currentProduct.get().setStock(product.getStock());

            currentProduct.get().setBranchId(product.getBranchId());

            repository.save(currentProduct.get());

            response.setResponse(currentProduct.get());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ProductResponseREST> deleteById(Long id) {

        ProductResponseREST response = new ProductResponseREST();

        repository.deleteById(id);

        response.setResponse("Deleted successfully");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<ProductResponseREST> topStock(Long branchId) {

        ProductResponseREST response = new ProductResponseREST();

        Optional<Product> product =
                repository.findTopByBranchIdOrderByStockDesc(branchId);

        response.setResponse(product);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}