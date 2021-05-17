package br.fatec.filmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.fatec.filmes.model.Nacionalidade;

@Repository
public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Long> {
	
	@Query("select n from Nacionalidade n order by n.pais")
	List<Nacionalidade> findByOrderByPais();
	
	@Query("select n from Nacionalidade n where n.pais like ?1%")
	List<Nacionalidade> findByPrimeiraLetra(Character letra);

}
