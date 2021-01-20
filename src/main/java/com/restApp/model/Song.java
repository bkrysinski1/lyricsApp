package com.restApp.model;

public class Song {
	private Long song_id;
	private Long artist_id;
	private String title;
	private String genre;
	private int year_released;
	private int difficulty_level;
	
	public Long getSong_id() {
		return song_id;
	}
	public void setSong_id(Long song_id) {
		this.song_id = song_id;
	}
	public Long getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(Long artist_id) {
		this.artist_id = artist_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
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
