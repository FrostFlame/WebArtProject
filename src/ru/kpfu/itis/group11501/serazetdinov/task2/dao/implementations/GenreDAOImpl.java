package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.GenreDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Genre;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 1 on 03.11.2016.
 */
public class GenreDAOImpl implements GenreDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public Genre getGenreByName(String genre) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * from genres where genre like ?");
            st.setString(1, "%" + genre + "%");
            ResultSet rs = st.executeQuery();
            Genre genr = null;
            while(rs.next()){
                genr = new Genre(rs.getLong("Id"), rs.getString("genre"));
            }
            return genr;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void createGenre(String genre) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into genres(genre)values(?)");
            st.setString(1, genre);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Genre getGenreById(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from genres where id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            Genre genre = null;
            if(rs.next()){
                genre = new Genre(rs.getLong("id"), rs.getString("genre"));
            }
            return genre;
        } catch (SQLException e) {
            return null;
        }
    }
}
