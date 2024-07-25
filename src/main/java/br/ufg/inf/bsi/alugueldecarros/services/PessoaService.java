package br.ufg.inf.bsi.alugueldecarros.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import br.ufg.inf.bsi.alugueldecarros.domain.Pessoa;
import br.ufg.inf.bsi.alugueldecarros.repositories.PessoaRepository;
import br.ufg.inf.bsi.alugueldecarros.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public Pessoa buscar(Integer id) {
		Optional<Pessoa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id: "+ id +", Usuario: "
				+ Pessoa.class.getName()));
	}
	
	public Pessoa insert(Pessoa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Pessoa update(Pessoa obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			buscar(id);
			repo.deleteById(id);	
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos.");
		}		
	}

	public List<Pessoa> findAll() {		
		return repo.findAll();
	}
	
	public Page<Pessoa> findPage(Integer page, Integer size, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
}
	