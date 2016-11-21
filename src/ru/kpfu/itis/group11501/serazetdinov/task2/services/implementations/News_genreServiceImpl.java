package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.GenreDAOImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.News_genreDAOImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.GenreDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.News_genreDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.News_genreService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 20.11.2016.
 */
public class News_genreServiceImpl implements News_genreService {
    News_genreDAO news_genreDAO = new News_genreDAOImpl();
    GenreDAO genreDAO = new GenreDAOImpl();

    @Override
    public List<String> getGenresByNewsId(long l) {
        List<Long> ids = news_genreDAO.getGenresByNewsId(l);
        List<String>tags = new ArrayList<>();
        for (long id: ids){
            tags.add(genreDAO.getGenreById(id).getGenre());
        }
        return tags;
    }
}
