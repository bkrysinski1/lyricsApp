package com.restApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.restApp.model.Song;

@Component
public class SongSqlDAO implements SongDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public SongSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Song> findAll() {
		List<Song> songs = new ArrayList<>();
		String sql = "SELECT * FROM song";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Song song = mapRowToSong(results);
			songs.add(song);
		}
		return songs;
	}
	
	@Override
	public Song getSongById(long songId) {
		String sql = "SELECT * FROM song WHERE song_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, songId);
		if(results.next()) {
			return mapRowToSong(results);
		} else {
			throw new RuntimeException("songId " + songId + "was not found.");
		}
	}
	
	private Song mapRowToSong(SqlRowSet rs) {
		Song song = new Song();
		song.setSong_id(rs.getLong("song_id"));
		song.setArtist_id(rs.getLong("artist_id"));
		song.setTitle(rs.getString("title"));
		song.setGenre(rs.getString("genre"));
		song.setYear_released(rs.getInt("year_released"));
		song.setDifficulty_level(rs.getInt("difficulty_level"));
		return song;
	}
}
