package br.com.JPA.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JPA.entity.ProcessosEntity;
import br.com.JPA.repository.ProcessosRepository;

@Service
public class ProcessosService {

	@Autowired
	private ProcessosRepository processosrepository;
	
	public ProcessosEntity deleteid(Integer id) {
		Optional<ProcessosEntity> check = processosrepository.findById(id);
		
		if(check.isPresent()) {
			processosrepository.deleteById(id);
		}else {
			throw new NullPointerException();
		}
		
		return check.get();
	}
	public ProcessosEntity atualizaid(Integer id,ProcessosEntity pe) {
		Optional<ProcessosEntity> check = processosrepository.findById(id);
		if(check.isPresent()) {
			processosrepository.save(pe);
		}else {
			throw new NullPointerException();
		}
		return pe;
	}
}
