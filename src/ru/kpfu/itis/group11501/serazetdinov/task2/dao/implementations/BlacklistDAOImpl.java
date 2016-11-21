package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.BlacklistDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 1 on 06.11.2016.
 */
public class BlacklistDAOImpl implements BlacklistDAO {
    Connection conn = ConnectionSingleton.getConnection();

    @Override
    public List<User> getUsersByUser(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from Blacklist where user_id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            List<User>users = new LinkedList<>();
            while(rs.next()){
                UserService userService = new UserServiceImpl();
                users.add(userService.getUserById(rs.getLong("follower_id")));
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void deleteUser(long q, long user) {
        try {
            PreparedStatement st = conn.prepareStatement("delete from blacklist where follower_id = ? and user_id = ?");
            st.setLong(1, q);
            st.setLong(2, user);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
