package ru.netology.poster;

public class PosterManager {
    private Movie[] movies = new Movie[0];
    private int recentMoviesLimit = 10;

    public PosterManager() {}

    public PosterManager(int recentMoviesLimit) {
        if (recentMoviesLimit > 0) {
            this.recentMoviesLimit = recentMoviesLimit;
        }
    }

    public int getRecentMoviesLimit() {
        return this.recentMoviesLimit;
    }

    public Movie[] getMovies() {
        return this.movies;
    }

    public void addMovieToPoster(Movie movie) {
        Movie[] newMovies = new Movie[movies.length + 1];

        System.arraycopy(this.movies, 0, newMovies, 0, movies.length);

        newMovies[newMovies.length - 1] = movie;

        this.movies = newMovies;
    }

    public Movie[] getRecentMovies() {
        Movie[] recentMovies = null;

        if (this.recentMoviesLimit <= this.movies.length) {
            recentMovies = new Movie[this.recentMoviesLimit];
        } else {
            recentMovies = new Movie[this.movies.length];
        }

        for (int i = 0; i < recentMovies.length; i++) {
            recentMovies[i] = this.movies[this.movies.length - 1 - i];
        }

        return recentMovies;
    }
}
