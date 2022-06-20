package com.sam.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.dojoninja.models.Ninja;
import com.sam.dojoninja.repos.NinjaRepo;


@Service
public class NinjaServ {
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
	
	 // returns all the ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepo.findAll();
    }
    
    // creates a ninja
    public Ninja createNinja(Ninja b) {
        return ninjaRepo.save(b);
    }
    // retrieves a ninja
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
 // UPDATE a ninja
    public Ninja updateNinja(Ninja b) {
        return ninjaRepo.save(b);
    }
    
//    Deletes a ninja
    public void deleteNinja(Long id) {
    	ninjaRepo.deleteById(id);
    }
}
