package br.com.faez.buzzview.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	private Double preco;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	@OneToMany(mappedBy="id.produto")
	public Set<ItemPedido> itens = new HashSet<>();

	public Produto() {
	}

	public Produto(Integer id, String nome, Double preco) {
		Id = id;
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [Id=" + Id + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	public List<Pedido> getPedidos() {
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido x :itens) {
			lista.add(x.getPedido());
		}
		return lista;
	}
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Boolean isNome() {
		if (nome == null) {
			return false;
		} else if (nome.trim().length() < 2) {
			return false;
		} else {
			return true;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean isPreco() {
		if (preco == null) {
			return false;
		} else if (preco <= 0) {
			return false;
		} else {
			return true;
		}
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

}
