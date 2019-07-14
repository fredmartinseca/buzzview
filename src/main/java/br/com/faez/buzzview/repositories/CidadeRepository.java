package br.com.faez.buzzview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.faez.buzzview.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
