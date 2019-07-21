package br.com.faez.buzzview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faez.buzzview.entity.Pedido;
import br.com.faez.buzzview.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Pedido obj = repo.findOne(id);
		if (obj == null) {
		 throw new br.com.faez.buzzview.services.exception.ObjectNotFoundException("Objeto não encontrado! Id: " + id
		+ ", Tipo: " + Pedido.class.getName());
		}
		return obj;
	}

}
