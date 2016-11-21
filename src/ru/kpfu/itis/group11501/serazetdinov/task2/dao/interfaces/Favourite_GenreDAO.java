package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import java.util.List;

/**
 * Created by 1 on 03.11.2016.
 */
public interface Favourite_GenreDAO {
    void createFavouriteGenre(long id, long id1);

    List<Long> getGenresByUserId(long id);
}
