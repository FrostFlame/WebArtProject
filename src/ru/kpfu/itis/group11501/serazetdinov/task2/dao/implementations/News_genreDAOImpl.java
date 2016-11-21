package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.News_genreDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 16.11.2016.
 */
public class News_genreDAOImpl implements News_genreDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public void createRelation(long news_id, long genre_id) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into news_genres(news_id, genres_id)values(?, ?)");
            st.setLong(1, news_id);
            st.setLong(2, genre_id);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Long> getGenresByNewsId(long l) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from news_genres where news_id = ?");
            st.setLong(1, l);
            ResultSet rs = st.executeQuery();
            List<Long> tags = new ArrayList<>();
            while (rs.next()){
                tags.add(rs.getLong("genres_id"));
            }
            return tags;
        } catch (SQLException e) {
            return null;
        }
    }
}
