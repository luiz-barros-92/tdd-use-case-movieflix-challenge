package com.devsuperior.movieflix.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {

	private final GenreRepository repository;
		
	public GenreService(GenreRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public List<GenreDTO> findAll(){
		List<Genre> list = repository.findAll();
		return list.stream().map(GenreDTO::new).toList();
	}
}
