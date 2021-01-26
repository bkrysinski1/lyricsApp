package com.restApp.dao;

import java.util.List;

import com.restApp.model.Song;

public interface SongDAO {
	List<Song> findAll();
	Song getSongById(long songId);
}
