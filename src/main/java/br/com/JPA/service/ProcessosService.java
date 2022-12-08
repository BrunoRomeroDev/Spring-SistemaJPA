package br.com.JPA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.JPA.Model.ProcessoModel;
import br.com.JPA.entity.ProcessosEntity;
import br.com.JPA.repository.ProcessosRepository;

@Service
public class ProcessosService {

	@Autowired
	private ProcessosRepository processosrepository;
	
	@Autowired
	private FuncionarioService funcionarioservice;
	
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
	
	public ProcessoModel convertProcesso(ProcessosEntity pe) {
		return new ProcessoModel(pe);
	}
	

	public List<ProcessoModel> convertlistProcesso(List<ProcessosEntity> lpe){
			List<ProcessoModel> listModel = new ArrayList<>();
			lpe.forEach(p ->  listModel.add(new ProcessoModel(p,funcionarioservice.convertModelId(p.getId_funcionario_tramitacao())))) ;
		return listModel;
		
	}
}
