package br.fatec.filmes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.fatec.filmes.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	@Query("select f from Filme f order by f.ano")
	List<Filme> findOrdenadoPorAno();
	
	@Query("select f from Filme f join f.atores a where a.id=?1")
	List<Filme> findByAtor(Long atorId);
	
	@Query("select f from Filme f where f.ano=?1")
	List<Filme> findByAno(Integer ano);
	
	@Query("select count(f) from Filme f where f.ano between ?1 and ?2")
	Long findNumeroDeFilmesPorPeriodo(Integer from, Integer to);
}
