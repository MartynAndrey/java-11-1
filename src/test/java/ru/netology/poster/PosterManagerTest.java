package ru.netology.poster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {
    Movie m1 = new Movie(1, "first", "horror", "url1", "img1");
    Movie m2 = new Movie(2, "second", "comedy", "url2", "img2");
    Movie m3 = new Movie(3, "third", "drama", "url3", "img3");
    Movie m4 = new Movie(4, "forth", "horror", "url4", "img4");
    Movie m5 = new Movie(5, "fifth", "comedy", "url5", "img5");
    Movie m6 = new Movie(6, "sixth", "drama", "url6", "img6");
    Movie m7 = new Movie(7, "seventh", "horror", "url7", "img7");
    Movie m8 = new Movie(8, "eighth", "comedy", "url8", "img8");
    Movie m9 = new Movie(9, "ninth", "drama", "url9", "img9");
    Movie m10 = new Movie(10, "tenth", "horror", "url10", "img10");

    @Test
    void shouldCreateDefaultPoster() {
        PosterManager poster = new PosterManager();

        int expected = 10;
        int actual = poster.getRecentMoviesLimit();
        assertEquals(actual, expected);
    }

    @Test
    void shouldCreateValidParameterPoster() {
        PosterManager poster = new PosterManager(7);

        int expected = 7;
        int actual = poster.getRecentMoviesLimit();
        assertEquals(actual, expected);
    }

    @Test
    void shouldCreateInvalidParameterPoster() {
        PosterManager poster = new PosterManager(-2);

        int expected = 10;
        int actual = poster.getRecentMoviesLimit();
        assertEquals(actual, expected);
    }

    @Test
    void shouldAddMovieToDefaultPoster() {
        PosterManager poster = new PosterManager();
        poster.addMovieToPoster(m1);
        poster.addMovieToPoster(m2);
        poster.addMovieToPoster(m3);
        poster.addMovieToPoster(m4);

        Movie[] expected = {m1, m2, m3, m4};
        Movie[] actual = poster.getMovies();
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldAddMovieToParametrizedPoster() {
        PosterManager poster = new PosterManager(3);
        poster.addMovieToPoster(m5);
        poster.addMovieToPoster(m6);
        poster.addMovieToPoster(m7);
        poster.addMovieToPoster(m8);

        Movie[] expected = {m5, m6, m7, m8};
        Movie[] actual = poster.getMovies();
        assertArrayEquals(actual, expected);
    }

    @Test
    void getRecentMoviesThenLengthMoreLimit() {
        PosterManager poster = new PosterManager(5);
        poster.addMovieToPoster(m1);
        poster.addMovieToPoster(m2);
        poster.addMovieToPoster(m3);
        poster.addMovieToPoster(m4);
        poster.addMovieToPoster(m5);
        poster.addMovieToPoster(m6);
        poster.addMovieToPoster(m7);

        Movie[] expected = {m7, m6, m5, m4, m3};
        Movie[] actual = poster.getRecentMovies();
        assertArrayEquals(actual, expected);
    }

    @Test
    void getRecentMoviesThenLengthLessLimit() {
        PosterManager poster = new PosterManager(6);
        poster.addMovieToPoster(m1);
        poster.addMovieToPoster(m2);
        poster.addMovieToPoster(m3);
        poster.addMovieToPoster(m4);

        Movie[] expected = {m4, m3, m2, m1};
        Movie[] actual = poster.getRecentMovies();
        assertArrayEquals(actual, expected);
    }

    @Test
    void getRecentMoviesThenLengthEqualLimit() {
        PosterManager poster = new PosterManager();
        poster.addMovieToPoster(m1);
        poster.addMovieToPoster(m2);
        poster.addMovieToPoster(m3);
        poster.addMovieToPoster(m4);
        poster.addMovieToPoster(m5);
        poster.addMovieToPoster(m6);
        poster.addMovieToPoster(m7);
        poster.addMovieToPoster(m8);
        poster.addMovieToPoster(m9);
        poster.addMovieToPoster(m10);

        Movie[] expected = {m10, m9, m8, m7, m6, m5, m4, m3, m2, m1};
        Movie[] actual = poster.getRecentMovies();
        assertArrayEquals(actual, expected);
    }

    @Test
    void getRecentMoviesThenLengthEqualZero() {
        PosterManager poster = new PosterManager(3);

        Movie[] expected = new Movie[0];
        Movie[] actual = poster.getRecentMovies();
        assertArrayEquals(actual, expected);
    }
}