package com.restApp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.dao.LyricsDAO;
import com.restApp.model.Lyrics;

@RestController
public class LyricsController {
	
	private LyricsDAO lyricsDAO;	
	
	public LyricsController(LyricsDAO lyricsDAO) {
		this.lyricsDAO = lyricsDAO;
	}
	
	@RequestMapping(path = "/lyrics", method = RequestMethod.GET)
	public List<Lyrics> getLyrics() {
		List<Lyrics> getLyrics = lyricsDAO.findAll();
//		List<Lyrics> lyrics = new ArrayList();
		
//		Lyrics lyric = new Lyrics(); // replace lines with a DAO
//		lyric.setLyric("myLyricTest");
//		lyrics.add(lyric);
		
		return getLyrics;
	}
}
