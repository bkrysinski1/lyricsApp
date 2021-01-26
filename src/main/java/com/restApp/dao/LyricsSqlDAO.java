package com.restApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.restApp.model.Lyrics;


@Component 
public class LyricsSqlDAO implements LyricsDAO {

	private JdbcTemplate jdbcTemplate;

    public LyricsSqlDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<Lyrics> findAll() {
		List<Lyrics> lyrics = new ArrayList<>();
		String sql = "SELECT * FROM lyrics";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Lyrics lyric = mapRowToLyrics(results);
			lyrics.add(lyric);
		}
		return lyrics;
	}
	
	@Override
	public Lyrics getLyricById(long lyricId) {
		String sql = "SELECT * FROM lyrics WHERE lyric_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lyricId);
		if(results.next()) {
			return mapRowToLyrics(results);
		} else {
			throw new RuntimeException("lyricId " + lyricId + "was not found.");
		}
	}

	private Lyrics mapRowToLyrics(SqlRowSet rs) {
		Lyrics lyrics = new Lyrics();
		lyrics.setLyric_id(rs.getLong("lyric_id"));
		lyrics.setSong_id(rs.getLong("song_id"));
		lyrics.setLyric(rs.getString("lyrics"));
		lyrics.setYear_released(rs.getInt("year_released"));
		lyrics.setDifficulty_level(rs.getInt("difficulty_level"));
		return lyrics;
	}
}
