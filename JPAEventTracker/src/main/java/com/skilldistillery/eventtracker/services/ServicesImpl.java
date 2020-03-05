package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Prospects;

@Service
public class ServicesImpl implements EventServices {

	@Autowired
	private ProspectRepository prospectRepo;

	@Override
	public List<Prospects> getAll() {
		
		return prospectRepo.findAll();
	}

	@Override
	public Prospects create(Prospects prospect) {
		prospectRepo.saveAndFlush(prospect);
		return prospect;
	}

	@Override
	public boolean delete(Integer pid) {
		Prospects prospect = null;
		Optional <Prospects> prospectOpt = prospectRepo.findById(pid);
		if(prospectOpt.isPresent()) {
			prospect = prospectOpt.get();
			prospectRepo.delete(prospect);
			return true;
		}
		
		return false;
	}

	@Override
	public Prospects update(Integer pid, Prospects newProspect) {
		Optional <Prospects> prospectOpt = prospectRepo.findById(pid);
		Prospects prospectToUpdate = null;
		if(prospectOpt.isPresent()) {
			prospectToUpdate = prospectOpt.get();
			newProspect.setId(prospectToUpdate.getId());
			prospectToUpdate = newProspect;
			prospectRepo.saveAndFlush(prospectToUpdate);
		}else {
			return null;
		}
		
		return prospectToUpdate;
	}

	@Override
	public Prospects create(Prospects prospect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prospects update(Integer id, Prospects prospect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prospects create(Prospects prospect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prospects update(Integer id, Prospects prospect) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	
	
	
	
	
	
	