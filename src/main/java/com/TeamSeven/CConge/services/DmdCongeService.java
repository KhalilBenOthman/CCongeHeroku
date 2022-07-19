package com.TeamSeven.CConge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeamSeven.CConge.domain.Conges;
import com.TeamSeven.CConge.domain.DmdConge;
import com.TeamSeven.CConge.domain.UserDmdConges;
import com.TeamSeven.CConge.exceptions.TA_CongesNotFoundException;
import com.TeamSeven.CConge.repositories.CongesRepository;
import com.TeamSeven.CConge.repositories.DmdCongeRepository;
import com.TeamSeven.CConge.repositories.UserDmdCongesRepository;
import com.TeamSeven.CConge.repositories.UserRepository;

@Service
public class DmdCongeService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserDmdCongesRepository userDmdCongesRepository;
	@Autowired
	private CongesRepository congesRepository ;
	@Autowired
	private DmdCongeRepository dmdCongesRepository;
	
	
	public DmdConge addDemandeConge(DmdConge dmdConge, String username) {
		try {
			UserDmdConges userDmdConges = userDmdCongesRepository.findByuserName(username);
			Conges conge = congesRepository.findBycode(dmdConge.getCongesCode());
			dmdConge.setUserDmdConges(userDmdConges);
			dmdConge.setUsername(username);
			return dmdCongesRepository.save(dmdConge);
		} catch (Exception e) {
			throw new TA_CongesNotFoundException("Erreur lors de la creation .");
		}
		
	}
	
	public Iterable<DmdConge> findAllDmdConge(String username){
		return dmdCongesRepository.findAllByusername(username);
	}
	
	
	
	
	
}
