package br.com.faez.buzzview;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.faez.buzzview.entity.Categoria;
import br.com.faez.buzzview.entity.Cidade;
import br.com.faez.buzzview.entity.Estado;
import br.com.faez.buzzview.entity.Produto;
import br.com.faez.buzzview.repositories.CategoriaRepository;
import br.com.faez.buzzview.repositories.CidadeRepository;
import br.com.faez.buzzview.repositories.EstadoRepository;
import br.com.faez.buzzview.repositories.ProdutoRepository;

@SpringBootApplication
public class BuzzviewApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BuzzviewApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Categoria cat1 = new Categoria(null, "Ração");
		Categoria cat2 = new Categoria(null, "Brinquedo Pet");

		Produto p1 = new Produto(null, "Ração Golden Special Sabor Frango e Carne para Cães Adultos 15Kg", 104.90);
		Produto p2 = new Produto(null, "Ração Golden Special Sabor Frango e Carne para Cães Adultos 20Kg", 138.90);
		Produto p3 = new Produto(null, "Brinquedo Chalesco Para Cães Bola Multicor", 18.90);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));

		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));

		Estado uf1 = new Estado(null, "Rio de Janeiro");

		Cidade cid1 = new Cidade(null, "Rio de Janeiro", uf1);
		Cidade cid2 = new Cidade(null, "Niterói", uf1);

		uf1.getCidades().addAll(Arrays.asList(cid1, cid2));
		
		estadoRepository.save(Arrays.asList(uf1));
		cidadeRepository.save(Arrays.asList(cid1, cid2));
	}

}
