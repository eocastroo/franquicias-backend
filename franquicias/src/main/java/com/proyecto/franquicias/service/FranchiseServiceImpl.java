package com.proyecto.franquicias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.franquicias.model.Franchise;
import com.proyecto.franquicias.repository.FranchiseRepository;
import com.proyecto.franquicias.response.FranchiseResponseREST;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    @Autowired
    private FranchiseRepository repository;

    @Override
    public ResponseEntity<FranchiseResponseREST> search() {

        FranchiseResponseREST response = new FranchiseResponseREST();

        List<Franchise> list = repository.findAll();

        response.setResponse(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FranchiseResponseREST> searchById(Long id) {

        FranchiseResponseREST response = new FranchiseResponseREST();

        Optional<Franchise> franchise = repository.findById(id);

        response.setResponse(franchise);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FranchiseResponseREST> save(Franchise franchise) {

        FranchiseResponseREST response = new FranchiseResponseREST();

        Franchise franchiseSaved = repository.save(franchise);

        response.setResponse(franchiseSaved);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FranchiseResponseREST> update(Franchise franchise, Long id) {

        FranchiseResponseREST response = new FranchiseResponseREST();

        Optional<Franchise> currentFranchise = repository.findById(id);

        if(currentFranchise.isPresent()) {

            currentFranchise.get().setName(franchise.getName());

            repository.save(currentFranchise.get());

            response.setResponse(currentFranchise.get());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<FranchiseResponseREST> deleteById(Long id) {

        FranchiseResponseREST response = new FranchiseResponseREST();

        repository.deleteById(id);

        response.setResponse("Deleted successfully");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}