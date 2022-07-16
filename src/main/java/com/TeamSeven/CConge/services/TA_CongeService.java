package com.TeamSeven.CConge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TeamSeven.CConge.domain.RelatCongeType;
import com.TeamSeven.CConge.domain.TA_Conges;
import com.TeamSeven.CConge.exceptions.TA_CongesCodeException;
import com.TeamSeven.CConge.repositories.RelatCongeTypeRepository;
import com.TeamSeven.CConge.repositories.TA_CongesRepository;


@Service
public class TA_CongeService {
	@Autowired
	private TA_CongesRepository ta_CongesRepository;
	@Autowired
	private RelatCongeTypeRepository relatCongeTypeRepository;
	
	
	public TA_Conges saveOrUpdateTaConges (TA_Conges ta_Conges) {
		try {
			if (ta_Conges.getId() == null) {
				RelatCongeType relatCongeType = new RelatCongeType();
				ta_Conges.setRelatCongeType(relatCongeType);
				relatCongeType.setTAConges(ta_Conges);
				relatCongeType.setTACongeCode(ta_Conges.getCode());
			}
			if (ta_Conges.getId() != null) {
				ta_Conges.setRelatCongeType(relatCongeTypeRepository.findByTACongeCode(ta_Conges.getCode()));
			}
			return ta_CongesRepository.save(ta_Conges);
		} catch (Exception e) {
			throw new TA_CongesCodeException("une famille de congé avec le code '"+ta_Conges.getCode()+"' déja existe.");
		}
		
	}
	
	public TA_Conges findByTACongeCode(String code) {
		TA_Conges ta_Conge = ta_CongesRepository.findBycode(code);
		if (ta_Conge == null) {
			throw new TA_CongesCodeException("404 : conges n'existe pas avec le code :"+code);
		}
		return ta_Conge;
	}
	
	public Iterable<TA_Conges> findAllTAConges(){
		return ta_CongesRepository.findAll();
	}
	
	public void deleteTACongeByCode(String code) {
		TA_Conges ta_Conge = ta_CongesRepository.findBycode(code);
		if(ta_Conge == null) {
			throw new TA_CongesCodeException("404 : conges n'existe pas avec le code :"+code);
		}
		ta_CongesRepository.delete(ta_Conge);
	}
	
} 
