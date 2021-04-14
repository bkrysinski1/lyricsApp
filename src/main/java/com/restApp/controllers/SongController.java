package com.restApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.dao.SongDAO;
import com.restApp.model.Song;

@CrossOrigin
@RestController
public class SongController {
	
	private SongDAO songDAO;
	
	public SongController(SongDAO songDAO) {
		this.songDAO = songDAO;
	}
	
	@RequestMapping(path = "/song", method = RequestMethod.GET)
	public List<Song> getSong() {
		List<Song> getSong = songDAO.findAll();
		return getSong;
	}
	
	@RequestMapping(path = "/song/{id}", method = RequestMethod.GET)
	public Song getSongById(@PathVariable("id")long songId) {
		Song getSongById = songDAO.getSongById(songId);
		return getSongById;
	}
}
