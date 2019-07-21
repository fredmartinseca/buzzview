package br.com.faez.buzzview;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.faez.buzzview.entity.Categoria;
import br.com.faez.buzzview.entity.Cidade;
import br.com.faez.buzzview.entity.Cliente;
import br.com.faez.buzzview.entity.Endereco;
import br.com.faez.buzzview.entity.Estado;
import br.com.faez.buzzview.entity.Produto;
import br.com.faez.buzzview.entity.enums.TipoCliente;
import br.com.faez.buzzview.repositories.CategoriaRepository;
import br.com.faez.buzzview.repositories.CidadeRepository;
import br.com.faez.buzzview.repositories.ClienteRepository;
import br.com.faez.buzzview.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

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
		
		Cliente cli1 = new Cliente(null, "Frederico Martins", "fred@gmail.com", "11122255585", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("21997404755","21123456789"));
		
		Endereco e1 = new Endereco(null, "Rua Marica", "49", "casa 3", "Pé Pequeno", "24240110", cli1, cid2);
		Endereco e2 = new Endereco(null, "Rua Coelho", "100", "apto 201", "Vista Alegre", "21250140", cli1, cid1);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1, e2));
	}

}
