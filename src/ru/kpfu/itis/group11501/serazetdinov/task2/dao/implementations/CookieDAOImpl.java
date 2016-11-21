package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.CookieDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 1 on 11.11.2016.
 */
public class CookieDAOImpl implements CookieDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public void createRelation(long id, String cookie) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into cookies (user_id, cookie)values(?, ?)");
            st.setLong(1, id);
            st.setString(2, cookie);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRelation(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("delete from cookies where user_id = ?");
            st.setLong(1, id);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getCookieById(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from cookies where user_id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            String s = null;
            if(rs.next()){
                s = rs.getString("cookie");
            }
            return s;
        } catch (SQLException e) {
            return null;
        }
    }
}
