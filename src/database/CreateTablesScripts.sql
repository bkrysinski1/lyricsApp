CREATE TABLE artist (artist_id SERIAL NOT NULL, artist_name CHARACTER VARYING(100), PRIMARY KEY (artist_id));
CREATE TABLE song (song_id SERIAL NOT NULL, artist_id INTEGER, title CHARACTER VARYING(100), genre CHARACTER VARYING(50), year_released INTEGER, difficulty_level INTEGER, PRIMARY KEY (song_id));
CREATE TABLE lyrics (lyric_id SERIAL NOT NULL, song_id INTEGER, lyrics CHARACTER VARYING(300), year_released INTEGER, difficulty_level INTEGER, PRIMARY KEY (lyric_id));
