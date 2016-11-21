package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import java.util.List;

/**
 * Created by 1 on 16.11.2016.
 */
public interface News_genreDAO {
    void createRelation(long news_id, long genre_id);

    List<Long> getGenresByNewsId(long l);
}
