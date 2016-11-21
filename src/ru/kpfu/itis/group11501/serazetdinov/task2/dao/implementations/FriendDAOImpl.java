package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.FriendDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.UserDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 11.11.2016.
 */
public class FriendDAOImpl implements FriendDAO {
    Connection conn = ConnectionSingleton.getConnection();
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public int countFriendsByUserId(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select count(*) from friends where user_id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            int count_friends = 0;
            if(rs.next()){
                count_friends = rs.getInt("count");
            }
            return count_friends;
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public List<User> getFriendsById(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from friends where user_id = ? and status = TRUE ");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            List<User>users = new ArrayList<>();
            while (rs.next()){
                User user = userDAO.getUserById(rs.getLong("follower_id"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void deleteFromFriends(long user_id, long friend_id) {
        try {
            PreparedStatement st = conn.prepareStatement("delete from friends where user_id = ? and follower_id = ?");
            st.setLong(1, user_id);
            st.setLong(2, friend_id);
            st.execute();
            st.setLong(1, friend_id);
            st.setLong(2, user_id);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addFriend(long current_user, long fr_id) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into friends(user_id, follower_id, status)values(?, ?, TRUE)");
            st.setLong(1, current_user);
            st.setLong(2, fr_id);
            st.execute();
            st.setLong(1, fr_id);
            st.setLong(2, current_user);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String isFriend(long id, long current_user) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from friends where user_id = ? and follower_id = ?");
            st.setLong(1, id);
            st.setLong(2, current_user);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                return "yep";
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
}
