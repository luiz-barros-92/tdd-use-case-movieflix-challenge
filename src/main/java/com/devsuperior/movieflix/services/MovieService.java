package com.devsuperior.movieflix.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieCardDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	private final MovieRepository movieRepository;
	private final GenreRepository genreRepository;
		
	public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
		this.movieRepository = movieRepository;
		this.genreRepository = genreRepository;
	}

	@Transactional(readOnly = true)
	public MovieDetailsDTO findById(Long id) {
		return movieRepository.findById(id).map(MovieDetailsDTO::new)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
	}
	
	@Transactional(readOnly = true)
	public Page<MovieCardDTO> findAllPaged(Long genreId, Pageable pageable) {	    
	    Pageable sortedByTitle = PageRequest.of(pageable.getPageNumber(), 
	                                            pageable.getPageSize(), 
	                                            Sort.by("title"));	    
	    Genre genre = (genreId == 0) ? null : genreRepository.getReferenceById(genreId);
	    Page<Movie> page = movieRepository.find(genre, sortedByTitle);
	    return page.map(x -> new MovieCardDTO(x));
	}	
}
