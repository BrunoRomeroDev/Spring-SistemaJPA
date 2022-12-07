package br.com.JPA.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JPA.entity.LocalEntity;
import br.com.JPA.repository.LocalRepository;

@Service
public class LocaisService {

	@Autowired
	private LocalRepository localrepository;
	
	public Optional<LocalEntity> deleteid(Integer id) {
		Optional<LocalEntity> ole = localrepository.findById(id);
		
		if(ole.isPresent()) {
			localrepository.deleteById(id);
		}else {
			throw new NullPointerException();
		}
		return ole;
	}
	
	public Optional<LocalEntity> alteraid(LocalEntity le){
		Optional<LocalEntity> local = localrepository.findById(le.getId());
		if( local.isPresent()) {
			localrepository.save(le);
		}else {
			throw new NullPointerException();
		}
		return local ;
	}
	
}
