package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

/**
 * Created by 1 on 02.11.2016.
 */
public class Favourite_Genre {
    private long id;
    private long user_id;
    private long genres_id;
    private User user;
    private Genre genre;

    public Favourite_Genre(long id, long user_id, long genres_id) {
        this.id = id;
        this.user_id = user_id;
        this.genres_id = genres_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getGenres_id() {
        return genres_id;
    }

    public void setGenres_id(long genre_id) {
        this.genres_id = genre_id;
    }
}
