package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Genre;

/**
 * Created by 1 on 03.11.2016.
 */
public interface GenreDAO {
    Genre getGenreByName(String s);

    void createGenre(String s);

    Genre getGenreById(long id);
}
