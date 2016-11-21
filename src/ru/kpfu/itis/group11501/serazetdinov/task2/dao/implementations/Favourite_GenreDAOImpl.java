package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.Favourite_GenreDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 03.11.2016.
 */
public class Favourite_GenreDAOImpl implements Favourite_GenreDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public void createFavouriteGenre(long user_id, long genres_id) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into favourite_genres(user_id, genres_id)values(?, ?)");
            st.setLong(1, user_id);
            st.setLong(2, genres_id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Long> getGenresByUserId(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from favourite_genres where user_id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            List<Long> genres = new ArrayList<>();
            while (rs.next()){
                genres.add(rs.getLong("genres_id"));
            }
            return genres;
        } catch (SQLException e) {
            return null;
        }
    }
}
