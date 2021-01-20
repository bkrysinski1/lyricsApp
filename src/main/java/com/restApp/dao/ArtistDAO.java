package com.restApp.dao;

import java.util.List;

import com.restApp.model.Artist;

public interface ArtistDAO {
	List<Artist> findAll();
	Artist getArtistById (long artistId);
}
