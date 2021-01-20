package com.restApp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.dao.SongDAO;
import com.restApp.model.Song;

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
}
