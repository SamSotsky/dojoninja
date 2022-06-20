package com.sam.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.dojoninja.models.Dojo;
import com.sam.dojoninja.repos.DojoRepo;


@Service
public class DojoServ {
	@Autowired
	private DojoRepo dojoRepo;
	
	
	 // returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }
    
    // creates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepo.save(b);
    }
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
 // UPDATE a dojo
    public Dojo updateDojo(Dojo b) {
        return dojoRepo.save(b);
    }
    
//    Deletes a dojo
    public void deleteDojo(Long id) {
    	dojoRepo.deleteById(id);
    }
}
