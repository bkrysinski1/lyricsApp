package com.restApp.model;

public class Lyrics {
	private Long lyric_id;
	private Long song_id;
	private String lyric;
	private int year_released;
	private int difficulty_level;
	
	public Long getLyric_id() {
		return lyric_id;
	}
	public void setLyric_id(Long lyric_id) {
		this.lyric_id = lyric_id;
	}
	public Long getSong_id() {
		return song_id;
	}
	public void setSong_id(Long song_id) {
		this.song_id = song_id;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	public int getYear_released() {
		return year_released;
	}
	public void setYear_released(int year_released) {
		this.year_released = year_released;
	}
	public int getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(int difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
}
