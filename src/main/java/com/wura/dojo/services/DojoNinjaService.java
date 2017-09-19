package com.wura.dojo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wura.dojo.models.Dojo;
import com.wura.dojo.models.Ninja;
import com.wura.dojo.repositories.DojoRepository;
import com.wura.dojo.repositories.NinjaRepository;

@Service
@Transactional
public class DojoNinjaService {
	private DojoRepository dojoRepo;
	@Autowired
	NinjaRepository ninjaRepo;
	private static final int pageSize = 5;
	
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public Page<Ninja> ninjaPerPage(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, pageSize, Sort.Direction.ASC, "firstName");
		return ninjaRepo.findAll(pageRequest);
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepo.save(dojo);
	}
	public List<Dojo> allDojos() {
		return (List<Dojo>) dojoRepo.findAll();
	}
	public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	public List<Ninja> allNinjas() {
		return (List<Ninja>) ninjaRepo.findAll();
	}
	public Dojo findDojo(Long id) {
		return dojoRepo.findOne(id);
	}
	public Ninja findNinja(Long id) {
		return ninjaRepo.findOne(id);
	}
	public void ninjaInDojo(Ninja ninja, Dojo dojo) {
		ninja.setDojo(dojo);
		ninjaRepo.save(ninja);	
	}
	public List<Object[]> joinAll() {
		return ninjaRepo.joinAll();
	}
}
