package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.AdminDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.Battle_commentDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 20.11.2016.
 */
public class AdminDAOImpl implements AdminDAO {
    Connection conn = ConnectionSingleton.getConnection();
    Battle_commentDAO battle_commentDAO = new Battle_commentDAOImpl();

    @Override
    public List<Object> getObjectsFromTable(String table) {
        try {
            List<Object> objects = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement("select * from " + table);
            ResultSet rs = st.executeQuery();
            if (table.equals("battle_comments")) {
                while (rs.next()) {
                    Battle_comment battle_comment = new Battle_comment(rs.getLong("id"), rs.getLong("user_id"),
                            rs.getLong("battle_id"), rs.getString("text"), rs.getTimestamp("date"));
                    objects.add(battle_comment);
                }
            } else if (table.equals("battles")) {
                while (rs.next()) {
                    Battle battle = new Battle(rs.getLong("id"), rs.getLong("from_user_id"), rs.getLong("to_user_id"),
                            rs.getString("title"), rs.getLong("from_image_id"), rs.getLong("to_image_id"), rs.getTimestamp("date"),
                            rs.getTimestamp("end_date"));
                    objects.add(battle);
                }
            } else if (table.equals("battles_genres")) {
                while (rs.next()) {
                    Battle_genre battle_genre = new Battle_genre(rs.getLong("id"), rs.getLong("genres_id"), rs.getLong("battles_id"));
                    objects.add(battle_genre);
                }
            } else if (table.equals("blacklist")) {
                while (rs.next()) {
                    Blacklist blacklist = new Blacklist(rs.getLong("id"), rs.getLong("user_id"), rs.getLong("follower_id"));
                    objects.add(blacklist);
                }
            } else if (table.equals("cookies")) {
                while (rs.next()) {
                    Cookie cookie = new Cookie(rs.getLong("user_id"), rs.getString("cookie"));
                    objects.add(cookie);
                }
            } else if (table.equals("favourite_genres")) {
                while (rs.next()) {
                    long genres_id = rs.getLong("genres_id");
                    Favourite_Genre favourite_genre = new Favourite_Genre(rs.getLong("id"), rs.getLong("user_id"), rs.getLong("genres_id"));
                    objects.add(favourite_genre);
                }
            } else if (table.equals("friends")) {
                while (rs.next()) {
                    Friend friend = new Friend(rs.getLong("id"), rs.getLong("user_id"), rs.getLong("follower_id"), rs.getBoolean("status"));
                    objects.add(friend);
                }
            } else if (table.equals("genres")) {
                while (rs.next()) {
                    Genre genre = new Genre(rs.getLong("id"), rs.getString("genre"));
                    objects.add(genre);
                }
            } else if (table.equals("images")) {
                while (rs.next()) {
                    Image image = new Image(rs.getLong("id"), rs.getString("link"));
                    objects.add(image);
                }
            } else if (table.equals("likes")) {
                while (rs.next()) {
                    Like like = new Like(rs.getLong("id"), rs.getLong("user_id"), rs.getLong("image_id"));
                    objects.add(like);
                }
            } else if (table.equals("messages")) {
                while (rs.next()) {
                    Message message = new Message(rs.getLong("id"), rs.getLong("from_user_id"), rs.getLong("to_user_id"),
                            rs.getString("text"), rs.getTimestamp("date"), rs.getBoolean("status"));
                    objects.add(message);
                }
            } else if (table.equals("news")) {
                while (rs.next()) {
                    News news = new News(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("text"),
                            rs.getTimestamp("date"), rs.getLong("image_id"));
                    objects.add(news);
                }
            } else if (table.equals("news_comments")) {
                while (rs.next()) {
                    News_comment news_comment = new News_comment(rs.getLong("id"), rs.getLong("user_id"), rs.getLong("news_id"),
                            rs.getString("text"), rs.getTimestamp("date"));
                    objects.add(news_comment);
                }
            } else if (table.equals("news_genres")) {
                while (rs.next()) {
                    News_genre news_genre = new News_genre(rs.getLong("id"), rs.getLong("news_id"), rs.getLong("genres_id"));
                    objects.add(news_genre);
                }
            } else if (table.equals("notifications")) {
                while (rs.next()) {
                    Notification notification = new Notification(rs.getLong("id"), rs.getLong("friend_id"), rs.getLong("like_id"),
                            rs.getLong("news_comment_id"), rs.getLong("battle_comment_id"), rs.getLong("battle_id"));
                    objects.add(notification);
                }
            } else if (table.equals("roles")) {
                while (rs.next()) {
                    Role role = new Role(rs.getLong("id"), rs.getString("role"));
                    objects.add(role);
                }
            } else if (table.equals("users")) {
                while (rs.next()) {
                    User user = new User(rs.getLong("Id"), rs.getString("login"), rs.getString("password"), rs.getLong("image_id"),
                            rs.getString("mail"), rs.getString("skype"), rs.getString("country"), rs.getString("city"),
                            rs.getString("education"), rs.getString("firstname"), rs.getString("lastname"),
                            rs.getInt("status_view"), rs.getInt("status_messages"), rs.getInt("status_notifications"),
                            rs.getInt("status_friends"), rs.getDate("birthdate"));
                    objects.add(user);
                }
            } else if (table.equals("users_roles")) {
                while (rs.next()) {
                    Users_Roles users_roles = new Users_Roles(rs.getLong("user_id"), rs.getLong("role_id"));
                    objects.add(users_roles);
                }
            }
            return objects;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public long getRoleId(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select role_id from users_roles where user_id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            long role_id = 0;
            if (rs.next()){
                role_id = rs.getLong("role_id");
            }
            return role_id;
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public List<String> getTables() {
        try {
            PreparedStatement st = conn.prepareStatement("select distinct table_name\n" +
                    "from information_schema.columns \n" +
                    "where table_schema='public'");
            ResultSet rs = st.executeQuery();
            List<String> tables = new ArrayList<>();
            while (rs.next()) {
                tables.add(rs.getString("table_name"));
            }
            return tables;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public List<String> getColumnsFromTable(String table) {
        try {
            PreparedStatement st = conn.prepareStatement("select distinct column_name\n" +
                    "from information_schema.columns \n" +
                    "where table_schema='public' and table_name=?");
            st.setString(1, table);
            ResultSet rs = st.executeQuery();
            List<String> columns = new ArrayList<>();
            while (rs.next()) {
                columns.add(rs.getString("column_name"));
            }
            return columns;
        } catch (SQLException e) {
            return null;
        }
    }
}
