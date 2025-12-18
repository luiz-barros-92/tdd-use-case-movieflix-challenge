package com.devsuperior.movieflix.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	private final MovieService service;
		
    public MovieController(MovieService service) {
		this.service = service;
	}

    @PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
	@GetMapping("/{id}")
	public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));		
	}
}
