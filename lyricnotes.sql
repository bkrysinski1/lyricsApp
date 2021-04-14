
INSERT INTO song (artist_id, title, genre, year_released, difficulty_level)
VALUES (15, 'Bluebird', 'Country', 2019, 3);

INSERT INTO lyrics (song_id, lyrics, year_released, difficulty_level)
VALUES (20, 'And if the house just keeps on winning\nI got a wildcard up my sleeve\nAnd if love keeps giving me lemons\nI''ll just mix ''em in my drink', 2019, 3);
/*
INSERT INTO artist (artist_name)
VALUES ('Dan + Shay');

INSERT INTO artist (artist_name)
VALUES ('Blake Shelton');

INSERT INTO artist (artist_name)
VALUES ('Miranda Lambert');
*/
/*
SELECT title, artist_name
FROM song
JOIN artist 
ON artist.artist_id = song.artist_id;

SELECT lyrics, title
FROM lyrics
JOIN song
ON song.song_id = lyrics.song_id;

SELECT lyrics.lyrics, song.title, artist.artist_name, song.year_released
FROM lyrics 
JOIN song
ON lyrics.song_id = song.song_id
JOIN artist
ON song.artist_id = artist.artist_id
ORDER BY song.year_released;

SELECT lyrics
FROM lyrics
JOIN song
ON lyrics.song_id = song.song_id
JOIN artist
ON song.artist_id = artist.artist_id
WHERE artist_name = 'Dave Matthews Band';

SELECT song.title, COUNT(lyrics)
FROM lyrics
JOIN song
ON lyrics.song_id = song.song_id
GROUP BY song.title;

SELECT COUNT(artist_id)
FROM artist;
SELECT COUNT(title)
FROM song;

SELECT AVG(artist_id)
FROM artist
GROUP BY artist_id;
SELECT AVG(CNT) FROM(
SELECT COUNT(artist_id) AS CNT, artist_id
FROM song
GROUP BY artist_id) artist_count;
*/