package com.restApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.dao.ArtistDAO;
import com.restApp.model.Artist;

@RestController 
public class ArtistController {
	private ArtistDAO artistDAO;
	
	public ArtistController(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}
	
	@RequestMapping(path = "/artist", method = RequestMethod.GET)
	public List<Artist> getArtist() {
		List<Artist> getArtist = artistDAO.findAll();
		return getArtist;
	}
	
	@RequestMapping(path = "/artist/{id}", method = RequestMethod.GET)
	public Artist getArtistById(@PathVariable("id")long artistId) {
		Artist getArtistById = artistDAO.getArtistById(artistId);
		return getArtistById;
	}
}
