package com.proyecto.franquicias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.franquicias.model.branch;
import com.proyecto.franquicias.repository.BranchRepository;
import com.proyecto.franquicias.response.BranchResponseREST;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository repository;

    @Override
    public ResponseEntity<BranchResponseREST> search() {

        BranchResponseREST response = new BranchResponseREST();

        List<branch> list = repository.findAll();

        response.setResponse(list);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BranchResponseREST> searchById(Long id) {

        BranchResponseREST response = new BranchResponseREST();

        Optional<branch> branch = repository.findById(id);

        response.setResponse(branch);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BranchResponseREST> save(branch branch) {

        BranchResponseREST response = new BranchResponseREST();

        branch branchSaved = repository.save(branch);

        response.setResponse(branchSaved);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BranchResponseREST> update(branch branch, Long id) {

        BranchResponseREST response = new BranchResponseREST();

        Optional<branch> currentBranch = repository.findById(id);

        if(currentBranch.isPresent()) {

            currentBranch.get().setName(branch.getName());

            currentBranch.get().setFranchiseId(branch.getFranchiseId());

            repository.save(currentBranch.get());

            response.setResponse(currentBranch.get());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<BranchResponseREST> deleteById(Long id) {

        BranchResponseREST response = new BranchResponseREST();

        repository.deleteById(id);

        response.setResponse("Deleted successfully");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}



