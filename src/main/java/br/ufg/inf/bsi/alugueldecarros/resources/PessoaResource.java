package br.ufg.inf.bsi.alugueldecarros.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufg.inf.bsi.alugueldecarros.domain.Pessoa;
import br.ufg.inf.bsi.alugueldecarros.dto.PessoaDTO;
import br.ufg.inf.bsi.alugueldecarros.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
@CrossOrigin(origins = "http://localhost:8100")  // Adicione esta linha para permitir requisições CORS
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Pessoa obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Pessoa obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Pessoa obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<Pessoa> list = service.findAll();
		List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PessoaDTO>> findPage(
			@RequestParam(value="page", defaultValue = "0")Integer page,
			@RequestParam(value="size", defaultValue = "24")Integer size,
			@RequestParam(value="orderBy", defaultValue = "nome")String orderBy,
			@RequestParam(value="direction", defaultValue = "ASC")String direction){
		Page<Pessoa> list = service.findPage(page, size, orderBy, direction);
		Page<PessoaDTO> listDTO = list.map(obj -> new PessoaDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
}
