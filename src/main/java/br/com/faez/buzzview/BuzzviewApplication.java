package br.com.faez.buzzview;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.faez.buzzview.entity.Categoria;
import br.com.faez.buzzview.repositories.CategoriaRepository;

@SpringBootApplication
public class BuzzviewApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(BuzzviewApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		Categoria cat1 = new Categoria(null, "Ração");
		Categoria cat2 = new Categoria(null, "Brinquedo Pet");
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		
	}

}
