package br.com.faez.buzzview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faez.buzzview.entity.Cliente;
import br.com.faez.buzzview.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if (obj == null) {
		 throw new br.com.faez.buzzview.services.exception.ObjectNotFoundException("Objeto não encontrado! Id: " + id
		+ ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

}
