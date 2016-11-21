package ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces;

import java.util.List;

/**
 * Created by 1 on 20.11.2016.
 */
public interface News_genreService {
    List<String> getGenresByNewsId(long l);
}
