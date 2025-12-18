package com.devsuperior.movieflix.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	private final MovieRepository repository;
		
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public MovieDetailsDTO findById(Long id) {
		return repository.findById(id).map(MovieDetailsDTO::new)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
	}
}
