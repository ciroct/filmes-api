package br.fatec.filmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.fatec.filmes.model.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {
	
	@Query("select a from Ator a order by a.nome")
	List<Ator> findByOrderByNome();
	
	@Query("select a from Filme f join f.atores a where f.id=?1 order by a.nome")
	List<Ator> findByFilme(Long filmeId);
	
	@Query("select a from Ator a where a.nacionalidade.id=?1")
	List<Ator> findByNacionalidade(Long nacionalidadeId);

	@Query("select count(a) from Ator a where a.nacionalidade.id=?1")
	Long findNumeroDeAtoresPorNacionalidade(Long nacionalidadeId);

}
