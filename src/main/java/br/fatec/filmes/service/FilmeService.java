package br.fatec.filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.filmes.model.Filme;
import br.fatec.filmes.repository.FilmeRepository;

@Service
public class FilmeService implements ServiceInterface<Filme> {

	@Autowired
	private FilmeRepository repo;
	
	@Override
	public Filme create(Filme obj) {
		repo.save(obj);
		return obj;
	}

	@Override
	public Filme findById(Long id) {
		Optional<Filme> _filme = repo.findById(id);		
		return _filme.orElse(null);
	}

	@Override
	public List<Filme> findAll() {
		return repo.findAll();
	}

	@Override
	public boolean update(Filme obj) {
		if (repo.existsById(obj.getId())) {
			repo.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Filme> findOrdenadoPorAno() {
		return repo.findOrdenadoPorAno();
	}
	
	public List<Filme> findByAtor(Long atorId) {
		return repo.findByAtor(atorId);
	}
	
	public List<Filme> findByAno(Integer ano) {
		return repo.findByAno(ano);
	}
	
	public Long findNumeroDeFilmesPorPeriodo(Integer from, Integer to) {
		return repo.findNumeroDeFilmesPorPeriodo(from, to);
	}
}
