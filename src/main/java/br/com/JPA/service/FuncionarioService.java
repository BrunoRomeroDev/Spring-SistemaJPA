package br.com.JPA.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JPA.Exception.ExceptionExist;
import br.com.JPA.entity.FuncionarioEntity;
import br.com.JPA.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionariorepository;

	public Optional<FuncionarioEntity> deleteid(Integer id) {
		Optional<FuncionarioEntity> fe = funcionariorepository.findById(id);
		
		if(fe.isPresent()) {
			funcionariorepository.deleteById(id);
		}else {
			throw new NullPointerException();
		}
		return fe;
	}
	
	public Optional<FuncionarioEntity> alteraid(FuncionarioEntity fe) {
		Optional<FuncionarioEntity> feoptional = funcionariorepository.findById(fe.getId());
		
		if(feoptional.isPresent()) {
			funcionariorepository.save(feoptional.get());
		}else {
			throw new NullPointerException();
		}
		return feoptional;
	}
	
	public FuncionarioEntity novofunc(FuncionarioEntity fe) throws ExceptionExist {
		Optional<FuncionarioEntity> feoptional = funcionariorepository.findByNomeCompleto(fe.getNomeCompleto());
		
		if(!feoptional.isPresent()) {
			funcionariorepository.save(fe);
		}else {
			throw new ExceptionExist();
		}
		return fe;
	}
}
