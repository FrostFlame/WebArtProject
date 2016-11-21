package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

/**
 * Created by 1 on 02.11.2016.
 */
public class Battle_genre {
    private long id;
    private long battles_id;
    private long genres_id;
    private Battle battle;
    private Genre genre;

    public Battle_genre(long id, long battles_id, long genres_id) {
        this.id = id;
        this.battles_id = battles_id;
        this.genres_id = genres_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBattles_id() {
        return battles_id;
    }

    public void setBattles_id(long battles_id) {
        this.battles_id = battles_id;
    }

    public long getGenres_id() {
        return genres_id;
    }

    public void setGenres_id(long genres_id) {
        this.genres_id = genres_id;
    }
}
