package com.restApp.dao;

import java.util.List;

import com.restApp.model.Lyrics;

public interface LyricsDAO {
	List<Lyrics> findAll();
	Lyrics getLyricById(long lyricId);
}
