package com.restApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.restApp.model.Artist;

@Component
public class ArtistSqlDAO implements ArtistDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ArtistSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Artist> findAll() {
		List<Artist> artists = new ArrayList<>();
		String sql = "SELECT * FROM artist";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Artist artist = mapRowToArtist(results);
			artists.add(artist);
		}
		return artists;
	}
	
	@Override
	public Artist getArtistById(long artistId) {
		String sql = "SELECT * FROM artist WHERE artist_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, artistId);
		if(results.next()) {
			return mapRowToArtist(results);
		} else {
			throw new RuntimeException("artistId " + artistId + "was not found.");
		}
	}
	
	private Artist mapRowToArtist(SqlRowSet rs) {
		Artist artist = new Artist();
		artist.setArtist_id(rs.getLong("artist_id"));
		artist.setArtist_name(rs.getString("artist_name"));
		return artist;
	}
}
