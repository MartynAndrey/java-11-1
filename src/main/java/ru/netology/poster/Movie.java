package ru.netology.poster;

public class Movie {
    private int id;
    private String name;
    private String kind;
    private String url;
    private String image;

    public Movie(int id, String name, String kind, String url, String image) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.url = url;
        this.image = image;
    }
}
