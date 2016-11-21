package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.ImageDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Image;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 1 on 06.11.2016.
 */
public class ImageDAOImpl implements ImageDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public Image getImageById(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from Images where id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Image(rs.getLong("id"), rs.getString("link"));
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void createImage(String link) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into images(link)values (?)");
            st.setString(1, link);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image getImageByLink(String link) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from Images where link like ?");
            st.setString(1, "%" + link + "%");
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return new Image(rs.getLong("id"), rs.getString("link"));
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
}
