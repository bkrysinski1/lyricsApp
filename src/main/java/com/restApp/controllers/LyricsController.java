package com.restApp.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.dao.LyricsDAO;
import com.restApp.model.Lyrics;

@CrossOrigin
@RestController
public class LyricsController {

	private LyricsDAO lyricsDAO;

	public LyricsController(LyricsDAO lyricsDAO) {
		this.lyricsDAO = lyricsDAO;
	}

	@RequestMapping(path = "/lyrics", method = RequestMethod.GET)
	public List<Lyrics> getLyrics() {
		List<Lyrics> getLyrics = lyricsDAO.findAll();
		return getLyrics;
	}

	@RequestMapping(path = "/lyrics/{id}", method = RequestMethod.GET)
	public Lyrics getLyricById(@PathVariable("id") long lyricId) {
		Lyrics getLyricById = lyricsDAO.getLyricById(lyricId);
		return getLyricById;
	}

	@RequestMapping(path = "/lyrics/random", method = RequestMethod.GET)
	public Lyrics getRandomLyric(@RequestParam(required = false) Integer difficultyLevel) {
		Random lyricGenerator = new Random();
		long RandomId = 0;
		if (difficultyLevel == null) {
			int countLyrics = lyricsDAO.findAll().size();
			RandomId = lyricGenerator.nextInt((countLyrics) + 1);
			while (RandomId == 0) {
				RandomId = lyricGenerator.nextInt((countLyrics) + 1);
			}
			Lyrics getRandomLyric = lyricsDAO.getLyricById(RandomId);
				return getRandomLyric;
				
		} else { 
			List<Lyrics> lyricsByDifficultyLevel = lyricsDAO.getLyricByDifficultyLevel(difficultyLevel);
			int countLyrics = lyricsByDifficultyLevel.size();
			RandomId = lyricGenerator.nextInt((countLyrics));
			return lyricsByDifficultyLevel.get((int) RandomId);
		}
	}
}
